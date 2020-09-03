package backstage.web;

import enums.ErrorCodeEnum;
import exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wrapper.WrapMapper;
import wrapper.Wrapper;

import java.nio.file.AccessDeniedException;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/9 11:14
 * @description 全局的的异常拦截器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @Value("${spring.profiles.active}")
//    String profile;
//    @Value("${spring.application.name}")
//    String applicationName;
//    @Autowired
//    private TaskExecutor taskExecutor;
//    @Autowired
//    private MdcExceptionLogFeignApi mdcExceptionLogFeignApi;

    /**
     * 参数非法异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper illegalArgumentException(IllegalArgumentException e) {
        log.error("参数非法异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990100.code(), e.getMessage());
    }

    /**
     * 参数必填校验异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper bindException(BindException e) {
        log.error("参数必填校验异常={}", e.getBindingResult().getFieldError().getDefaultMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990100.code(), e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 参数校验异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper bindException(MethodArgumentNotValidException e) {
        log.error("参数校验异常={}", e.getBindingResult().getFieldError().getDefaultMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990100.code(), e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 业务异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper businessException(BusinessException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(e.getCode() == 0 ? Wrapper.ERROR_CODE : e.getCode(), e.getMessage());
    }

    /**
     * 处理业务信息提示
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(BusinessBackInfo.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Wrapper businesInfo(BusinessBackInfo e) {
//        log.error("业务提示返回={}", e.getMessage());
//        return WrapMapper.wrap(e.getCode() == 0 ? Wrapper.ERROR_CODE : e.getCode(), e.getMessage());
//    }

    /**
     * 无权限访问.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Wrapper unAuthorizedException(AccessDeniedException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg());
    }

    /**
     * 全局异常信息记录
     *
     * @param e
     * @return the wrapper
     */
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public Wrapper exception(Exception e) {
//        log.info("保存全局异常信息 e={}", e.getMessage(), e);
////		taskExecutor.execute(() -> {
////			GlobalExceptionLogDto globalExceptionLogDto = new GlobalExceptionLogDto().getGlobalExceptionLogDto(e,profile,applicationName);
////			mdcExceptionLogFeignApi.saveAndSendExceptionLog(globalExceptionLogDto);
////		});
//        GlobalExceptionLogDto globalExceptionLogDto = new GlobalExceptionLogDto().getGlobalExceptionLogDto(e, profile, applicationName);
//        mdcExceptionLogFeignApi.saveAndSendExceptionLog(globalExceptionLogDto);
//        return WrapMapper.error();
//    }


}
