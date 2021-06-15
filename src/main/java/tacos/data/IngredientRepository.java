package tacos.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.entity.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    @Override
    @Query("Select i from Ingredient i")
    List<Ingredient> findAll();
}
