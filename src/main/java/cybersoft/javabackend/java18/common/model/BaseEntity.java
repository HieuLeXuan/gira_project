package cybersoft.javabackend.java18.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import cybersoft.javabackend.java18.common.util.DateTimeUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/***
 * nhan biet trong java
 * dung anotaion @MappedSuperclass nay moi cho cac class khac ke thua xuong
 * database
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    /**
     * protected de lop con moi truy cap duoc
     */
    @Id // anotation cho khoa chinh
    @Type(type = "uuid-char")   // dinh dang kieu cho id (string)
    @GeneratedValue // tu dong sinh ra id
    @Column(name = Columns.ID)    // khong hart code cho name column
    protected UUID id;

    @Version
    @Column(name = Columns.VERSION)
    protected int version;

    @CreatedBy
    @Column(name = Columns.CREATE_BY)
    protected String createdBy;

    @DateTimeFormat(pattern = DateTimeUtils.DATETIME_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATETIME_FORMAT)
    @CreatedDate
    @Column(name = Columns.CREATE_AT)
    protected LocalDateTime createAt;

    @LastModifiedBy
    @Column(name = Columns.LAST_MODIFIED_BY)
    protected String lastModifiedBy;

    @DateTimeFormat(pattern = DateTimeUtils.DATETIME_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATETIME_FORMAT)
    @LastModifiedDate
    @Column(name = Columns.CREATE_MODIFIED_AT)
    protected LocalDateTime createModifiedAt;

    // inner class
    @UtilityClass
    static class Columns {
        static final String ID = "ID";
        static final String VERSION = "VERSION";
        static final String CREATE_BY = "CREATE_BY";
        static final String CREATE_AT = "CREATE_AT";
        static final String LAST_MODIFIED_BY = "LAST_MODIFIED_BY";
        static final String CREATE_MODIFIED_AT = "CREATE_MODIFIED_AT";
    }
}
