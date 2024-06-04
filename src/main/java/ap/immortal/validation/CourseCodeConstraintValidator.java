package ap.immortal.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  implements ConstraintValidator<PostsalCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(PostsalCode postalCode) {
        coursePrefix = postalCode.value();
    }

    @Override
    public boolean isValid(String postalCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;

        if (postalCode != null) {
            result = postalCode.startsWith(coursePrefix);
        }
        else {
            result = false;
        }

        return result;
    }
}