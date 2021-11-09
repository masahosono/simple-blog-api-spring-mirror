package jp.gr.java_conf.simpleblogapi.application.file.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class RegisterFileResultDto {

    private final String fileName;

}
