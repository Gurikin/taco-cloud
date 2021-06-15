package tacos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Taco")
public class Taco extends BaseEntity {
    @NotNull
    @Size(min = 5, message = "The name must be at least 5 character long")
    private String name;

    @NotNull
    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You should choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
