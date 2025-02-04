package co.edu.uniminuto.mvc.service.api;

import co.edu.uniminuto.mvc.data.model.Dependency;

import java.util.List;

public interface DependencyService {

    List<Dependency> getDependencies();

    Dependency findDependency(Long id);

    Dependency saveDependency(Dependency role);

    void deleteDependency(Long id);
}
