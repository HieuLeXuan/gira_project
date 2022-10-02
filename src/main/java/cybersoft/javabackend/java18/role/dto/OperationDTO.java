package cybersoft.javabackend.java18.role.dto;

import cybersoft.javabackend.java18.role.model.Operation;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationDTO {

    private UUID id;

    private String name;

    private String code;

    private String description;

    private Operation.Type type;
}
