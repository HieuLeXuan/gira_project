package cybersoft.javabackend.java18.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;

public class OpenApiConfiguration {

    @Bean
    public OpenAPI getOpenApi() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")))
                .info(new Info()
                        .title("Gira Application")
                        .description("Service for Education Purpose")
                        .version("v1.0")
                        .license(new License().name("NO LICENSE").url("https://github.com/HieuLeXuan/gira_project"))
                        .contact(new Contact()
                                .email("hieulexuan629@gmail.com")
                                .name("Le Xuan Hieu")
                                .url("https://github.com/HieuLeXuan/gira_project")))
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Documentation")
                        .url("https://docs.spring.io/spring-framework/docs/current/reference/html/"));
    }
}
