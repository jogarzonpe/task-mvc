package co.edu.uniminuto.mvc.service.impl;

import co.edu.uniminuto.mvc.data.model.Dependency;
import co.edu.uniminuto.mvc.data.repository.DependencyRepository;
import co.edu.uniminuto.mvc.service.api.DependencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DependencyServiceImpl implements DependencyService {

    private final DependencyRepository dependencyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Dependency> getDependencies() {
        return dependencyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Dependency findDependency(Long id) {
        return dependencyRepository.findById(id).orElse(Dependency.builder().build());
    }

    @Override
    public Dependency saveDependency(Dependency Dependency) {
        return dependencyRepository.saveAndFlush(Dependency);
    }

    @Override
    public void deleteDependency(Long id) {
        dependencyRepository.deleteById(id);
    }
}
