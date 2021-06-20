package tacos.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tacos.entity.Ingredient;

@Repository
public interface IngredientRepository extends BaseRepository<Ingredient> {
    @Override
    @Query("Select i from Ingredient i")
    List<Ingredient> findAll();
}
