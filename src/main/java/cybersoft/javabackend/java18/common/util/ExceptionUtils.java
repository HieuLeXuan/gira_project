package cybersoft.javabackend.java18.common.util;

import lombok.experimental.UtilityClass;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ExceptionUtils {
    public static final String DEFAULT_UNEXPECTED_MESSAGE = "Ops! Something wrong happens...";

    public List<String> getErrors(ConstraintViolationException exception) {
        return exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }

    public static List<String> getErrors(RuntimeException exception) {
        List<String> list = new ArrayList<String>();
        list.add(DEFAULT_UNEXPECTED_MESSAGE);
        return list;
    }

    public static List<String> getErrors(MethodArgumentNotValidException exception) {
        return exception.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }
}
