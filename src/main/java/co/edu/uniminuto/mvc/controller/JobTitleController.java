package co.edu.uniminuto.mvc.controller;

import co.edu.uniminuto.mvc.data.model.JobTitle;
import co.edu.uniminuto.mvc.service.api.JobTitleService;
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
@RequestMapping("/job-titles")
public class JobTitleController {

    private final JobTitleService jobTitleService;

    @GetMapping("")
    public String viewJobTitles(Model model) {
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("savedJobTitle", null);
        model.addAttribute("saveJobTitleSuccess", false);
        return "admin/view-job-titles";
    }

    @GetMapping("/add")
    public String viewJobTitleAdd(Model model) {
        model.addAttribute("jobTitle", JobTitle.builder().build());
        return "admin/view-job-title-form";
    }

    @GetMapping("/{id}")
    public String viewJobTitleEdit(Model model, @PathVariable Long id) {
        model.addAttribute("jobTitle", jobTitleService.findJobTitle(id));
        return "admin/view-job-title-form";
    }

    @GetMapping("/delete/{id}")
    public String viewJobTitleDelete(@PathVariable Long id) {
        jobTitleService.deleteJobTitle(id);
        return "redirect:/job-titles";
    }

    @PostMapping("/save")
    public RedirectView saveJobTitle(@ModelAttribute("jobTitle") JobTitle jobTitle, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/job-titles", true);
        JobTitle savedJobTitle = jobTitleService.saveJobTitle(jobTitle);
        redirectAttributes.addFlashAttribute("savedJobTitle", savedJobTitle);
        redirectAttributes.addFlashAttribute("saveJobTitleSuccess", true);
        return redirectView;
    }

}
