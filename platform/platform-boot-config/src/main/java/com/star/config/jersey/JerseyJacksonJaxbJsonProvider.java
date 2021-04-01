package com.star.config.jersey;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static javax.ws.rs.RuntimeType.SERVER;

/**
 * @author wangchunlin
 */
@Provider
@Consumes({MediaType.APPLICATION_JSON,MediaType.WILDCARD})
@Produces({MediaType.APPLICATION_JSON,MediaType.WILDCARD})
@ConditionalOnProperty(value = "spring.jersey.application-path")
@ConstrainedTo(SERVER)
@Component
public class JerseyJacksonJaxbJsonProvider extends JacksonJaxbJsonProvider implements InitializingBean {

    @Autowired
    private ResourceConfig resourceConfig;

    public JerseyJacksonJaxbJsonProvider() {
        super();
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if(MediaType.APPLICATION_JSON_TYPE.equals(mediaType)){
            return true;
        }
        return super.isWriteable(type, genericType, annotations, mediaType);
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if(MediaType.APPLICATION_JSON_TYPE.equals(mediaType)){
            return true;
        }
        return super.isReadable(type, genericType, annotations, mediaType);
    }

    @Override
    public void afterPropertiesSet() {
            resourceConfig.register(JerseyJacksonJaxbJsonProvider.class);
            resourceConfig.property( "jersey.config.workers.legacyOrdering",true);
    }
}
