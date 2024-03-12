package com.project.TaskManagement.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.time.LocalDateTime;
import java.util.Date;

public class PresentOrFutureValidator implements ConstraintValidator<PresentOrFuture, LocalDateTime > {


    @Override
    public boolean isValid(LocalDateTime  date, ConstraintValidatorContext constraintValidatorContext) {
        if(date==null)return false;
        LocalDateTime now = LocalDateTime.now();
        return date.isAfter(now) || date.isEqual(now);

    }
}
