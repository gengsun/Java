package sun.java.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.java.spring.mvc.model.Employee;
import sun.java.spring.mvc.service.IEmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by sun on 12/11/15.
 */

@Controller
@RequestMapping("/")
public class AppController
{
    @Autowired
    IEmployeeService service;

    @Autowired
    MessageSource messageSource;

    /**
     * Method to list all existing employees
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model)
    {
        List<Employee> employees = service.listEmployees();
        model.addAttribute("employees", employees);
        return "allemployees";
    }

    /**
     * Method to provide add a new employee
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newEmployee(ModelMap model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "registration";
    }

    /**
     * Method to be called on form submission, handle POST request
     * for saving employees in database, and validate the user input
     *
     * @param employee
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result, ModelMap model)
    {
        if (result.hasErrors()) {
            return "registration";
        }

        if (!service.isEmployeeNinUnique(employee.getId(), employee.getNINumber())) {
            FieldError ninError = new FieldError("employee", "nin", messageSource.getMessage("non.unique.nin", new String[]{employee.getNINumber()}, Locale.getDefault()));
            result.addError(ninError);
            return "registration";
        }

        service.saveEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }

    /**
     * Method to update an existing employee
     *
     * @param nin
     * @param model
     * @return
     */
    @RequestMapping(value = {"/edit-{nin}-employee"}, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String nin, ModelMap model)
    {
        Employee employee = service.findEmployeeByNin(nin);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }

    /**
     * Method to be called on form submission, handle POST request
     * for saving employees in database, and validate the user input
     *
     * @param employee
     * @param result
     * @param model
     * @param nin
     * @return
     */
    @RequestMapping(value = {"/edit-{nin}-employee"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result, ModelMap model, @PathVariable String nin)
    {
        if (result.hasErrors()) {
            return "registration";
        }

        if (!service.isEmployeeNinUnique(employee.getId(), employee.getNINumber())) {
            FieldError ninError = new FieldError("employee", "nin", messageSource.getMessage("non.unique.nin", new String[]{employee.getNINumber()}, Locale.getDefault()));
            result.addError(ninError);
            return "registration";
        }

        service.updateEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName() + " updated successfully");
        return "success";
    }

    /**
     * Method to delete an employee by its national insurance numeber
     *
     * @param nin
     * @return
     */
    @RequestMapping(value = {"/delete-{nin}-employee"}, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String nin)
    {
        service.deleteEmployeeByNin(nin);
        return "redirect:/list";
    }

    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET)
    public String printHello(ModelMap modelMap)
    {
        modelMap.addAttribute("message", "Sun's Spring MVC Example.");
        return "hello";
    }
}
