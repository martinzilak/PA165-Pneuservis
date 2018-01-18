package cz.muni.fi.pa165.pneuservis.backend.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime date;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;

    @NotNull
    @OneToMany(cascade = CascadeType.MERGE)
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(LocalDateTime date, Customer customer, List<OrderItem> orderItems) {
        this.date = date;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getPrice() {
        BigDecimal price = BigDecimal.valueOf(0);
        for (OrderItem orderItem : orderItems) {
            price = price.add(orderItem.getPrice());
        }
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(date, order.date) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(orderItems, order.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, customer, orderItems);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("date", date)
                .add("customer", customer)
                .add("orderItems", orderItems)
                .toString();
    }
}