package cz.muni.fi.pa165.pneuservis.backend.entity;

import com.google.common.base.MoreObjects;
import cz.muni.fi.pa165.pneuservis.backend.entity.annotations.TireOrService;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */
@Entity
@TireOrService
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Tire tire;

    @OneToMany
    private Service service;

    @NotNull
    @Min(1)
    private Long quantity;

    public OrderItem() {
    }

    public OrderItem(Tire tire, Long quantity) {
        this.tire = tire;
        this.quantity = quantity;
    }

    public OrderItem(Service service, Long quantity) {
        this.service = service;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Tire getTire() {
        return tire;
    }

    public Service getService() {
        return service;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public BigDecimal calculatePrice() {
        /*BigDecimal price = new BigDecimal(0);

        if (service == null) {
            price = price.add(tire.getPrice().multiply(new BigDecimal(quantity)));
        } else if (tire == null) {
            price = price.add(service.getPrice().multiply(new BigDecimal(quantity)));
        }

        return price;
        */

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) &&
                Objects.equals(tire, orderItem.tire) &&
                Objects.equals(service, orderItem.service) &&
                Objects.equals(quantity, orderItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tire, service, quantity);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("tire", tire)
                .add("service", service)
                .add("quantity", quantity)
                .toString();
    }
}
