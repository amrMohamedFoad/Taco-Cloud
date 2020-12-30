package tacos;

import tacos.Model.Order;

public interface OrderRepository {

	Order save(Order order);
}
