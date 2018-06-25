package requestsApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RequestsAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Resource
	private RequestsRepository requestsRepository;

	@Test
	public void repositoryCheckAmountOfRequests() {
		assertEquals(6, requestsRepository.findAll().size());
	}

	@Test
	public void paramGetResultsLatestRequest() throws Exception{
		this.mockMvc.perform(get("/").param("id", "1"))
				.andExpect(jsonPath("$.dt_CREATED").value("2018-04-03T21:00:00.000+0000"));
	}

	@Test
	public void getWithIdNotExistingInDBShouldReturnEmptyString() throws Exception {
		this.mockMvc.perform(get("/").param("id", "283"))
				.andExpect(content().string(""));
	}

	@Test
	public void repositoryCheck() {
		List<Request> requests= requestsRepository.findByContactId(1);
		assertEquals(1, requests.get(0).getContactId());
	}

	@Test
	public void paramGetShouldReturnRequestForRespectiveContactId() throws Exception {
		this.mockMvc.perform(get("/").param("id", "1"))
				.andExpect(jsonPath("$.contactId").value(1));
	}


}
