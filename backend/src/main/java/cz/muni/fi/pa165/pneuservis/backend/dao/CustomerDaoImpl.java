package cz.muni.fi.pa165.pneuservis.backend.dao;

import cz.muni.fi.pa165.pneuservis.backend.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

/**
 * @author Zuzana Žufanová, zufinka@mail.muni.cz
 */
public class CustomerDaoImpl implements CustomerDao{
    private EntityManager em;

    public CustomerDaoImpl (EntityManager em){
        this.em = em;
    }

    @Override
    public Customer findById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("ID is null.");
        }
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findByName(String name, String surname) {
        if (name == null || surname == null){
            throw new IllegalArgumentException("Fist name or surname is null.");
        }
        return em.createQuery("SELECT c FROM CustomerTable c WHERE c.name = :name AND c.surname = :surname",
                Customer.class).getResultList();
    }

    @Override
    public Customer findByEmail(String email) {
        if (email == null){
            throw new IllegalArgumentException("Email is null.");
        }
        Customer foundCustomer =  em.createQuery("SELECT c FROM CustomerTable c " +
                "WHERE c.email = :email", Customer.class).getSingleResult();
        return foundCustomer;
    }

    @Override
    public Customer findByPhone(Integer phoneNumber) {
        if (phoneNumber == null){
            throw new IllegalArgumentException("Telephone number is null.");
        }
        Customer foundCustomer =  em.createQuery("SELECT c FROM CustomerTable c " +
                "WHERE c.phoneNumber = :phoneNumber", Customer.class).getSingleResult();
        return foundCustomer;
    }

    @Override
    public List<Customer> findByAddress(String city, String street, Integer psc) {
        if (city == null || street == null || psc == null){
            throw new IllegalArgumentException("City, street or psc is null.");
        }
        return em.createQuery("SELECT c FROM CustomerTable c WHERE c.city=:city AND c.street=:street AND c.psc=:psc",
                Customer.class).getResultList();
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("SELECT c from CustomerTable c", Customer.class).getResultList();
    }

    @Override
    public void createCustomer(Customer customer) {
        if (customer == null){
            throw new IllegalArgumentException("Customer is null.");
        }

        em.getTransaction( ).begin( );
        em.persist( customer );
        em.getTransaction( ).commit( );
        em.close( );
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customer == null){
            throw new IllegalArgumentException("Customer is null.");
        }

        em.getTransaction( ).begin( );
        em.merge(customer);
        em.getTransaction( ).commit( );
        em.close();
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        if (customer == null){
            throw new IllegalArgumentException("Customer is null.");
        }

        em.getTransaction( ).begin( );
        Customer customerToDelete = em.find(Customer.class, customer.getId());
        em.remove(customerToDelete);
        em.getTransaction( ).commit( );
        em.close( );
    }
}
