package backstage.web.webapi.operate;


import backstage.entity.Activity;
import backstage.service.IActivityService;
import backstage.service.IBannerService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.Topic;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import request.activity.ActivityParameter;
import request.activity.BannerParameter;
import request.activity.QueryActivityPageParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.activity.ActivityResult;
import result.vo.activity.AidAndTitleResult;
import result.vo.activity.BannerAndActivityResult;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * banner信息表 前端控制器
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-27
 */
@Api(value = "NoticeController", tags = {"公告"})
@RestController
@RequestMapping("/notice")
public class NoticeController {

  
}