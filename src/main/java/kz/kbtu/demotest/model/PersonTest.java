package kz.kbtu.demotest.model;
import kz.kbtu.demotest.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class PersonTest {

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Hey";

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
        Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

        personSingletonA.setName(NAME);
        Assert.assertEquals(NAME, personSingletonB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }

    public void givenPrototypeScope_whenSetNames_thenDifferentNames() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("scopes.xml");

        Person personPrototypeA = (Person) applicationContext.getBean("personPrototype");
        Person personPrototypeB = (Person) applicationContext.getBean("personPrototype");

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        Assert.assertEquals(NAME, personPrototypeA.getName());
        Assert.assertEquals(NAME_OTHER, personPrototypeB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }

}
