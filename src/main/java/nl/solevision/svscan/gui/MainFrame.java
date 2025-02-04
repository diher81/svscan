package nl.solevision.svscan.gui;

import nl.solevision.svscan.gui.navigation.NavigationController;
import nl.solevision.svscan.gui.navigation.NavigationObserver;
import nl.solevision.svscan.gui.view.*;
import nl.solevision.svscan.service.RocketService;

import javax.swing.*;

public class MainFrame extends JFrame implements NavigationObserver {

    private final NavigationController navigationController;

    public MainFrame() {
        setTitle("Foot Scanner");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.navigationController = new NavigationController(this);
        initializeViews();
    }

    private void initializeViews() {
        navigationController.registerView("WELCOME", new WelcomeView(this));
        navigationController.registerView("CUSTOMER_DETAILS", new CustomerDetailsView(this));
        navigationController.registerView("MAIN_VIEW", new MainView(this));
        navigationController.registerView("INFO", new InfoView(this));
        navigationController.registerView("THANK_YOU", new ThankYouView());

        navigationController.navigateTo("WELCOME");
    }

    @Override
    public void onNavigate(String destination) {
        navigationController.navigateTo(destination);
    }
}
