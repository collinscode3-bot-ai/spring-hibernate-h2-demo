package com.example.tams;

import com.example.tams.model.ProjectMaster;
import com.example.tams.repository.ProjectMasterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TamsApplicationTests {

	@Autowired
	private ProjectMasterRepository projectRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testProjectCrudOperations() {
		// 1. Create (Save)
		ProjectMaster project = new ProjectMaster();
		project.setProjectName("CRUD Test Project");
		project.setProjectDesc("Testing CRUD operations");
		project = projectRepo.save(project);
		Long id = project.getProjectId();
		assertThat(id).isNotNull();

		// 2. Retrieval
		Optional<ProjectMaster> retrieved = projectRepo.findById(id);
		assertThat(retrieved).isPresent();
		assertThat(retrieved.get().getProjectName()).isEqualTo("CRUD Test Project");

		// 3. Update
		ProjectMaster toUpdate = retrieved.get();
		toUpdate.setProjectName("Updated Project Name");
		projectRepo.save(toUpdate);

		ProjectMaster updated = projectRepo.findById(id).get();
		assertThat(updated.getProjectName()).isEqualTo("Updated Project Name");

		// 4. Delete
		projectRepo.deleteById(id);
		assertThat(projectRepo.findById(id)).isEmpty();
	}

}
