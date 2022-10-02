package cybersoft.javabackend.java18.role.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    // data transfer object
    private UUID id;

    private String name;

    private String code;

    private String description;
}
