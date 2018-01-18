package cz.muni.fi.pa165.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */
@Controller
public class LoginController extends CommonController{

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginGet(Model model) {
    return "authentication/login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String loginPost(Model model) {
    return "/login";
  }
}
