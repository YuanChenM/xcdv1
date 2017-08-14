package com.msk.core.exception;

import java.util.List;

import com.msk.core.bean.ExceptionMessage;

/**
 * Validator 异常处理
 * 
 * @author Administrator
 *
 */
public class ValidatorException extends BusinessException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * The Constructors Method.
     *
     * @param ExceptionMessages the messages
     */
    public ValidatorException(List<ExceptionMessage> ExceptionMessages) {
        super(ExceptionMessages);
    }

    /**
     * Get the validator messages.
     *
     * @return the validator messages
     */
    public List<ExceptionMessage> getValidatorMessages() {
        return this.getExceptionMessages();
    }
}
