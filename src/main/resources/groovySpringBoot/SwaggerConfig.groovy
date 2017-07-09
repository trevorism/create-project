
import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.UiConfiguration

/**
 * @author tbrooks
 */
@Configuration
class SwaggerConfig {

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("")
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()

    }

    @Bean
    UiConfiguration uiConfig() {
        new UiConfiguration("")
    }

    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("")
            .description("")
            .version("")
            .build()
    }
}
