package lesson1.var1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CameraTestBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // В данном методе просто возвращаем бин
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Находим бин класса фотокамеры
        if (bean instanceof Camera) {
            System.out.println("Take a test photo!");
            // Делаем пробное фото
            ((Camera) bean).doPhotograph();
            System.out.println("Excellent! It works!");
        }
        return bean;
    }

}
