package upload.web;

import java.io.File;
import java.net.URL;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.google.common.base.Strings;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.UploadResult;
import util.ZsUtil;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xc
 * @since 2019-05-29
 */
@Api(value = "图片上传Controller", tags = { "图片上传" })
@RestController
public class ImageController {

	Logger logger = (Logger) LoggerFactory.getLogger(ImageController.class);

	final static String bucketName = "zs-1256779886";
	private static String accessKeyId = "AKIDAI4PaeVf8QXlDUnnmahx9B4nLMNurYea";
	private static String accessSecretKey = "yBVkeMwMbtZ3VmsoZBh8OTOLE4E7Vn16";
	private static String serverUrl = "https://zs-1256779886.cos.ap-shenzhen-fsi.myqcloud.com";

	@ApiOperation(value = "图片上传接口-无水印")
	@ApiImplicitParam(name = "HttpServletRequest", value = "图片文件")
	@PostMapping(value = "/api/uploadpic")
	public Result uploadpic(final HttpServletRequest request) {
		return uploadBase(request);
	}

	@ApiOperation(value = "图片上传接口-加水印")
	@ApiImplicitParam(name = "HttpServletRequest", value = "图片文件")
	@PostMapping(value = "/api/uploadpic_mark")
	public Result uploadpicNomark(final HttpServletRequest request) {
		return uploadBase(request);
	}

	private Result uploadBase(final HttpServletRequest request) {
		try {

			final MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = multipartRequest.getFile("Filedata");
			if (multipartFile == null) {
				multipartFile = multipartRequest.getFile("file");
			}
			// 1.校验图片或视频的类型
			final String sourceName = multipartFile.getOriginalFilename(); // 原始文件名
			if (Strings.isNullOrEmpty(sourceName)) {
				return ResultFactory.generateResult(ResultConstans.ERROR_CODE, "文件名读取失败");
			}
			String fileType = sourceName.substring(sourceName.lastIndexOf('.') + 1);
			fileType = Strings.isNullOrEmpty(fileType) ? fileType : fileType.toLowerCase();
			final String fileTypeCheck = ",jpg,png,bmp,gif,jpeg,";
			if (fileTypeCheck.indexOf("," + fileType + ",") == -1) {
				return ResultFactory.generateResult(ResultConstans.ERROR_CODE,
						"图片或视频格式不对，目前支持的文件格式：jpg,png,bmp,gif,jpeg");
			}

			// 2.cdn路径
			final String objectKey = ZsUtil.getNewGUID() + sourceName;
			// 3.上传。
			// 1 初始化用户身份信息（secretId, secretKey）。
			final COSCredentials cred = new BasicCOSCredentials(accessKeyId, accessSecretKey);
			// 2 设置bucket的区域, COS地域的简称请参照
			final ClientConfig clientConfig = new ClientConfig(new Region("ap-shenzhen-fsi"));
			// 3 生成 cos 客户端。
			final COSClient cosClient = new COSClient(cred, clientConfig);
			// 指定要上传到 COS 上的路径
			final String key = "/zs/" + objectKey;
			File localFile = null;
			try {
				localFile = File.createTempFile("temp", null);
				multipartFile.transferTo(localFile);
				final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
				// 上传
				cosClient.putObject(putObjectRequest);
				// 设置url有效时间
				final Date expiration = new Date(new Date().getTime() + 60 * 60 * 1000000);
				// 获取上传文件路径
				final URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
				// 设置返回参数
				final UploadResult result = new UploadResult();
				result.setUrl(serverUrl + url.getPath());
				result.setFileSize((localFile.length() / 1024) + "KB");
				return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, result);
			} catch (final Exception e) {
				e.printStackTrace();
				// 关闭客户端(关闭后台线程)
				cosClient.shutdown();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			logger.info("upload", e);
		}
		return ResultFactory.generateResult(ResultConstans.ERROR_CODE, "图片或视频上传失败");
	}

	// @ApiOperation(value="图片上传接口-base64")
	// @ApiImplicitParam(name="file",value="base64图片码")
	// @PostMapping(value = "/uploadBase64")
	// public Result uploadBase64(HttpServletRequest request, String file) {
	// try {
	// logger.info("mamon图片头像上传");
	// System.out.println("base64图片码："+"\r\n"+file.toString());
	//
	//
	// MultipartFile multipartFile = MyTools.base64ToMultipart(file.toString());
	//
	// if(multipartFile==null){
	// return ResultFactory.generateResult(ResultConstants.PICNULL_ERROR_CODE,
	// ResultConstants.PICNULL_ERROR_MSG);
	// }
	//
	// //1.校验图片类型
	// String sourceName = multipartFile.getOriginalFilename(); // 原始文件名
	// String fileType = sourceName.substring(sourceName.lastIndexOf(".")+1);
	// String fileTypeCheck = ",jpg,png,bmp,gif,jpeg,";
	// if(fileTypeCheck.indexOf(","+fileType+",")==-1){
	// return ResultFactory.generateResult(ResultConstants.PICTYPE_ERROR_CODE,
	// ResultConstants.PICTYPE_ERROR_MSG);
	// }
	//
	//
	// //2.图片路径
	// String datefolder = MyTools.myParseDateToString(new Date(),
	// "yyyyMMdd");//日期
	// File folder = new File(FILE_PIC_ROOT + datefolder);//文件夹
	// if(!folder.exists()){
	// folder.mkdirs();
	// }
	//
	// String fileid = UniqueStringGenerator.get32UUID();
	// String filePath = FILE_PIC_ROOT + datefolder + File.separator +
	// fileid+"."+fileType;
	//
	//
	// //3.上传
	// File source = new File(filePath);
	// multipartFile.transferTo(source);
	//
	//
	//// // 给图片加水印
	//// if (mark && !MyTools.isNullOrEmpty(FileUtil.LOGO_PATH_NEW)) {
	//// System.out.println(FileUtil.LOGO_PATH_NEW);
	//// ImageMarkLogoUtil.markImageByIcon(FileUtil.LOGO_PATH_NEW,
	// filePath,filePath);
	//// }
	//
	// //图片等比列压缩
	//// thumbnail_w_h(source, WIDTH_PX, HEIGHT_PX, null);
	//
	//// BufferedImage src = ImageIO.read(source); //构造Image对象
	//// int width=src.getWidth(null); //得到源图宽
	//// int height=src.getHeight(null); //得到源图长
	//
	//// boolean saveRes =
	// fileService.saveFileInfo(fileid,datefolder,sourceName,fileType,width,height,0);
	//
	//
	// //保存记录到数据库
	// //获取的是本地的IP地址
	//// InetAddress address = InetAddress.getLocalHost();
	//// String hostAddress = address.getHostAddress();
	//// String hostAddress=getLocalHostLANAddress().getHostAddress();
	// MaFile info=new MaFile();
	// info.setCrateTime(new Date());
	//// String
	// url="http://"+SERVER_FILE_PATH+":8181/pic"+datefolder+"/"+fileid+"."+fileType;
	// String url = SERVER_FILE_PATH+"pic/pic" + datefolder + "/" + fileid + "."
	// + fileType;
	// info.setUrl(url);
	// info.setTypeStr(fileType);
	// info.setType(1);
	// info.setUuid(fileid);
	// info.setSourceName(sourceName);
	// info.setSize(String.valueOf(multipartFile.getSize()));
	// int i=maFileService.saveSelect(info);
	//
	//// if(saveRes){
	//// String downloadurl =
	// FILESERVER_IP_AND_PORT+"/fileclient/api/cream/downloadpic.do?fileid="+fileid;//下载地址
	//// return ResultUtil.resultCodeJson(ResultUtil.RESULT_CODE_0, downloadurl,
	// "图片上传成功");
	//// }
	// Map<String, Object> result=new HashMap<>();
	//
	// if(1==i){
	// result.put("fid", info.getFid());
	// result.put("url", url);
	// result.put("fileType", fileType);
	// result.put("fileSize", multipartFile.getSize());
	// return ResultFactory.generateResult(ResultConstants.SUCCESS_CODE,
	// ResultConstants.SUCCESS_MSG,result);
	// }
	// } catch (Exception e) {
	// logger.error("mamon图片上传异常,原因："+e);
	// }
	// logger.info("mamon图片上传失败");
	// return ResultFactory.generateResult(ResultConstants.ERROR_CODE,
	// ResultConstants.ERROR_CODE);
	// }
	//
	//
	// /**
	// * base64转Multipart
	// * @param String base64
	// * */
	// public static MultipartFile base64ToMultipart(String base64) {
	// try {
	// String[] baseStrs = base64.split(",");
	//
	// BASE64Decoder decoder = new BASE64Decoder();
	// byte[] b = new byte[0];
	// b = decoder.decodeBuffer(baseStrs[1]);
	//
	// for (int i = 0; i < b.length; ++i) {
	// if (b[i] < 0) {
	// b[i] += 256;
	// }
	// }
	//
	// return new BASE64DecodedMultipartFile(b, baseStrs[0]);
	// } catch (IOException e) {
	// e.printStackTrace();
	// return null;
	// }
	// }
}
