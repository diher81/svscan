package nl.solevision.svscan.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.solevision.svscan.SvScanApplication;
import nl.solevision.svscan.backend.PersonalDataService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaFxApp extends Application {

    private ApplicationContext springContext;

    @Override
    public void init() throws Exception {
        // Initialize Spring Application Context
        springContext = new AnnotationConfigApplicationContext(SvScanApplication.class);

        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Java home: " + System.getProperty("java.home"));

    }

    @Override
    public void start(Stage stage) throws Exception {
        // Get a Bean from the Spring Context
        PersonalDataService myService = springContext.getBean(PersonalDataService.class);

        Button button = new Button();
        button.setText(myService.getHelloWorld());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);


        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("SoleVision scanner");
        stage.setScene(scene);
        stage.show();
    }
}
