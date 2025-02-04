package nl.solevision.svscan.gui.view;

import javax.swing.*;
import java.awt.*;

public class ThankYouView extends JPanel {
    public ThankYouView() {
        setLayout(new BorderLayout());
        add(new JLabel("<html><center>Thank You for Using Our Service!</center></html>"),
                BorderLayout.CENTER);
    }
}
