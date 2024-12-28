package nl.solevision.svscan.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label lblTitle = new Label("Vul aub onderstaande gegevens in.");
        Label lblFirstName = new Label("Voornaam");
        Label lblMiddleName = new Label("Tussenvoegsel");
        Label lblSurName = new Label("Familienaam");
        Label lblDateOfBirth = new Label("Geboortedatum");
        Label lblEmail = new Label("E-mail");

        TextField txtFirstName = new TextField();
        TextField txtMiddleName = new TextField();
        TextField txtSurName = new TextField();
        TextField txtDateOfBirth = new TextField();
        TextField txtEmail = new TextField();

        Button button = new Button();
        button.setText("Volgende");

        GridPane.setConstraints(lblTitle, 1, 0);
        GridPane.setConstraints(lblFirstName, 0, 2);
        GridPane.setConstraints(lblMiddleName, 0, 3);
        GridPane.setConstraints(lblSurName, 0, 4);
        GridPane.setConstraints(lblDateOfBirth, 0, 5);
        GridPane.setConstraints(lblEmail, 0, 6);

        GridPane.setConstraints(txtFirstName, 1, 2);
        GridPane.setConstraints(txtMiddleName, 1, 3);
        GridPane.setConstraints(txtSurName, 1, 4);
        GridPane.setConstraints(txtDateOfBirth, 1, 5);
        GridPane.setConstraints(txtEmail, 1, 6);

        GridPane.setConstraints(button, 1, 7);

        gridPane.getChildren().addAll(lblTitle,
                lblFirstName, lblMiddleName, lblSurName, lblDateOfBirth, lblEmail,
                txtFirstName, txtMiddleName, txtSurName, txtDateOfBirth, txtEmail,
                button);

        Scene scene = new Scene(gridPane, 400, 300);

        stage.setTitle("SoleVision scanner");
        stage.setScene(scene);
        stage.show();
    }
}
