package nl.solevision.svscan.frontend;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.solevision.svscan.SvScanApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaFxApp extends Application {


    PersonalDataScene personalDataScene = new PersonalDataScene();

    @Override
    public void init() throws Exception {
        ApplicationContext springContext = new AnnotationConfigApplicationContext(SvScanApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("SoleVision scanner");
        stage.setScene(personalDataScene.getPersonalDataForm());
        stage.show();
    }
}
