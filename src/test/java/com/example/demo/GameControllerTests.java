package com.example.demo;

import com.example.demo.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllGames_shouldReturnOk() {
        String url = "http://localhost:" + port + "/games";
        ResponseEntity<Game[]> response = restTemplate.getForEntity(url, Game[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
