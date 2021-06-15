package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;
import tacos.entity.Ingredient;
import tacos.entity.Taco;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Arrays.asList;

@Repository
public class JdbcTacoRepository implements TacoJdbcRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Taco save(Taco taco) {
        String tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        taco.getIngredients().forEach(ingredient -> saveIngredientToTaco(ingredient, tacoId));
        return taco;
    }

    private String saveTacoInfo(Taco taco) {
        taco.setCreatedAt(LocalDateTime.now());
        taco.setId(UUID.randomUUID().toString());
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into Taco (id, name, createdAt) values (?, ?, ?)",
                Types.VARCHAR,
                Types.VARCHAR,
                Types.TIMESTAMP
        ).newPreparedStatementCreator(asList(taco.getId(), taco.getName(), Timestamp.valueOf(taco.getCreatedAt())));
        jdbcTemplate.update(psc);
        return String.valueOf(taco.getId());
    }

    private void saveIngredientToTaco(Ingredient ingredient, String tacoId) {
        jdbcTemplate.update(
                "insert into taco_ingredients (taco, ingredient) values (?, ?)", tacoId, ingredient.getId()
        );
    }
}
