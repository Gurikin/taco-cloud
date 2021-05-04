package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.entity.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository
public class JdbcIngredientRepositoryImpl implements IngredientRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int i) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }

    @Override
    public Ingredient findById(String id) {
        return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?",
                (resultSet, i) -> new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type"))
                ));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient values(?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
