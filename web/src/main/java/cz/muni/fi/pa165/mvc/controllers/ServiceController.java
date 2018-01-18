package cz.muni.fi.pa165.mvc.controllers;

import dto.ServiceDTO;
import facade.ServiceFacade;
import cz.muni.fi.pa165.pneuservis.backend.enums.TypeOfServiceEnum;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/***
 * @author Róbert Ivan , 461468@mail.muni.cz
 */
@Controller
@RequestMapping("/services")
public class ServiceController extends CommonController {

    final static Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private ServiceFacade serviceFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getServices(Model model) {
        List<ServiceDTO> services = serviceFacade.getAllServices();
        model.addAttribute("services", services);
        return "services/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("serviceEdit", serviceFacade.getService(id));
        return "services/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("serviceEdit") ServiceDTO serviceEdit,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes,
                       UriComponentsBuilder uriComponentsBuilder,
                       @PathVariable long id) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "services/edit";
        }
        serviceEdit.setId(id);
        serviceFacade.update(serviceEdit);
        redirectAttributes.addFlashAttribute("alert_success", "Service was successfully updated");
        return "redirect:" + uriComponentsBuilder.path("/services").build().encode().toUriString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String edit(Model model) {
        Set<TypeOfServiceEnum>  typeOFServiceEnum= new HashSet<>();
        typeOFServiceEnum.add(TypeOfServiceEnum.BRAKECALIBRATION);
        model.addAttribute("serviceCreate", new ServiceDTO());
        model.addAttribute("typeOFServiceEnum", typeOFServiceEnum);
        return "services/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("serviceCreate") ServiceDTO serviceDTO,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes,
                         UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "services/create";
        }
        serviceFacade.create(serviceDTO);
        redirectAttributes.addFlashAttribute("alert_success", "Service was successfully created");
        return "redirect:" + uriComponentsBuilder.path("/services").build().encode().toUriString();
    }
}
