package backstage.web.webapi.base;


import backstage.model.vo.admin.ResultLoginVo;
import constant.Constant;
import dto.LoginAuthDto;
import enums.ErrorCodeEnum;
import exception.BusinessException;
import util.PublicUtil;
import util.ThreadLocalMap;
import wrapper.WrapMapper;
import wrapper.Wrapper;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/9 10:34
 * @description The class Base controller.
 *
 */
public class BaseController {

    /**
     * Handle result wrapper.
     *
     * @param <T>    the type parameter
     * @param result the result
     * @return the wrapper
     */
    protected <T> Wrapper<T> handleResult(T result) {
        boolean flag = isFlag(result);
        if (flag) {
            return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功", result);
        } else {
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "操作失败", result);
        }
    }

    /**
     * Judge the flag
     *
     * @param result
     * @return the flag
     */
    private boolean isFlag(Object result) {
        boolean flag;
        if (result instanceof Integer) {
            flag = (Integer) result > 0;
        } else if (result instanceof Boolean) {
            flag = (Boolean) result;
        } else {
            flag = PublicUtil.isNotEmpty(result);
        }
        return flag;
    }

    /**
     * Gets login auth dto.
     *
     * @return the login auth dto
     */
    protected LoginAuthDto getLoginAuthDto(){
        ResultLoginVo resultLoginVo = (ResultLoginVo) ThreadLocalMap.get(Constant.TOKEN_AUTH_TDO);
        LoginAuthDto loginAuthDto = resultLoginVo.getLoginAuthDto();
        if (PublicUtil.isEmpty(loginAuthDto)){
            throw new BusinessException(ErrorCodeEnum.AUTH10010009);
        }
        return loginAuthDto;
    }

}