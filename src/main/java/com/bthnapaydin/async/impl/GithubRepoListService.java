package com.bthnapaydin.async.impl;

import com.bthnapaydin.async.domain.GitHubItems;
import com.bthnapaydin.async.domain.RepoListDto;
import com.bthnapaydin.async.service.RepoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

@Service
@RequiredArgsConstructor
public class GithubRepoListService implements RepoListService {
    private static final String SEARCH_URL = "https://api.github.com/search/repositories?q={query}";

    private final AsyncRestTemplate asyncRestTemplate;

    @Override
    public ListenableFuture<RepoListDto> search(String query) {
        ListenableFuture<ResponseEntity<GitHubItems>> githubItems = asyncRestTemplate.getForEntity(SEARCH_URL, GitHubItems.class, query);
        return new RepositoryListDtoAdapter(query, githubItems);
    }
}
