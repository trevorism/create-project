
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @author tbrooks
 */
@SpringBootApplication
@EnableSwagger2
class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application)
    }

    static void main(String [] args){
        new SpringApplicationBuilder(Application).properties("spring.profiles.active:local").build().run(args)
    }
}
