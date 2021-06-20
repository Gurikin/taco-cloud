package tacos.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
@Entity
public class Ingredient extends BaseEntity {
    private final String name;
    @Enumerated(EnumType.STRING)
    private final Type type;

    public Ingredient(String id, LocalDateTime createdAt, String name, String type) {
        super(id, createdAt);
        this.name = name;
        this.type = Type.getTypeByName(type);
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;

        public static Type getTypeByName(String name) {
            return valueOf(name);
        }
    }
}
