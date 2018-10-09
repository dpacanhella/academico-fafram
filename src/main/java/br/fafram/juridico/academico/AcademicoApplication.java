package br.fafram.juridico.academico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
public class AcademicoApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(AcademicoApplication.class, args);
  }

  @Bean
  public SwaggerConfig swagger() {
    return new SwaggerConfig();
  }

}
