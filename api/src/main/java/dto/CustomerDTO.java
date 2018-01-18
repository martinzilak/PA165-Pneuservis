package dto;

import com.google.common.base.MoreObjects;
import cz.muni.fi.pa165.pneuservis.backend.enums.VehicleTypeEnum;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

/**
 * @author Zuzana Žufanová, zufinka@mail.muni.cz
 */
public class CustomerDTO {
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String city;

    @NotNull
    private String street;

    @NotNull
    private String country;

    @NotNull
    private String zipCode;

    @NotNull
    private String phoneNumber;

    private boolean vip;

    private Set<VehicleTypeEnum> typesOfCar;

    private Set<OrderDTO> orders;

    public CustomerDTO(){}

    public CustomerDTO(String name, String surname, String city, String street, String zipCode, String country,
                    String email, String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Set<VehicleTypeEnum> getTypesOfCar() {
        return typesOfCar;
    }

    public void setTypesOfCar(Set<VehicleTypeEnum> typesOfCar) {
        this.typesOfCar = typesOfCar;
    }

    public Set<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDTO)) return false;

        CustomerDTO that = (CustomerDTO) o;

        if (!getEmail().equals(that.getEmail())) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getSurname().equals(that.getSurname())) return false;
        return getPhoneNumber().equals(that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getName(), getSurname(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("email", email)
                .add("name", name)
                .add("surname", surname)
                .add("city", city)
                .add("street", street)
                .add("country", country)
                .add("zipCode", zipCode)
                .add("phoneNumber", phoneNumber)
                .add("vip", vip)
                .add("typesOfCar", typesOfCar)
                .add("orders", orders)
                .toString();
    }
}
