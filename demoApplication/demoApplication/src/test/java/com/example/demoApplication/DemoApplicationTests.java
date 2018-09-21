package com.example.demoApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
    private MockMvc mockMvc;


	@Test
	public void indexControllerShouldReturnHtmlPage() throws Exception {
	    mockMvc.perform(get("/visit/Kate"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome, Kate")));
	}

	@Test
    public void apiControllerShouldReturnVisits() throws Exception{
	    mockMvc.perform(get("/api/visits/"))
                .andExpect(jsonPath("$.*.description", iterableWithSize(1)));
    }

}
