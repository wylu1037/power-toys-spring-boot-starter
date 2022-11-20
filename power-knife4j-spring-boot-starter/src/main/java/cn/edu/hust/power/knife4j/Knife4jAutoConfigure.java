package cn.edu.hust.power.knife4j;

import cn.edu.hust.power.knife4j.properties.Knife4jProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *
 * @Author wylu
 * @Date 2022/11/20 下午 9:07
 */
@Configuration
@EnableConfigurationProperties(value = Knife4jProperties.class)
public class Knife4jAutoConfigure {
	private final Knife4jProperties properties;

	public Knife4jAutoConfigure(Knife4jProperties properties) {
		this.properties = properties;
	}

	@Bean(value = "dockerBean")
	public Docket dockerBean() {
		//指定使用Swagger2规范
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName(properties.getGroupName())
				.select()
				.apis(RequestHandlerSelectors.basePackage(properties.getBasePackage()))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		cn.edu.hust.power.knife4j.properties.Contact contact = properties.getContact();
		return new ApiInfoBuilder()
				//描述字段支持Markdown语法
				.description(properties.getDescription())
				.termsOfServiceUrl(properties.getTermsOfServiceUrl())
				.contact(new Contact(contact.getName(), contact.getUrl(), contact.getEmail()))
				.version(properties.getVersion())
				.build();
	}
}
