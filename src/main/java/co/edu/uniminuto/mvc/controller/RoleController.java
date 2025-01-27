package co.edu.uniminuto.mvc.controller;

import co.edu.uniminuto.mvc.data.model.Role;
import co.edu.uniminuto.mvc.service.api.RoleService;
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
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("")
    public String viewRoles(Model model) {
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("savedRole", null);
        model.addAttribute("saveRoleSuccess", false);
        return "admin/view-roles";
    }

    @GetMapping("/add")
    public String viewRoleAdd(Model model) {
        model.addAttribute("role", new Role());
        return "admin/view-role-form";
    }

    @GetMapping("/{id}")
    public String viewRoleEdit(Model model, @PathVariable Long id) {
        model.addAttribute("role", roleService.findRole(id));
        return "admin/view-role-form";
    }

    @GetMapping("/delete/{id}")
    public String viewRoleDelete(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }

    @PostMapping("/save")
    public RedirectView saveRole(@ModelAttribute("role") Role role, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/roles", true);
        Role savedRole = roleService.saveRole(role);
        redirectAttributes.addFlashAttribute("savedRole", savedRole);
        redirectAttributes.addFlashAttribute("saveRoleSuccess", true);
        return redirectView;
    }

}
