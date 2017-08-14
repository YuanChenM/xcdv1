package com.msk.core.exception;

import java.util.List;

import com.msk.core.bean.ExceptionMessage;

/**
 * 系统异常类
 * @author jiang_nan
 *
 */
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
     * Constructs a new exception with the specified detail message. The cause
     * is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public SystemException() {
        super("系统异常");
    }

    /**
     * 得到BusinessMessage的message string
     * @param titleMessage
     * @param businessMessages
     * @return
     */
    protected static<T extends ExceptionMessage> String fetchMessage(String titleMessage, List<T> businessMessages){
        String message = titleMessage==null?"系统异常":titleMessage;
        if(businessMessages!=null){
            for (ExceptionMessage businessMessage : businessMessages) {
                message+=businessMessage.getMessage()+";";
            }
        }
        return message;
    }
    /**
     * Constructs a new exception with the specified detail message. The cause
     * is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     * 
     * @param message
     *        the detail message. The detail message is saved for later
     *        retrieval by the {@link #getMessage()} method.
     */
    public SystemException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with <code>cause</code> is <i>not</i> automatically incorporated in this
     * exception's detail message.
     * 
     * @param cause
     *        the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt> value
     *        is
     *        permitted, and indicates that the cause is nonexistent or
     *        unknown.)
     * @since 1.4
     */
    public SystemException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with <code>cause</code> is <i>not</i> automatically incorporated in this
     * exception's detail message.
     * 
     * @param message
     *        the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     * @param cause
     *        the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt> value
     *        is
     *        permitted, and indicates that the cause is nonexistent or
     *        unknown.)
     * @since 1.4
     */
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
