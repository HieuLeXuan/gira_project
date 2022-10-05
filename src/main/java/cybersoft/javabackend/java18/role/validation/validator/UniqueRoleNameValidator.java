package cybersoft.javabackend.java18.role.validation.validator;

import cybersoft.javabackend.java18.role.model.Role;
import cybersoft.javabackend.java18.role.repository.RoleRepository;
import cybersoft.javabackend.java18.role.validation.annotation.UniqueRoleName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName, String> {
    private String message;
    private RoleRepository roleRepository;

    public UniqueRoleNameValidator(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initialize(UniqueRoleName constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        Optional<Role> roleOptional = roleRepository.findByName(name);

        if (roleOptional.isPresent())
            return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
