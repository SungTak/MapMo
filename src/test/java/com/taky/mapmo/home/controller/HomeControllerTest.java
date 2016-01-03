package com.taky.mapmo.home.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.taky.mapmo.MapMoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MapMoApplication.class)
public class HomeControllerTest {

	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}
	
	@Test
	public void testSayHelloWorld() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/")
				//.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				).andExpect(MockMvcResultMatchers.status().isOk());
				//.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
	}

}
