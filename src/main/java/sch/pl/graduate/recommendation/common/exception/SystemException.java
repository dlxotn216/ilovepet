/*
 * 프로그램에 대한 저작권을 포함한 지적재산권은 씨알에스큐브(주)에 있으며, 씨알에스큐브(주)가 명시적으로 허용하지 않은 
 * 사용, 복사, 변경, 제3자에의 공개, 배포는 엄격히 금지되며, 씨알에스큐브(주)의 지적 재산권 침해에 해당됩니다.
 * (Copyright ⓒ 2017 CRScube Co., Ltd. All Rights Reserved| Confidential)
 */
package sch.pl.graduate.recommendation.common.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class SystemException extends NestedRuntimeException {

    private static final long serialVersionUID = 1251649502162890197L;

    protected HttpStatus httpStatus;
    protected Integer errorCode;
    protected Date occuredDate;
    protected String className;
    protected String methodName;
    protected int line;
    protected Object[] msgArgs;
    protected String errorMsg;

    public SystemException() {
        super(null);
        populate(HttpStatus.INTERNAL_SERVER_ERROR, null, null, null);
    }

    public SystemException(HttpStatus httpStatus) {
        super(null);
        populate(httpStatus, null, null, null);
    }

    public SystemException(HttpStatus httpStatus, Integer errorCode) {
        super(null);
        populate(httpStatus, errorCode, null, null);
    }

    public SystemException(HttpStatus httpStatus, Integer errorCode, Object[] msgArgs) {
        super(null);
        populate(httpStatus, errorCode, msgArgs, null);
    }

    public SystemException(HttpStatus httpStatus, Integer errorCode, Object[] msgArgs, String message) {
        super(message);
        populate(httpStatus, errorCode, msgArgs, message);
    }

    public SystemException(
            HttpStatus httpStatus,
            Integer errorCode,
            Object[] msgArgs,
            String message,
            Throwable cause) {
        super(message, cause);
        populate(httpStatus, errorCode, msgArgs, message);
    }

    public SystemException(HttpStatus httpStatus, Integer errorCode, Object[] msgArgs, Throwable cause) {
        super(null, cause);
        if (cause instanceof SystemException) {
            SystemException se = (SystemException) cause;
            populate(se.getHttpStatus(), errorCode, msgArgs, se.getErrorMsg());
        } else {
            populate(httpStatus, errorCode, msgArgs, null);
        }
    }

    public SystemException(HttpStatus httpStatus, Integer errorCode, String message) {
        super(message);
        populate(httpStatus, errorCode, null, message);
    }

    public SystemException(HttpStatus httpStatus, Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        populate(httpStatus, errorCode, null, message);
    }

    public SystemException(HttpStatus httpStatus, Integer errorCode, Throwable cause) {
        super(null, cause);
        populate(httpStatus, errorCode, null, null);
    }

    public SystemException(HttpStatus httpStatus, String message) {
        super(message);
        populate(httpStatus, null, null, message);
    }

    public SystemException(Integer errorCode) {
        super(null);
        populate(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, null, null);
    }

    public SystemException(Integer errorCode, Object[] msgArgs) {
        super(null);
        populate(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, msgArgs, null);
    }

    public SystemException(Integer errorCode, Object[] msgArgs, String message) {
        super(message);
        populate(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, msgArgs, message);
    }

    public SystemException(Integer errorCode, Object[] msgArgs, String message, Throwable cause) {
        super(message, cause);
        if (cause instanceof SystemException) {
            SystemException se = (SystemException) cause;
            populate(se.getHttpStatus(), errorCode, msgArgs, message);
        } else {
            populate(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, msgArgs, message);
        }
    }

    public SystemException(Integer errorCode, String message) {
        super(message);
        populate(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, null, message);
    }

    public SystemException(Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        if (cause instanceof SystemException) {
            SystemException se = (SystemException) cause;
            populate(se.getHttpStatus(), errorCode, null, message);
        } else {
            populate(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, null, message);
        }
    }

    public SystemException(Integer errorCode, Throwable cause) {
        super(null, cause);
        if (cause instanceof SystemException) {
            SystemException se = (SystemException) cause;
            populate(se.getHttpStatus(), errorCode, null, se.getErrorMsg());
        } else {
            populate(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, null, null);
        }
    }

    public SystemException(String message) {
        super(message);
        populate(HttpStatus.INTERNAL_SERVER_ERROR, null, null, message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
        if (cause instanceof SystemException) {
            SystemException se = (SystemException) cause;
            populate(se.getHttpStatus(), null, null, message);
        } else {
            populate(HttpStatus.INTERNAL_SERVER_ERROR, null, null, message);
        }
    }

    public SystemException(Throwable cause) {
        super(cause.getMessage(), cause);
        if (cause instanceof SystemException) {
            SystemException se = (SystemException) cause;
            populate(se.getHttpStatus(), se.getErrorCode(), se.getMsgArgs(), se.getErrorMsg());
        } else {
            populate(HttpStatus.INTERNAL_SERVER_ERROR, null, null, null);
        }
    }

    public String getClassName() {
        return className;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getLine() {
        return line;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getMsgArgs() {
        return msgArgs;
    }

    public Date getOccuredDate() {
        return occuredDate;
    }

    protected void populate(HttpStatus httpStatus, Integer errorCode, Object[] msgArgs, String errorMsg) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.occuredDate = new Date();
        this.msgArgs = msgArgs;
        this.errorMsg = errorMsg;

        StackTraceElement[] stackTraceElements = this.getStackTrace();
        if (stackTraceElements.length > 0) {
            StackTraceElement ste = stackTraceElements[0];
            this.className = ste.getClassName();
            this.methodName = ste.getMethodName();
            this.line = ste.getLineNumber();
        }
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setMsgArgs(Object[] msgArgs) {
        this.msgArgs = msgArgs;
    }

    public void setOccuredDate(Date occuredDate) {
        this.occuredDate = occuredDate;
    }

}
