package co.edu.uniminuto.mvc.controller;

import co.edu.uniminuto.mvc.data.model.Person;
import co.edu.uniminuto.mvc.data.model.User;
import co.edu.uniminuto.mvc.service.api.RoleService;
import co.edu.uniminuto.mvc.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final RoleService roleService;

    private final UserService userService;

    @GetMapping("")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("savedUser", null);
        model.addAttribute("saveUserSuccess", false);
        return "view-users";
    }

    @GetMapping("/add")
    public String viewUserAdd(Model model) {
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", User.builder().data(new Person()).build());
        return "view-user-form";
    }

    @GetMapping("/{id}")
    public String viewUserEdit(Model model, @PathVariable Long id) {
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", userService.findUser(id));
        return "view-user-form";
    }

    @GetMapping("/delete/{id}")
    public String viewUserDelete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("/save")
    public RedirectView saveUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/users", true);
        User savedUser = userService.saveUser(user);
        redirectAttributes.addFlashAttribute("savedUser", savedUser);
        redirectAttributes.addFlashAttribute("saveUserSuccess", true);
        return redirectView;
    }

}
