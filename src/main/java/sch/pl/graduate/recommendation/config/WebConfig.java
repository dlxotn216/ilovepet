/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.*;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final String[] RESOURCE_LOCATIONS = {
            "classpath:/static/"
    };

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List<ViewResolver> resolvers = new ArrayList<>();

        resolvers.add(jsonViewResolver());
        resolvers.add(thymeleafViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    @Bean
    public ViewResolver jsonViewResolver() {
        return new ViewResolver() {
            @Override
            public View resolveViewName(String viewName, Locale locale) throws Exception {
                MappingJackson2JsonView view = new MappingJackson2JsonView();
                view.setPrettyPrint(true);
                return view;
            }
        };
    }

    @Bean
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());

        Set set = new HashSet();
        set.add(securityDialect());
        templateEngine.setAdditionalDialects(set);

        return templateEngine;
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public ClassLoaderTemplateResolver templateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(0);

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setOrder(2);
        return templateResolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations(RESOURCE_LOCATIONS)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
