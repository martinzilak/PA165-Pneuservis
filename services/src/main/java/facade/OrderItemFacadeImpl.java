package facade;

import cz.muni.fi.pa165.pneuservis.backend.entity.OrderItem;
import dto.OrderItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.MappingService;
import services.OrderItemService;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */

@Service
@Transactional
public class OrderItemFacadeImpl implements OrderItemFacade {

    @Inject
    private OrderItemService orderItemService;

    @Inject
    private MappingService mappingService;

    @Override
    public OrderItemDTO getOrderItem(long id) {
        checkNotNull(id);
        OrderItem orderItem = orderItemService.getOrderItem(id);
        return mappingService.mapTo(orderItem, OrderItemDTO.class);
    }

    @Override
    public void create(OrderItemDTO orderItem) {
        checkNotNull(orderItem);
        OrderItem o = mappingService.mapTo(orderItem, OrderItem.class);
        orderItemService.create(o);
        orderItem.setId(o.getId());
    }

    @Override
    public void update(OrderItemDTO orderItem) {
        checkNotNull(orderItem);
        OrderItem o = mappingService.mapTo(orderItem, OrderItem.class);
        orderItemService.update(o);
    }

    @Override
    public void delete(OrderItemDTO orderItem) {
        checkNotNull(orderItem);
        OrderItem o = mappingService.mapTo(orderItem, OrderItem.class);
        orderItemService.delete(o);
    }

    @Override
    public List<OrderItemDTO> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return mappingService.mapTo(orderItems, OrderItemDTO.class);
    }
}
