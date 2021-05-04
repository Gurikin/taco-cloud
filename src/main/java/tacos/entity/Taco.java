package tacos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Taco extends BaseEntity {
    @NotNull
    @Size(min = 5, message = "The name must be at least 5 character long")
    private String name;
    @Size(min = 1, message = "Choose 1 ingredient at least, please")
    private List<String> ingredients;
}
