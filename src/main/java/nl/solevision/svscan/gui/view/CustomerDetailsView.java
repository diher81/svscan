package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;

import javax.swing.*;
import java.awt.*;

public class CustomerDetailsView extends JPanel {

    public CustomerDetailsView(NavigationObserver observer) {
        setLayout(new GridLayout(5, 2));

        // Add form components
        add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        add(firstNameField);

        // Add more fields...

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            // Validate and store data
            observer.onNavigate("MAIN_VIEW");
        });
        add(nextButton);
    }
}
