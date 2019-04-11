package com.system.config.swagger;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Swagger2 在线文档配置</p>
 * @author liwei
 */
@Slf4j
@Configuration
@EnableSwagger
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		log.debug("---createRestApi---");
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.apiInfo(apiInfo());
		ApiSelectorBuilder select = docket.select();
		select.paths(PathSelectors.any());
		select.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
		select.build();
		return docket;
	}

	private ApiInfo apiInfo() {
		log.debug("---apiInfo---");
		return new ApiInfoBuilder().title("springboot利用swagger构建api文档").build();
	}

}
