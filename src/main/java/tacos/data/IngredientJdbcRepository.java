package tacos.data;

import tacos.entity.Ingredient;

import java.util.Collection;

public interface IngredientJdbcRepository {
    Collection<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);
}
