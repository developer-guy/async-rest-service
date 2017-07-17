package com.bthnapaydin.async.rest;


import com.bthnapaydin.async.domain.RepoListDto;
import com.bthnapaydin.async.service.RepoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequiredArgsConstructor
public class AsyncController {
    private final RepoListService repoListService;

    @GetMapping("/async")
    DeferredResult<ResponseEntity<?>> async(@RequestParam("q") String query) {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
        ListenableFuture<RepoListDto> search = repoListService.search(query);
        search.addCallback(new ListenableFutureCallback<RepoListDto>() {
            @Override
            public void onFailure(Throwable throwable) {
                ResponseEntity<Object> objectResponseEntity =
                        new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
                deferredResult.setResult(objectResponseEntity);
            }

            @Override
            public void onSuccess(RepoListDto repoListDto) {
                ResponseEntity<RepoListDto> repoListDtoResponseEntity = new ResponseEntity<>(repoListDto, HttpStatus.OK);
                deferredResult.setResult(repoListDtoResponseEntity);
            }
        });

        return deferredResult;
    }
}
