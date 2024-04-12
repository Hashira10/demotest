package kz.kbtu.demotest.configurations;

import jakarta.annotation.Resource;
import kz.kbtu.demotest.controller.ScopesController;
import kz.kbtu.demotest.model.Engine;
import kz.kbtu.demotest.model.HelloMessageGenerator;
import kz.kbtu.demotest.model.Transmission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@ComponentScan("kz.kbtu.demotest")
@Slf4j
public class Config {
    @Bean
    public Engine engine() {

        return new Engine("v8", 5);
    }

    @Bean
    public Transmission transmission() {

        return new Transmission("sliding");
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @ApplicationScope
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator websocketScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }


    public static final Logger LOG = LoggerFactory.getLogger(ScopesController.class);

}
