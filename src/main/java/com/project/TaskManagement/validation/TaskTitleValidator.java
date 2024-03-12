package com.project.TaskManagement.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class TaskTitleValidator implements ConstraintValidator<ValidateTaskTitle,String> {







    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.length()<4){
            //Let other validator handle this case
            return true;
        }
        String regex = "^.*[a-zA-Z].*$";

        return s.matches(regex);
    }
}
