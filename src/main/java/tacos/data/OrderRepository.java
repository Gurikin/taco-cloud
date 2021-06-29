package tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tacos.entity.Order;
import tacos.entity.User;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order> {
    List<Order> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}
