package cybersoft.javabackend.java18.role.model;

import cybersoft.javabackend.java18.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = RoleEntity.Operation.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = "uc_service_g_name", columnNames = {"G_NAME"})
})
public class Operation extends BaseEntity {

    @Column(name = RoleEntity.Operation.NAME, unique = true, length = 100)
    private String name;

    @Column(name = RoleEntity.Operation.CODE, unique = true)
    private String code;

    @Column(name = RoleEntity.Operation.DESCRIPTION)
    private String description;

    @Column(name = RoleEntity.Operation.TYPE, nullable = false)
    private Type type;

    public enum Type {
            SAVE_OR_UPDATE,
            FETCH,
            REMOVE
    }
}
