package co.edu.uniminuto.mvc.controller;

import co.edu.uniminuto.mvc.data.model.Dependency;
import co.edu.uniminuto.mvc.service.api.DependencyService;
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
@RequestMapping("/dependencies")
public class DependencyController {

    private final DependencyService dependencyService;

    @GetMapping("")
    public String viewDependencys(Model model) {
        model.addAttribute("dependencies", dependencyService.getDependencies());
        model.addAttribute("savedDependency", null);
        model.addAttribute("saveDependencySuccess", false);
        return "admin/view-dependencies";
    }

    @GetMapping("/add")
    public String viewDependencyAdd(Model model) {
        model.addAttribute("dependency", Dependency.builder().build());
        return "admin/view-dependency-form";
    }

    @GetMapping("/{id}")
    public String viewDependencyEdit(Model model, @PathVariable Long id) {
        model.addAttribute("dependency", dependencyService.findDependency(id));
        return "admin/view-dependency-form";
    }

    @GetMapping("/delete/{id}")
    public String viewDependencyDelete(@PathVariable Long id) {
        dependencyService.deleteDependency(id);
        return "redirect:/dependencies";
    }

    @PostMapping("/save")
    public RedirectView saveDependency(@ModelAttribute("dependency") Dependency dependency, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/dependencies", true);
        Dependency savedDependency = dependencyService.saveDependency(dependency);
        redirectAttributes.addFlashAttribute("savedDependency", savedDependency);
        redirectAttributes.addFlashAttribute("saveDependencySuccess", true);
        return redirectView;
    }

}
