package kz.kbtu.demotest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Store {
//    an object dependency in traditional programming:
//    private Item item;
//    public Store() {
//        item = new ItemImpl1();
//    }

//    using Dependency injection
    @Autowired
    @Qualifier("item1")
    private Item item;
    public Store(Item item) {

        this.item = item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


}
