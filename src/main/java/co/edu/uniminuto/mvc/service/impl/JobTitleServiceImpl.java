package co.edu.uniminuto.mvc.service.impl;

import co.edu.uniminuto.mvc.data.model.JobTitle;
import co.edu.uniminuto.mvc.data.repository.JobTitleRepository;
import co.edu.uniminuto.mvc.service.api.JobTitleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class JobTitleServiceImpl implements JobTitleService {

    private final JobTitleRepository jobTitleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<JobTitle> getJobTitles() {
        return jobTitleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public JobTitle findJobTitle(Long id) {
        return jobTitleRepository.findById(id).orElse(JobTitle.builder().build());
    }

    @Override
    public JobTitle saveJobTitle(JobTitle JobTitle) {
        return jobTitleRepository.saveAndFlush(JobTitle);
    }

    @Override
    public void deleteJobTitle(Long id) {
        jobTitleRepository.deleteById(id);
    }
}
