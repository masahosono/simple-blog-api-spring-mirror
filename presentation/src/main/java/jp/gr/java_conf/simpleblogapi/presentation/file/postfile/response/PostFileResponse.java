package jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class PostFileResponse {

    @JsonProperty("fileName")
    private String fileName;
}
