package com.pmart5a.sprboothw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SprboothwApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private static final GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    @Container
    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @Test
    void contextLoadsDevApp() {
        String expected = "Current profile is dev";
        ResponseEntity<String> entityFromDevApp = restTemplate.getForEntity("http://localhost:"
                + devApp.getMappedPort(8080) + "/profile", String.class);
        assertEquals(expected, entityFromDevApp.getBody());
    }

    @Test
    void contextLoadsProdApp() {
        String expected = "Current profile is production";
        ResponseEntity<String> entityFromProdApp = restTemplate.getForEntity("http://localhost:"
                + prodApp.getMappedPort(8081) + "/profile", String.class);
        assertEquals(expected, entityFromProdApp.getBody());
    }
}