package kz.kbtu.demotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService {
    @Autowired
    private FooFormatter fooFormatter;
}

//public class FooService {
//    private FooFormatter fooFormatter;
//
//    @Autowired
//    public void setFormatter(FooFormatter fooFormatter) {
//        this.fooFormatter = fooFormatter;
//    }
//}

//public class FooService {
//    @Autowired(required = false)
//    private FooDAO dataAccessor;
//}


