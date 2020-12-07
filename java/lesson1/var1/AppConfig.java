package lesson1.var1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="cameraRoll")
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

    @Bean(name="camera")
    public Camera camera(CameraRoll cameraRoll){
        Camera camera = new Camera();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
/*
это то же самое, что в файле xml следующие строки:
<bean id="cameraRoll" class="lesson1.var1.ColorCameraRoll" />

<bean id="camera" class="lesson1.var1.Camera">
  <property name="cameraRoll">
    <ref bean="cameraRoll" />
  </property>
</bean>
 */
