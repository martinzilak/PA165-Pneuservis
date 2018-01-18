package cz.muni.fi.pa165.mvc.controllers;

import facade.CustomerFacade;
import facade.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */
@Controller
@RequestMapping("/order")
public class OrderController extends CommonController{

    @Autowired
    private OrderFacade orderFacade;

    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping("/list")
    public String list(Model model) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("orders", orderFacade.findAllOrdersOfCustomer(customerFacade.getCustomerByEmail(email)));

        return "order/list";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {

        model.addAttribute("order", orderFacade.getOrder(id));

        return "order/show";
    }
}
