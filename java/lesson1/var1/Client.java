package lesson1.var1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("config.xml"); //это, если через xml
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //а это, если через java-класс конфигурации
//Client asks a camera
        Camera camera = context.getBean("camera", Camera.class);
//Client broke the camera
        camera.breaking();
//Client try to take a photo
        camera.doPhotograph();
//Client asks another camera
        camera = context.getBean("camera", Camera.class);
//Client try to take a photo
        camera.doPhotograph();
    }
}
