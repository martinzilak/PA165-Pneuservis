package cz.muni.fi.pa165.mvc.controllers;

import dto.CustomerDTO;
import facade.CustomerFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.inject.Inject;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */
public class CommonController {

    @Inject
    private CustomerFacade customerFacade;

    @ModelAttribute("user")
    public CustomerDTO user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null)
            return null;
        try {
            return customerFacade.getCustomerByEmail(authentication.getName());
        } catch (Exception e) {
            return null;
        }
    }

    @ModelAttribute("isAuthernticated")
    public boolean isAuthernticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null)
            return false;
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
