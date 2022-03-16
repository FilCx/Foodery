package io.github.FilCx.project.features.order_product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OrderProductControllerIntegrationTest {

	@Autowired
    private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	@Test
	public void shouldAddProductToOrder() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/order_product/add");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.accept(MediaType.APPLICATION_JSON);

		OrderProductGetDto testOrderProduct = new OrderProductGetDto();
		testOrderProduct.setOrderId(1L);
		testOrderProduct.setProductId(1L);

		mockRequest.content(this.jsonifier.writeValueAsString(testOrderProduct));
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
}
