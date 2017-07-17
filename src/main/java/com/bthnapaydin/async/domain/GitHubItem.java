package com.bthnapaydin.async.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubItem {

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("html_url")
    private URL url;

    @JsonProperty("description")
    private String description;

    @JsonProperty("owner")
    private GitHubOwner owner;

    public String fullName() {
        return fullName;
    }

    public URL getUrl() {
        return url;
    }

    public String description() {
        return description;
    }

    public GitHubOwner owner() {
        return owner;
    }
}