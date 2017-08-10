package com.chensd.simpleboard;

import com.chensd.simpleboard.controller.PostController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PostControllerTests {
    private MockMvc mmvc;

    @Before
    public void setUp() throws Exception {
        mmvc = MockMvcBuilders.standaloneSetup(new PostController()).build();
    }

    @Test
    public void getIndex() throws Exception {
        mmvc.perform(MockMvcRequestBuilders.get("/post").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
