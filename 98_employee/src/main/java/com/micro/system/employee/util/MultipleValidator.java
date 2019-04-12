/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package com.micro.system.employee.util;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validate that the object is not <code>null</code>.
 *
 * @author Emmanuel Bernard
 */
public class MultipleValidator implements ConstraintValidator<Multiple, String> {

    private String[] args;

    @Override
    public void initialize(Multiple parameters) {
        this.args = parameters.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (null == value || "".equals(value)) {
            return true;
        }
        for (String str : args) {
            if (value.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
