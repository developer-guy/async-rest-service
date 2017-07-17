package com.bthnapaydin.async.impl;

import com.bthnapaydin.async.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;


public class RepositoryListDtoAdapter extends ListenableFutureAdapter<RepoListDto, ResponseEntity<GitHubItems>> {

    private final String query;

    public RepositoryListDtoAdapter(String query, ListenableFuture<ResponseEntity<GitHubItems>> githubItems) {
        super(githubItems);
        this.query = query;
    }


    @Override
    protected RepoListDto adapt(ResponseEntity<GitHubItems> gitHubItemsResponseEntity) throws ExecutionException {
        GitHubItems gitHubItems = gitHubItemsResponseEntity.getBody();
        List<RepoDto> repoDtos = gitHubItems.items().stream().map(toRepositoryDto).collect(toList());
        return new RepoListDto(query, gitHubItems.totalCount(), repoDtos);
    }

    private Function<GitHubItem, RepoDto> toRepositoryDto = item -> {
        GitHubOwner owner = item.owner();
        return new RepoDto(item.fullName(), item.getUrl(), item.description(),
                owner.userName(), owner.url(), owner.avatarUrl());
    };

}
