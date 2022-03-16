package io.github.FilCx.project.features.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@Sql(
//		scripts = { 
//				"classpath:schemas/mock-schema.sql", 
//				"classpath:schemas/mock-data.sql" 
//		}, 
//		executionPhase = ExecutionPhase.BEFORE_TEST_METHOD
//)
@ActiveProfiles("test")
public class UserControllerIntegrationTest {
	
	@Autowired
    private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier;

	@Test
	public void shouldRegisterNewUser() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/user/add");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.accept(MediaType.APPLICATION_JSON);

		UserDto testUser = new UserDto("Test user", "Test address");

		mockRequest.content(this.jsonifier.writeValueAsString(testUser));
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}
