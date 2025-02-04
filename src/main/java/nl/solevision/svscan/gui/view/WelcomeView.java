package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;

import javax.swing.*;
import java.awt.*;

public class WelcomeView extends JPanel {

    public WelcomeView(NavigationObserver observer) {
        setLayout(new BorderLayout());
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> observer.onNavigate("CUSTOMER_DETAILS"));
        add(new JLabel("Welcome to Foot Scanner", SwingConstants.CENTER), BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }
}
