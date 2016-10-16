package com.fungo.comment.guice;

import com.fungo.comment.controller.CommentController;
import com.fungo.comment.controller.Hello;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.eclipse.jetty.servlet.DefaultServlet;

import java.util.HashMap;

/**
 * Created by fornia on 16/10/15.
 */
public class MyServletModule extends ServletModule {

    protected void configureServlets() {
        bind(DefaultServlet.class).in(Singleton.class);
        bind(Hello.class).in(Singleton.class);
        bind(CommentController.class).in(Singleton.class);

        //bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
        //bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        options.put("com.sun.jersey.config.property.packages", "com.fungo.comment.controller");
        options.put("com.sun.jersey.spi.container.ContainerRequestFilters","api.AuthRequestFiter");
        serve("/*").with(GuiceContainer.class, options);
    }
}
