package com.bthnapaydin.async.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubOwner {

    @JsonProperty("login")
    private String userName;

    @JsonProperty("html_url")
    private URL url;

    @JsonProperty("avatar_url")
    private URL avatarUrl;

    public String userName() {
        return userName;
    }

    public URL url() {
        return url;
    }

    public URL avatarUrl() {
        return avatarUrl;
    }
}