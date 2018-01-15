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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * @author Zuzana Žufanová, zufinka@mail.muni.cz
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Inject
    private CustomerFacade customerFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        List<CustomerDTO> customers = customerFacade.findAllCustomers();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showAddCustomerForm(Model model) {
        logger.debug("showAddCustomerForm()");
        CustomerDTO customer = new CustomerDTO();

        // set default value
        customer.setName("John");
        customer.setSurname("Smith");
        customer.setEmail("test@gmail.com");
        customer.setStreet("Blizka 5");
        customer.setCity("Brno");
        customer.setZipCode("60200");
        customer.setCountry("cr");
        customer.setPhoneNumber("969636303");

        model.addAttribute("customerCreate", customer);

        return "customer/create";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("customerCreate") CustomerDTO customer,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes,
                         UriComponentsBuilder uriComponentsBuilder) {
        if (result.hasErrors()) {
            for (FieldError fe : result.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "customer/create";
        }
        model.addAttribute("name", customer.getName());
        customerFacade.createCustomer(customer);
        logger.debug("created customer");
        redirectAttributes.addFlashAttribute("alert_success", "Customer was successfully added.");
        return "redirect:" + uriComponentsBuilder.path("/customer").build().encode().toUriString();
    }

}
