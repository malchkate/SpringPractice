package example.SpringBootRestfulServer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootRestfulServerApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void repositotyCheckAmountOfEmployees() {
		assertEquals(7, employeeRepository.findAll().size());
	}

	@Test
	public void paramGetShouldReturnRespectiveEmployee() throws Exception{
		this.mockMvc.perform(get("/employees/{empNo}", "4"))
				.andExpect(jsonPath("$.Name").value("Pavlov"));
	}

}
