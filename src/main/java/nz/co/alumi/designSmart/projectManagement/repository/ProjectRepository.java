package nz.co.alumi.designSmart.projectManagement.repository;

import nz.co.alumi.designSmart.projectManagement.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {

}