package cz.muni.fi.pa165.mvc.controllers;

import dto.CustomerDTO;
import facade.CustomerFacade;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


/**
 * @author Zuzana Žufanová, zufinka@mail.muni.cz
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Inject
    private CustomerFacade customerFacade;

    @Inject
    private HttpServletRequest request;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCustomers(Model model) {
        List<CustomerDTO> customers = customerFacade.findAllCustomers();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    /*@RequestMapping("/list")
    public String list(Model model) {

        model.addAttribute("customers", customerFacade.findAllCustomers());

        return "customer/list";
    }*/

    @RequestMapping(value = "/create", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final CustomerDTO createCustomer(
            @PathVariable String name, @PathVariable String surname, @PathVariable String city,
            @PathVariable String street, @PathVariable String zipCode, @PathVariable String country,
            @PathVariable String email, @PathVariable String phoneNumber){
        logger.debug("createCustomer()");
        CustomerDTO customer = new CustomerDTO(name, surname, city, street, zipCode, country, email, phoneNumber);
        try {
            customerFacade.createCustomer(customer);
            return customerFacade.getCustomerById(customer.getId());
        } catch (Exception ex) {
            logger.debug(ex.getMessage());
            return null;
        }
    }

}
