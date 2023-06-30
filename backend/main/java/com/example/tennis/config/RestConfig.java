package com.example.tennis.config;

import com.example.tennis.entity.Court;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    //not allow adding or removing courts (POST, DELETE)

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
        HttpMethod [] theUnsupportedActions = {HttpMethod.POST, HttpMethod.DELETE};

        repositoryRestConfiguration.getExposureConfiguration()
                .forDomainType(Court.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
