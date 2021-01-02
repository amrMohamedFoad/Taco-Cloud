package tacos.Repos;

import org.springframework.data.repository.CrudRepository;

import tacos.Model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
