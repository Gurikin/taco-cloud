package tacos.data;

import org.springframework.stereotype.Repository;
import tacos.entity.Order;

@Repository
public interface OrderRepository extends BaseRepository<Order> {
}
