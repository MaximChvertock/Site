package by.chvertock.web.site.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class NewUserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == NewUserForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        NewUserForm newUserForm = (NewUserForm) target;

        // TODO: validate name and password length

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "new_user_form.name.is_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "new_user_form.password.is_empty");
    }
}
