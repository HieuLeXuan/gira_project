package cybersoft.javabackend.java18.role.validation.validator;

import cybersoft.javabackend.java18.role.model.Role;
import cybersoft.javabackend.java18.role.repository.RoleRepository;
import cybersoft.javabackend.java18.role.validation.annotation.UniqueRoleCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRoleCodeValidator implements ConstraintValidator<UniqueRoleCode, String> {

    private String message;
    private RoleRepository roleRepository;

    public UniqueRoleCodeValidator(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void initialize(UniqueRoleCode constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Role role = roleRepository.findByCode(code);

        if (role != null)
            return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
