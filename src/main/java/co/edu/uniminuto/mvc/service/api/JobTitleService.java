package co.edu.uniminuto.mvc.service.api;

import co.edu.uniminuto.mvc.data.model.JobTitle;

import java.util.List;

public interface JobTitleService {

    List<JobTitle> getJobTitles();

    JobTitle findJobTitle(Long id);

    JobTitle saveJobTitle(JobTitle role);

    void deleteJobTitle(Long id);
}
