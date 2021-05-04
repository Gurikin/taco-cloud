package tacos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
public class BaseEntity {
    protected String id;

    @EqualsAndHashCode.Exclude
    protected LocalDateTime createdAt;
}
