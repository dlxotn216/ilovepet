/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@SpringBootApplication
public class RecommendationApplicationForDeploy extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RecommendationApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RecommendationApplication.class, args);
    }
}
