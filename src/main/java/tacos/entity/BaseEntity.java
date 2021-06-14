package tacos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    protected String id;

    @EqualsAndHashCode.Exclude
    protected LocalDateTime createdAt;
}
