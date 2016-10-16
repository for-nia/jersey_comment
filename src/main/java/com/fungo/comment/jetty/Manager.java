package com.fungo.comment.jetty;

import com.fungo.comment.guice.MyBatisConfig;
import com.fungo.comment.guice.MyServletModule;
import com.fungo.comment.mapper.CommentMapper;
import com.fungo.comment.mapper.Test;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.PrivateModule;
import com.google.inject.name.Names;
import org.apache.ibatis.io.ResolverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by fornia on 16/10/13.
 */
public class Manager {
    private static Logger logger = LoggerFactory.getLogger(Manager.class);
    public static void init(){
        Manager manager = new Manager();
        manager.createInjector();
    }

    public Injector createInjector(){
        return Guice.createInjector(
        new PrivateModule() {
                    @Override
                    protected void configure() {
                        install(new MyBatisConfig());
                        install(new MyServletModule());
                        Names.bindProperties(this.binder(), getConnectionProperties());
                        expose(Test.class);
                        expose(CommentMapper.class);
                    }
                }
        );
    }

    private Properties getConnectionProperties(){
        Properties properties = new Properties();
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");
            properties.load(is);
        } catch (Exception e) {
            logger.error("init fail", e);
            throw new RuntimeException("read configuration exception!", e);
        }
        return properties;
    }
}
