package lesson1.var1;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
@UnproductiveCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll{
    @Override
    public void processing() {
        System.out.println("-1 black-white shot");
    }

}
