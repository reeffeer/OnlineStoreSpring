package lesson1.var1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("camera")
@Scope("prototype") //позволяет при каждом getBean возвращать новый объект (а по умолчанию, без этой аннотации, все бины, как все компоненты Spring, синглтоны, единичны)
public class Camera implements CameraInt {

    @Autowired
    @Qualifier("cameraRoll")
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public boolean isBroken() {
        return broken;
    }

    public void breaking() {
        this.broken = true;
    }

    public void doPhotograph() {
        if (isBroken()) {
            System.out.println("Camera is broken!");
            return;
        }
        System.out.println("The photo was taken!");
        cameraRoll.processing();
    }

    @PostConstruct
    public void ready() {
        System.out.println("Фотоаппарат готов к использованию!");
    }

}
