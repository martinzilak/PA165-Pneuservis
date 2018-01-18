package cz.muni.fi.pa165.pneuservis.backend.dao;

import cz.muni.fi.pa165.pneuservis.backend.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Zuzana Žufanová, zufinka@mail.muni.cz
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer findById(Long id) {
        checkNotNull(id);
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findByName(String name, String surname) {
        checkNotNull(name);
        checkNotNull(surname);
        return em.createQuery("SELECT c FROM Customer c WHERE c.name = :name AND c.surname = :surname",
                Customer.class).getResultList();
    }

    @Override
    public Customer findByEmail(String email) {
        checkNotNull(email);

        Customer foundCustomer = null;
        try {
            foundCustomer = em.createQuery(
                    "SELECT c FROM Customer c WHERE c.email = :emailv", Customer.class)
                    .setParameter("emailv", email)
                    .getSingleResult();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return foundCustomer;
    }

    @Override
    public Customer findByPhone(String phoneNumber) {
        checkNotNull(phoneNumber);
        Customer foundCustomer =  em.createQuery("SELECT c FROM Customer c " +
                "WHERE c.phoneNumber = :phoneNumber", Customer.class).getSingleResult();
        return foundCustomer;
    }

    @Override
    public List<Customer> findByAddress(String city, String street, String country, String zipCode) {
        checkNotNull(city);
        checkNotNull(street);
        checkNotNull(country);
        checkNotNull(zipCode);
        return em.createQuery("SELECT c FROM Customer c WHERE c.city=:city AND c.street=:street " +
                        "AND c.country=:country AND c.zipCode=:zipCode",
                Customer.class).getResultList();
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public void createCustomer(Customer customer) {
        checkNotNull(customer);
        em.persist(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        checkNotNull(customer);
        em.merge(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        checkNotNull(customer);
        em.remove(customer);
    }
}
