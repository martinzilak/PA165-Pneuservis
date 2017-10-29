package cz.muni.fi.pa165.pneuservis.backend.dao;

import cz.muni.fi.pa165.pneuservis.backend.entity.Customer;

import java.util.List;
import java.util.Set;

/**
 * Interface that specify DAO for entity Customer {@link Customer}
 * @author Zuzana Žufanová, zufinka@mail.muni.cz
 */
public interface CustomerDao {

    /**
     * Find Customer according to given ID.
     * @param id
     * @return Founded Customer or null if there was no customer with this ID in the database.
     * @throws IllegalArgumentException if given id is null
     */
    Customer findById(Long id);

    /**
     * Find Customer according to given name.
     * @param name First name
     * @param surname
     * @return Set of founded Customers with given name or null if there was no customer with this name in the database.
     * @throws IllegalArgumentException if given name or surname is null
     */
    List<Customer> findByName(String name, String surname);

    /**
     * Find Customer according to given email.
     * @param email
     * @return Customer with given email or null if there was no customer with this email in the database.
     * @throws IllegalArgumentException if given email is null
     */
    Customer findByEmail(String email);

    /**
     * Find Customer according to given telephone number.
     * @param phoneNumber
     * @return Customer with given telephone number or null if there was no customer with this number in the database.
     * @throws IllegalArgumentException if given telephone number is null
     */
    Customer findByPhone(Integer phoneNumber);

    /**
     * Find Customer according to given address.
     * @param city
     * @param street
     * @param psc
     * @return Set of founded customers with given address or null if there was no customer with this
     *         adress in the database.
     * @throws IllegalArgumentException if given city, street or psč is null
     */
    List<Customer> findByAddress(String city, String street, Integer psc);

    /**
     * Find all customers in the database.
     * @return Set of all customers in the database.
     */
    List<Customer>findAll();

    /**
     * Insert customer to the database.
     * @param customer to be inserted to the database
     * @throws IllegalArgumentException if given customer is null
     */
    void createCustomer(Customer customer);

    /**
     * Update information about customer that already is in the database.
     * @param customer to be updated
     * @throws IllegalArgumentException if given customer is null
     * @throws NullPointerException if the customer is not present in the database
     */
    void updateCustomer(Customer customer);

    /**
     * Delete customer from database.
     * @param customer to be deleted
     * @return Customer that was deleted.
     * @throws IllegalArgumentException if given customer is null
     * @throws NullPointerException if the customer is not present in the database
     */
    Customer deleteCustomer(Customer customer);
}
