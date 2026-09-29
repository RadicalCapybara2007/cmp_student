package com.cmp_student;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.cmp_student.service.StudentService;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:cmp_student;DB_CLOSE_DELAY=-1",
		"spring.datasource.username=sa",
		"spring.datasource.password="
})
class CmpStudentApplicationTests {

	@MockitoBean
	private StudentService studentService;

	@Test
	void contextLoads() {
	}

}
