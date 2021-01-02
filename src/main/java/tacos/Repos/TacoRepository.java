package tacos.Repos;

import org.springframework.data.repository.CrudRepository;

import tacos.Model.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long>{

}
