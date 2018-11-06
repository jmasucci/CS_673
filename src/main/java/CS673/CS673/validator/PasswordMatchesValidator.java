package CS673.CS673.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import CS673.CS673.code.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	
	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto user = (UserDto) obj;
		return user.getPassword().equals(user.getConfirmpw());
	}
}
