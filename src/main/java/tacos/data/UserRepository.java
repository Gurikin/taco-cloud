package tacos.data;

import java.util.Optional;
import tacos.entity.User;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);
}
