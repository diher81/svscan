package nl.solevision.svscan.gui.navigation;

import javax.swing.*;
import java.awt.*;

public class NavigationController {
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel viewsPanel;

    public NavigationController(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.cardLayout = new CardLayout();
        this.viewsPanel = new JPanel(cardLayout);
        mainFrame.add(viewsPanel);
    }

    public void registerView(String name, JPanel view) {
        viewsPanel.add(view, name);
    }

    public void navigateTo(String viewName) {
        cardLayout.show(viewsPanel, viewName);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
