package com.github.marcospsbrito.mars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by marcos on 15/03/18.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(CuriosityController.class)
public class MarsCuriosityApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CuriosityService movimentService;

    @Test
    public void testMovementWithRightRotation() throws Exception{
        this.mockMvc.perform(get("/rest/mars/MMRMMRMM")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("(2, 0, S)")));
    }

    @Test
    public void testMovementToLeft() throws Exception {
        this.mockMvc.perform(get("/rest/mars/MML")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("(0, 2, W)")));
    }

    @Test
    public void testRepeatMovementToLeft() throws Exception {
        this.mockMvc.perform(get("/rest/mars/MML")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("(0, 2, W)")));
    }

    @Test
    public void testInvalidCommand() throws Exception {
        this.mockMvc.perform(get("/rest/mars/AAA")).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Comando inválido:")));
    }

    @Test
    public void testInvalidPosition() throws Exception {
        this.mockMvc.perform(get("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM")).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Posição inválida:")));
    }

}
