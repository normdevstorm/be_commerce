package com.normdevstorm.commerce_platform.config.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CustomPhoneNumValidation {
    ///todo: Specifically validates Viet Nam phone numbers
    String message() default "Phone number should comply to this format '${ConstantManager.phoneNumbeFormat}'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
