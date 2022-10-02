package cybersoft.javabackend.java18.role.model;

import cybersoft.javabackend.java18.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = RoleEntity.Role.TABLE_NAME)
public class Role extends BaseEntity {  // Panache

    @Column(name = RoleEntity.Role.NAME, unique = true, length = 100)
    private String name;

    @Column(name = RoleEntity.Role.CODE, unique = true)
    private String code;

    @Column(name = RoleEntity.Role.DESCRIPTION)
    private String description;
}
