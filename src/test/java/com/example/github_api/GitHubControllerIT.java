package com.example.github_api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHubControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private GitHubService gitHubService;

    @Test
    void RepoFromUser() {
        Mockito.when(gitHubService.getRepositoryNames("anyUser")).thenReturn(List.of("repo1","repo2"));

        //Modifier + (static) + void oder Datatyp + Name der Methode + (Parameter) + {}
        ResponseEntity<String[]> getResponse = restTemplate.getForEntity("/github/anyUser", String[].class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(getResponse.getBody()).length).isEqualTo(2);
        assertThat(Objects.requireNonNull(getResponse.getBody())).contains("repo1", "repo2");


    }
}
