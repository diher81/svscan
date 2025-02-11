package nl.solevision.svscan.gui.navigation;

import nl.solevision.svscan.gui.view.StyledPanel;

import javax.swing.*;
import java.awt.*;

public class NavigationController {
    private final JFrame mainFrame;
    private final CardLayout cardLayout;
    private final JPanel viewsPanel;

    public NavigationController(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.cardLayout = new CardLayout();
        this.viewsPanel = new JPanel(cardLayout);
        mainFrame.add(viewsPanel);
    }

    public void registerView(String name, StyledPanel view) {
        viewsPanel.add(view, name);
    }

    public void navigateTo(String viewName) {
        cardLayout.show(viewsPanel, viewName);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
