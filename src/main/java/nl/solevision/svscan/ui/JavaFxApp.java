package nl.solevision.svscan.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.solevision.svscan.controller.MainController;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApp extends Application {

    private static ConfigurableApplicationContext springContext;

    public static void launchApp(ConfigurableApplicationContext context, String[] args) {
        springContext = context;
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MainController mainController = springContext.getBean(MainController.class);
        Scene mainScene = new Scene(mainController.getMainView().createView(stage), 800, 600);

        stage.setTitle("SoleVision scanner");
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void stop() {
        springContext.close();
    }
}
