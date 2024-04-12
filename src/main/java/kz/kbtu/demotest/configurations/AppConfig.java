package kz.kbtu.demotest.configurations;
import kz.kbtu.demotest.Item;
import kz.kbtu.demotest.ItemImpl1;
import kz.kbtu.demotest.Store;
import kz.kbtu.demotest.model.HelloMessageGenerator;
import kz.kbtu.demotest.model.Person;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;


@Configuration
public class AppConfig {
        @Bean
        public Item item1() {
            return new ItemImpl1();
        }

        @Bean
        public Store store() {
            return new Store(item1());
//            Store store = new Store();
//            store.setItem(item1());
//            return store;
        }

    @Bean(name = "personSingleton")
    @Scope("singleton")
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    @Scope("prototype")
    public Person personPrototype() {
        return new Person();
    }


//    @Bean
//    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public HelloMessageGenerator requestScopedBean() {
//        return new HelloMessageGenerator();
//    }
//    public static void main(String[] args) {
        // Пример создания контейнера через XML-конфигурацию
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        // Пример создания контейнера через аннотации
//
//        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();

//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        Car car = context.getBean(Car.class);
//    }



}