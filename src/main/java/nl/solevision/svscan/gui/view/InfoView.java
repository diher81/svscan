package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;

import javax.swing.*;
import java.awt.*;

public class InfoView extends JPanel {
    public InfoView(NavigationObserver observer) {
        setLayout(new BorderLayout());
        add(new JLabel("<html><center>Important Information<br>About the Scanning Process</center></html>"),
                BorderLayout.CENTER);

        JButton nextButton = new JButton("Continue");
        nextButton.addActionListener(e -> observer.onNavigate("THANK_YOU"));
        add(nextButton, BorderLayout.SOUTH);
    }
}
