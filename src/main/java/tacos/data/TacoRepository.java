package tacos.data;

import org.springframework.stereotype.Repository;
import tacos.entity.Taco;

@Repository
public interface TacoRepository extends BaseRepository<Taco> {
}
