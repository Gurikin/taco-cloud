package tacos.data;

import tacos.entity.Order;

public interface OrderJdbcRepository {
    Order save(Order order);
}
