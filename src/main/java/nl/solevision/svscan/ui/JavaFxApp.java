package nl.solevision.svscan.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApp extends Application {

    private static ConfigurableApplicationContext springContext;

    private NAWScene nawScene = new NAWScene();

    public static void launchApp(ConfigurableApplicationContext context, String[] args) {
        springContext = context;
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("SoleVision scanner");
        stage.setScene(nawScene.getPersonalDataForm());
        stage.show();
    }

    @Override
    public void stop() {
        springContext.close();
    }
}
