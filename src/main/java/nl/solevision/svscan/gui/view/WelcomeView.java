package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;
import nl.solevision.svscan.gui.style.StyledButton;
import nl.solevision.svscan.gui.style.StyledPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WelcomeView extends StyledPanel {

    public WelcomeView(NavigationObserver observer) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ImageIcon imgSoleVision = new ImageIcon(Objects.requireNonNull(getClass().getResource("/logoSoleVision25perc.png")));
        ImageIcon imgNoShoes = new ImageIcon(Objects.requireNonNull(getClass().getResource("/logoNoShoes12perc.jpg")));

        JLabel lblImgSoleVision = new JLabel(imgSoleVision);
        JLabel lblNoShoes = new JLabel("Niet met schoenen betreden aub.");
        JLabel lblImgNoShoes = new JLabel(imgNoShoes);
        JButton btnStart = new StyledButton("Start");
        btnStart.addActionListener(e -> observer.onNavigate("CUSTOMER_DETAILS"));

        lblImgSoleVision.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNoShoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblImgNoShoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(lblImgSoleVision);
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(lblImgNoShoes);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(lblNoShoes);
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(btnStart);
        add(Box.createVerticalGlue());
    }
}
