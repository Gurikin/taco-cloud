package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.entity.Order;

public interface OrderJdbcRepository {
    Order save(Order order);
}