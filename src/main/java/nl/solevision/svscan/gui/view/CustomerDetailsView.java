package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;

import javax.swing.*;
import java.awt.*;

public class CustomerDetailsView extends JPanel {

    public CustomerDetailsView(NavigationObserver observer) {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Voornaam:"));
        JTextField firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Tussenvoegsel:"));
        JTextField prepositionField = new JTextField();
        add(prepositionField);

        add(new JLabel("Achternaam:"));
        JTextField familyNameField = new JTextField();
        add(familyNameField);

        add(new JLabel("Geboortedatum:"));
        JTextField birthDateField = new JTextField();
        add(birthDateField);

        add(new JLabel("E-mail:"));
        JTextField emailField = new JTextField();
        add(emailField);

        JRadioButton btnMale = createRadioButton("Mannelijk", 180, 120);
        JRadioButton btnFemale = createRadioButton("Vrouwelijk", 240, 120);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(btnMale);
        genderGroup.add(btnFemale);

        JButton nextButton = new JButton("Volgende");
        nextButton.addActionListener(e -> {
            // Validate and store data
            observer.onNavigate("INFO");
        });
        add(nextButton, BorderLayout.SOUTH);
    }

    private JRadioButton createRadioButton(String text, int x, int y) {
        JRadioButton radio = new JRadioButton(text);
        radio.setBounds(x, y, 120, 40);
        add(radio);
        return radio;
    }
}
