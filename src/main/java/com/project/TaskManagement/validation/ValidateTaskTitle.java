package com.project.TaskManagement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

//This specifies that the annotation can be applied to classes, fields, and other annotations
@Target({TYPE, FIELD, ANNOTATION_TYPE,PARAMETER})
//This indicates that the annotation should be retained by the JVM at runtime.
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = TaskTitleValidator.class)
public @interface ValidateTaskTitle {
    String message() default "Content should have a characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
