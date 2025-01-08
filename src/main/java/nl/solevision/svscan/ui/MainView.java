package nl.solevision.svscan.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nl.solevision.svscan.service.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainView {

    @Autowired
            private ScanService scanService;

    Button startScanButton;
    Button openAppButton;

    public VBox createView(Stage primaryStage) {
        VBox root = new VBox();
        Text welcomeText = new Text("Welkom bij de SoleVision Scanner");
        startScanButton = new Button("Start Scannen");
        openAppButton = new Button("Open applicatie");

        startScanButton.setOnAction(event -> {
            PersonalDataView personalDataView = new PersonalDataView();
            primaryStage.setScene(personalDataView.createScene(primaryStage));
        });

        openAppButton.setOnAction(event -> {
            scanService.startScanning();
        });

        root.getChildren().addAll(welcomeText, startScanButton, openAppButton);

        return root;
    }
}
