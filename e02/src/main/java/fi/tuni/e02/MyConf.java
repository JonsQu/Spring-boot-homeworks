package fi.tuni.e02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConf {

    @Bean
    public CommandLineRunner getBean() {
        MyBean bean = new MyBean("Another Hello!");
        return bean;
    }
    @Bean
    @Scope("prototype")
    public HtmlHelper getHtmlHelper(){
        return new HtmlHelperImpl(true);
    }
}
