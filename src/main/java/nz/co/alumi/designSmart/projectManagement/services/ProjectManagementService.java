package nz.co.alumi.designSmart.projectManagement.services;

import nz.co.alumi.designSmart.projectManagement.model.Project;
import nz.co.alumi.designSmart.projectManagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectManagementService {

  @Autowired
  private ProjectRepository projectRepository;

  public Project create(Project projectRequest) {
    projectRequest.setVersion(1);
    return projectRepository.save(projectRequest);
  }

  public Project getById(String projectId) {
    return projectRepository.findById(projectId).get();
  }
}
