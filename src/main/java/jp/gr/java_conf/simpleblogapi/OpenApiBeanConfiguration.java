package jp.gr.java_conf.simpleblogapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiBeanConfiguration {

    @Bean
    public OpenAPI restApi() {
        return new OpenAPI()
                .info(new Info().title("").description(""))
                .externalDocs(new ExternalDocumentation().description("").url(""));
    }
}
