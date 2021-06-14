package tacos.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Ingredient extends BaseEntity {
    private final String name;
    private final Type type;

    public Ingredient(String id, LocalDateTime createdAt, String name, Type type) {
        super(id, createdAt);
        this.name = name;
        this.type = type;
    }

    public Ingredient(String id, String name, Type type) {
        super(id, LocalDateTime.now());
        this.name = name;
        this.type = type;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
    }
}
