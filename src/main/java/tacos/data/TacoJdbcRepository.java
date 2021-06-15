package tacos.data;

import tacos.entity.Taco;

public interface TacoJdbcRepository {
    Taco save(Taco taco);
}
