package com.example.tams;

import com.example.tams.model.Project;
import com.example.tams.repository.ProjectRepository;
import com.example.tams.util.IdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TamsApplicationTests {

	@Autowired
	private ProjectRepository projectRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testAuditingFields() {
		Project project = new Project();
		String customId = IdUtils.generateId("PRJ");
		project.setProjectId(customId);
		project.setProjectName("Audit Test Project");
		project.setProjectDesc("Testing auditing fields");

		project = projectRepo.save(project);

		assertThat(project.getCreatedAt()).isNotNull();
		assertThat(project.getCreatedBy()).isEqualTo("system");
		assertThat(project.getUpdatedAt()).isNotNull();
		assertThat(project.getUpdatedBy()).isEqualTo("system");
	}

	@Test
	void testProjectCrudOperations() {
		// 1. Create (Save)
		Project project = new Project();
		String customId = IdUtils.generateId("PRJ");
		project.setProjectId(customId);
		project.setProjectName("CRUD Test Project");
		project.setProjectDesc("Testing CRUD operations");
		project = projectRepo.save(project);
		assertThat(project.getProjectId()).isEqualTo(customId);

		// 2. Retrieval
		Optional<Project> retrieved = projectRepo.findById(customId);
		assertThat(retrieved).isPresent();
		assertThat(retrieved.get().getProjectName()).isEqualTo("CRUD Test Project");

		// 3. Update
		Project toUpdate = retrieved.get();
		toUpdate.setProjectName("Updated Project Name");
		projectRepo.save(toUpdate);

		Project updated = projectRepo.findById(customId).get();
		assertThat(updated.getProjectName()).isEqualTo("Updated Project Name");

		// 4. Delete
		projectRepo.deleteById(customId);
		assertThat(projectRepo.findById(customId)).isEmpty();
	}

}
