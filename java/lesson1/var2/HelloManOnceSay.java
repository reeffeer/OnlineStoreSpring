package lesson1.var2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloManOnceSay implements HelloMan {
    @Value("Shiyaki")
    private String name;

    public HelloManOnceSay(){
    }

    public HelloManOnceSay(String name){
        this.name = name;
    }

    @Override
    public void helloSay() {
        System.out.println("Hello," + this.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
