package com.github.marcospsbrito.mars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/**
 * Created by marcos on 15/03/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MarsCuriosityApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testInicialPosition() throws Exception{
        ResponseEntity result = this.restTemplate.getForEntity("/rest/mars", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(result.getBody(),"(0, 0, N)");
    }

    @Test
    public void testMovementWithRightRotation() throws Exception{
        ResponseEntity result = this.restTemplate.getForEntity("/rest/mars/MMRMMRMM", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(result.getBody(),"(2, 0, S)");
    }

    @Test
    public void testMovementToLeft() throws Exception {
        ResponseEntity result = this.restTemplate.getForEntity("/rest/mars/MML", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(result.getBody(),"(0, 2, W)");
    }

    @Test
    public void testRepeatMovementToLeft() throws Exception {
        ResponseEntity result = this.restTemplate.getForEntity("/rest/mars/MML", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(result.getBody(),"(0, 2, W)");
    }

    @Test
    public void testInvalidCommand() throws Exception {
        ResponseEntity result = this.restTemplate.getForEntity("/rest/mars/AAA", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertTrue(result.getBody().toString().contains("Invalid Command - "));
    }

    @Test
    public void testInvalidPosition() throws Exception {
        ResponseEntity result = this.restTemplate.getForEntity("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertTrue(result.getBody().toString().contains("Invalid Position - "));
    }

    @Test
    public void testInvalidPositionNegative() throws Exception {
        ResponseEntity result = this.restTemplate.getForEntity("/rest/mars/RRM", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertTrue(result.getBody().toString().contains("Invalid Position - (0, -1, S)"));

        result = this.restTemplate.getForEntity("/rest/mars/LM", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertTrue(result.getBody().toString().contains("Invalid Position - (-1, 0, W)"));
    }

}
