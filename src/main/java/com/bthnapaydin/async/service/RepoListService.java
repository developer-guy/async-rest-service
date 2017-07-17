package com.bthnapaydin.async.service;


import com.bthnapaydin.async.domain.RepoListDto;
import org.springframework.util.concurrent.ListenableFuture;

public interface RepoListService {
    ListenableFuture<RepoListDto> search(String query);
}
