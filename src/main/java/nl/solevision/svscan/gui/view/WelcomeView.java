package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;

import javax.swing.*;
import java.awt.*;

public class WelcomeView extends StyledPanel {

    public WelcomeView(NavigationObserver observer) {
        setLayout(new BorderLayout());

        add(new JLabel("Welkom bij SVScan", SwingConstants.CENTER), BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> observer.onNavigate("CUSTOMER_DETAILS"));
        add(startButton, BorderLayout.SOUTH);
    }
}
