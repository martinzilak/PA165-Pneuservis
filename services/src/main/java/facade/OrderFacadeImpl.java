package facade;

import cz.muni.fi.pa165.pneuservis.backend.entity.Customer;
import cz.muni.fi.pa165.pneuservis.backend.entity.Order;
import cz.muni.fi.pa165.pneuservis.backend.entity.OrderItem;
import dto.CustomerDTO;
import dto.OrderDTO;
import dto.OrderItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.MappingService;
import services.OrderService;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */

@Service
@Transactional
public class OrderFacadeImpl implements OrderFacade {

    @Inject
    private OrderService orderService;

    @Inject
    private MappingService mappingService;

    @Override
    public OrderDTO getOrder(long id) {
        checkNotNull(id);
        Order order = orderService.getOrder(id);
        return mappingService.mapTo(order, OrderDTO.class);
    }

    @Override
    public void create(OrderDTO order) {
        checkNotNull(order);
        Order o = mappingService.mapTo(order, Order.class);
        orderService.create(o);
        order.setId(o.getId());
    }

    @Override
    public void update(OrderDTO order) {
        checkNotNull(order);
        Order o = mappingService.mapTo(order, Order.class);
        orderService.update(o);
    }

    @Override
    public void delete(OrderDTO order) {
        checkNotNull(order);
        Order o = mappingService.mapTo(order, Order.class);
        orderService.delete(o);
    }

    @Override
    public List<OrderDTO> findOrders(OrderDTO search) {
        checkNotNull(search);
        Order filter = mappingService.mapTo(search, Order.class);
        List<Order> orders = orderService.findOrders(filter);
        return mappingService.mapTo(orders, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> findAllOrdersOfCustomer(CustomerDTO search) {
        checkNotNull(search);
        Customer filter = mappingService.mapTo(search, Customer.class);
        List<Order> orders = orderService.findAllOrdersOfCustomer(filter);
        return mappingService.mapTo(orders, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> findAllOrdersContainingOrderItem(OrderItemDTO search) {
        checkNotNull(search);
        OrderItem filter = mappingService.mapTo(search, OrderItem.class);
        List<Order> orders = orderService.findAllOrdersContainingOrderItem(filter);
        return mappingService.mapTo(orders, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return mappingService.mapTo(orders, OrderDTO.class);
    }
}
