package com.bthnapaydin.async.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubItems {

    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("items")
    private List<GitHubItem> items;

    public int totalCount() {
        return totalCount;
    }

    public List<GitHubItem> items() {
        return items;
    }
}
