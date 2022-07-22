package com.nace.controller;

import com.nace.model.NACEDto;
import com.nace.service.NACEService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(NACEController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class NACEControllerTest {

    @MockBean
    private NACEService naceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_naceDetailsOfOrder() throws Exception {
        long order_id = 12345l;
        Mockito.when(naceService.fetchNACEDetailsById(order_id)).thenReturn(getNaceDto());

        mockMvc.perform(get("/api/NACEDetails/{order}", order_id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.order_id", is(12345)))
                .andExpect(jsonPath("$.code", is("test123")));

    }

    @Test
    public void test_naceDetailsOfOrderNotPresent() throws Exception {
        long order_id = 12345l;
        Mockito.when(naceService.fetchNACEDetailsById(order_id)).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/api/NACEDetails/{order}",order_id)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(result.getResponse().getStatus(), HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void test_saveNaceDetails() throws Exception {
         mockMvc.perform(post("/api/NACEDetails")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    public NACEDto getNaceDto(){
        NACEDto naceDto = new NACEDto();
        naceDto.setOrder_id(12345l);
        naceDto.setCode("test123");
        naceDto.setLevel_id(222);
        naceDto.setItemIncludes("testItems");
        return naceDto;
    }
}