package nl.solevision.svscan.gui.style;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StyledPanel extends JPanel {

    public StyledPanel() {

        setBackground(Color.decode("#ece9df"));

        ImageIcon imgSoleVision = new ImageIcon(Objects.requireNonNull(getClass().getResource("/logoSoleVision12perc.png")));
        JLabel lblSoleVision = new JLabel(imgSoleVision);
        lblSoleVision.setHorizontalAlignment(SwingConstants.LEFT);
        lblSoleVision.setVerticalAlignment(SwingConstants.TOP);

        add(lblSoleVision, BorderLayout.PAGE_START);
    }
}
