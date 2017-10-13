/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final String[] RESOURCE_LOCATIONS = {
            "classpath:/static/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations(RESOURCE_LOCATIONS)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
