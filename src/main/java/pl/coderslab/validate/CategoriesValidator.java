package pl.coderslab.validate;

import pl.coderslab.category.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.List;

public class CategoriesValidator implements ConstraintValidator<Categories, List<Category>> {

    private int noOfCategories;
    @Override
    public void initialize(Categories constraintAnnotation) {
        this.noOfCategories = constraintAnnotation.value();

    }

    @Override
    public boolean isValid(List<Category> categories, ConstraintValidatorContext constraintValidatorContext) {
        if (categories == null){
            return false;
        }
        return categories.size() <= noOfCategories;
    }
}
