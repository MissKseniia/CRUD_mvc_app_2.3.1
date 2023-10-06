package springMVC.web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("springMVC.web")
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public InternalResourceViewResolver viewResolverResolver() {
        InternalResourceViewResolver viewResolverResolver = new InternalResourceViewResolver();
        viewResolverResolver.setApplicationContext(applicationContext);
        viewResolverResolver.setPrefix("/WEB-INF/views/");
        viewResolverResolver.setSuffix(".jsp");
        return viewResolverResolver;
    }

}
