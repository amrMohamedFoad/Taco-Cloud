package tacos.Repos;


import org.springframework.data.repository.CrudRepository;

import tacos.Model.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
