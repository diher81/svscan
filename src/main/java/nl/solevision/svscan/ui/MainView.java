package nl.solevision.svscan.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class MainView {

    Button startScanButton;

    public VBox createView(Stage primaryStage) {
        VBox root = new VBox();
        Text welcomeText = new Text("Welkom bij de SoleVision Scanner");
        startScanButton = new Button("Start Scannen");

        startScanButton.setOnAction(event -> {
            PersonalDataView personalDataView = new PersonalDataView();
            primaryStage.setScene(personalDataView.createScene(primaryStage));
        });

        root.getChildren().addAll(welcomeText, startScanButton);

        return root;
    }
}
