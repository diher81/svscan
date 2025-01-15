package nl.solevision.svscan.gui;

//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;

import javax.swing.*;

public class PersonalDataView extends JFrame {


    public PersonalDataView() {
        setTitle("CallRocket");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnNext = new JButton("Volgende");
        btnNext.setBounds(125, 360, 120, 40);
        btnNext.addActionListener(e -> {
            //setResult(rocketHelper.rocketExit());
        });
        add(btnNext);
    }


//    public Scene createScene(Stage primaryStage) {
//        VBox layout = new VBox();
//
//        layout.getChildren().addAll(getLblTitle(), getLblFirstName(), getTxtFirstName(),
//                getLblMiddleName(), getTxtMiddleName(), getLblSurname(), getTxtSurname(),
//                getLblDateOfBirth(), getTxtDateOfBirth(), getLblEmail(), getTxtEmail(),
//                getLblSex(), getRadioMale(), getRadioFemale(), getBtnNext());
//
//        return new Scene(layout, 400, 300);
//    }
//
//    private static Button getBtnNext() {
//        Button button = new Button();
//        button.setText("Volgende");
//        GridPane.setConstraints(button, 1, 9);
//        return button;
//    }
//
//    private static RadioButton getRadioFemale() {
//        RadioButton radioFemale = new RadioButton();
//        radioFemale.setText("Vrouwelijk");
//        GridPane.setConstraints(radioFemale, 1, 8);
//        return radioFemale;
//    }
//
//    private static RadioButton getRadioMale() {
//        RadioButton radioMale = new RadioButton();
//        radioMale.setText("Mannelijk");
//        GridPane.setConstraints(radioMale, 1, 7);
//        return radioMale;
//    }
//
//    private static Label getLblSex() {
//        Label lblSex = new Label("Geslacht(*)");
//        GridPane.setConstraints(lblSex, 0, 7);
//        return lblSex;
//    }
//
//    private static TextField getTxtEmail() {
//        TextField txtEmail = new TextField();
//        txtEmail.setPromptText("Vul hier uw e-mailadres in aub");
//        GridPane.setConstraints(txtEmail, 1, 6);
//        return txtEmail;
//    }
//
//    private static Label getLblEmail() {
//        Label lblEmail = new Label("E-mail(*)");
//        GridPane.setConstraints(lblEmail, 0, 6);
//        return lblEmail;
//    }
//
//    private static TextField getTxtDateOfBirth() {
//        TextField txtDateOfBirth = new TextField();
//        txtDateOfBirth.setPromptText("Vul hier uw geboortedatum in aub");
//        GridPane.setConstraints(txtDateOfBirth, 1, 5);
//        return txtDateOfBirth;
//    }
//
//    private static Label getLblDateOfBirth() {
//        Label lblDateOfBirth = new Label("Geboortedatum(*)");
//        GridPane.setConstraints(lblDateOfBirth, 0, 5);
//        return lblDateOfBirth;
//    }
//
//    private static TextField getTxtSurname() {
//        TextField txtSurname = new TextField();
//        txtSurname.setPromptText("Vul hier uw familienaam in aub");
//        GridPane.setConstraints(txtSurname, 1, 4);
//        return txtSurname;
//    }
//
//    private static Label getLblSurname() {
//        Label lblSurname = new Label("Familienaam(*)");
//        GridPane.setConstraints(lblSurname, 0, 4);
//        return lblSurname;
//    }
//
//    private static TextField getTxtMiddleName() {
//        TextField txtMiddleName = new TextField();
//        txtMiddleName.setPromptText("Vul eventueel een tussenvoegsel in");
//        GridPane.setConstraints(txtMiddleName, 1, 3);
//        return txtMiddleName;
//    }
//
//    private static Label getLblMiddleName() {
//        Label lblMiddleName = new Label("Tussenvoegsel");
//        GridPane.setConstraints(lblMiddleName, 0, 3);
//        return lblMiddleName;
//    }
//
//    private static TextField getTxtFirstName() {
//        TextField txtFirstName = new TextField();
//        txtFirstName.setPromptText("Vul hier uw voornaam in aub");
//        GridPane.setConstraints(txtFirstName, 1, 2);
//        return txtFirstName;
//    }
//
//    private static Label getLblFirstName() {
//        Label lblFirstName = new Label("Voornaam(*)");
//        GridPane.setConstraints(lblFirstName, 0, 2);
//        return lblFirstName;
//    }
//
//    private static Label getLblTitle() {
//        Label lblTitle = new Label("Vul aub onderstaande gegevens in.");
//        GridPane.setConstraints(lblTitle, 0, 0);
//        return lblTitle;
//    }
}
