package backstage.exceptions;

import enums.ErrorCodeEnum;
import exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: liqun
 * @since: 2018/9/26:10:18
 * @description: The class Auth biz exception
 */
@Slf4j
public class AuthBizException extends BusinessException {

    /**
     * Instantiates a new Auth rpc exception
     */
    public AuthBizException() {
    }

    /**
     * Instantiates a new Auth rpc exception
     *
     * @param code
     * @param msgFormat
     * @param args
     */
    public AuthBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
        log.info("<== AuthRpcException,code:" + this.code + ",message:" + super.getMessage());
    }

    /**
     * Instantiates a new Auth rpc exception
     *
     * @param code
     * @param msg
     */
    public AuthBizException(int code, String msg) {
        super(code, msg);
        log.info("<== AuthRpcException,code:" + this.code + ",message:" + super.getMessage());
    }

    /**
     * Instantiates a new Auth rpc exception
     *
     * @param codeEnum
     */
    public AuthBizException(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        log.info("<== AuthRpcException,code:" + this.code + ",message:" + super.getMessage());
    }

    /**
     * Instantiates a new Auth rpc exception
     *
     * @param codeEnum
     * @param args
     */
    public AuthBizException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        log.info("<== AuthRpcException,code:" + this.code + ",message:" + super.getMessage());
    }

}
