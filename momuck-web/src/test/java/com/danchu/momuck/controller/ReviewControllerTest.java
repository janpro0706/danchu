package com.danchu.momuck.controller;

import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.danchu.momuck.view.ResultView;
import com.danchu.momuck.vo.Review;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:/root-context.xml", "classpath:servlet-context.xml"})
public class ReviewControllerTest {

    private static final int FOOD_SEQ = 1;
    private static final float SCORE = (float) 5.0;
    private static final String MESSAGE = "test";
    private static final Logger LOG = LoggerFactory.getLogger(ReviewControllerTest.class);

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void submitAndSelectAndDeleteReview() throws Exception {
        String jsonParm = "{" + "\"score\" : \"" + SCORE + "\"," + "\"message\" : \"" + MESSAGE + "\"" + "}";
        MvcResult result = this.mockMvc
                .perform(post("/foods/{foods_id}/reviews", FOOD_SEQ).contentType(MediaType.APPLICATION_JSON)
                        .content(jsonParm))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasKey("code")))
                .andExpect(jsonPath("$.code").value("200"))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        ResultView resultView = mapper.readValue(content, ResultView.class);
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) resultView.getData();
        Review review = new Review();
        review.setSeq((Integer) map.get("seq"));

        this.mockMvc
                .perform(get("/foods/{foods_id}/reviews/{reviews_id}", FOOD_SEQ, review.getSeq())
                        .contentType(MediaType.APPLICATION_JSON).content(jsonParm))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasKey("code")))
                .andExpect(jsonPath("$.code").value("200"))
                .andReturn();

        this.mockMvc.perform(get("/foods/{foods_id}/reviews", FOOD_SEQ)).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasKey("code")))
                .andExpect(jsonPath("$.code").value("200"))
                .andReturn();

        this.mockMvc
                .perform(put("/foods/{foods_id}/reviews/{reviews_id}", FOOD_SEQ, review.getSeq())
                        .contentType(MediaType.APPLICATION_JSON).content(jsonParm))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasKey("code")))
                .andExpect(jsonPath("$.code").value("200"))
                .andReturn();

        this.mockMvc.perform(delete("/foods/{foods_id}/reviews/{reviews_id}", FOOD_SEQ, review.getSeq()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasKey("code")))
                .andExpect(jsonPath("$.code").value("200"))
                .andReturn();

    }
}

