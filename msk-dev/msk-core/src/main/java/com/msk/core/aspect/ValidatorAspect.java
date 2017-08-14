package com.msk.core.aspect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.msk.core.annotation.Validator;
import com.msk.core.annotation.ValidatorLevel;
import com.msk.core.base.BaseValidator;
import com.msk.core.bean.ExceptionMessage;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.exception.ValidatorException;

/**
 * ValidatorAspect.
 */
@Aspect
@Component
public class ValidatorAspect {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ValidatorAspect.class);

    private static Map<String, Method> VALIDATOR_METHOD_MAP = new HashMap<>();

    /**
     * controllerAspect
     */
    @Pointcut("@annotation(com.msk.core.annotation.Validator)")
    public void controllerAspect() {}

    /**
     * doBefore
     *
     * @param joinPoint joinPoint
     */
    @SuppressWarnings("unchecked")
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        Validator validator = method.getAnnotation(Validator.class);
        BaseValidator<Object> baseValidator = null;
        try {
            if (validator != null) {
                baseValidator = (BaseValidator<Object>) Class.forName(validator.validatorClass()).newInstance();
            } else {
                logger.warn("Validator实例获取失败[{},{}]", method.toString(), Validator.class.toString());
            }
        } catch (InstantiationException e) {
            logger.warn("Validator实例获取失败", e);
        } catch (IllegalAccessException e) {
            logger.warn("Validator实例获取失败", e);
        } catch (ClassNotFoundException e) {
            logger.warn("Validator实例获取失败", e);
        }
        if (baseValidator == null) {
            return;
        }
        ValidatorLevel validatorLevel = validator.level();
        // 验证实体对象
        Object entity = args[IntDef.INT_ZERO];

        if (validatorLevel == ValidatorLevel.WARN) {
            baseValidator.warnValidator(entity);
            args[IntDef.INT_ONE] = baseValidator.getExceptionMessageList();
        } else {
            baseValidator.validator(entity);
            List<ExceptionMessage> msgs = baseValidator.getExceptionMessageList();
            if (msgs != null && !msgs.isEmpty()) {
                ValidatorException ex = new ValidatorException(msgs);
                throw ex;
            }
        }
    }
}
