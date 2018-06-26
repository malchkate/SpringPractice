package requestsApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RequestsAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RequestsRepository requestsRepository;

    @Test
    public void repositoryCheckAmountOfRequests() {
        assertEquals(6, requestsRepository.findAll().size());
    }

    @Test
    public void paramGetResultsLatestRequest() throws Exception{
        this.mockMvc.perform(get("/id/{contactId}", "1"))
                .andExpect(jsonPath("$.DT_CREATED").value(
                        "2018-03-04T00:00:00+03:00"));
    }

	/*@Test
	public void getWithIdNotExistingInDBShouldReturnEmptyString() throws Exception {
		this.mockMvc.perform(get("/id/{contactId}", "283"))
				.andExpect(content().string(""));
	}*/

    @Test
    public void repositoryCheck() {
        Pageable pageRequest = PageRequest.of(0, 1, Sort.Direction.DESC, "dtCreated");
        List<Request> requests= requestsRepository.findByContactId(1, pageRequest);
        assertEquals(1, requests.get(0).getContactId());
    }

    @Test
    public void paramGetShouldReturnRequestForRespectiveContactId() throws Exception {
        this.mockMvc.perform(get("/id/{contactId}", "1"))
                .andExpect(jsonPath("$.CONTACT_ID").value(1));
    }

}
