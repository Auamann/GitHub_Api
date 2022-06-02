package com.example.github_api;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;



@Service
public class GitHubService {

    public List<String> getRepositoryNames(String githubUser) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream((restTemplate.getForObject("https://githhub.com/users" + githubUser + "/repos", Repository[].class)))
                .map(Repository::toString)
                .toList();
    }
}