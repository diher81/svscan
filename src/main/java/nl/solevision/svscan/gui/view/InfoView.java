package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;

import javax.swing.*;
import java.awt.*;

public class InfoView extends StyledPanel {

    public InfoView(NavigationObserver observer) {
        setLayout(new BorderLayout());
        add(new JLabel("<html><center>Belangrijke informatie<br>over het scanproces</center></html>"),
                BorderLayout.CENTER);

        JButton nextButton = new StyledButton("Volgende");
        nextButton.addActionListener(e -> observer.onNavigate("SCAN"));
        add(nextButton, BorderLayout.SOUTH);
    }
}
