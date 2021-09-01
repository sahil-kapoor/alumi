package nz.co.alumi.designSmart.projectManagement.controller;

import javax.validation.Valid;
import nz.co.alumi.designSmart.projectManagement.model.Project;
import nz.co.alumi.designSmart.projectManagement.services.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/v1/project", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProjectManagementController {

  @Autowired
  private ProjectManagementService projectManagementService;

  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Project> createProject(@RequestBody @Valid Project project) {
    return ResponseEntity.ok(projectManagementService.create(project));
  }

  @GetMapping(value = "/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getProject(@PathVariable(required = true) String projectId) {
    return ResponseEntity.ok("sahil");
  }
}
