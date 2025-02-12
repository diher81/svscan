package nl.solevision.svscan.gui.view;

import nl.solevision.svscan.gui.navigation.NavigationObserver;
import nl.solevision.svscan.gui.style.StyledButton;
import nl.solevision.svscan.gui.style.StyledPanel;
import nl.solevision.svscan.service.RocketService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RocketView extends StyledPanel implements NavigationObserver {

    private final RocketService rocketService;
    private final JLabel resultLabel = new JLabel();
    private final java.util.List<JComponent> controls = new ArrayList<>();
    private final ButtonGroup laserGroup = new ButtonGroup();

    public RocketView(NavigationObserver observer, RocketService rocketService) {
        this.rocketService = rocketService;
        initializeUI(observer);
        doTask(0); // Start Rocket
    }

    private void initializeUI(NavigationObserver observer) {

        // Components
        JButton btnSerial = createButton("Obtain Serial No.", 125, 60, e -> doTask(5));
        JLabel laserLabel = createLabel("hiel/teen laser", 20, 125);

        JRadioButton btnLaserOn = createRadioButton("Aan", 180, 120, e -> doTask(6));
        JRadioButton btnLaserOff = createRadioButton("Uit", 240, 120, e -> doTask(7));
        laserGroup.add(btnLaserOn);
        laserGroup.add(btnLaserOff);

        JButton btnScan = createButton("Scan voeten", 50, 180, e -> doTask(1));
        JButton btnSave = createButton("Bestand opslaan", 125, 300, e -> doTask(3));
        JButton btnExit = createButton("Afsluiten", 125, 360, e -> doTask(4));

        resultLabel.setBounds(10, 420, 400, 40);
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.WHITE);
        add(resultLabel);

        addTips(450, 50, "tips");
        addTips(450, 200, "tips");

        JButton startButton = new StyledButton("Volgende");
        startButton.addActionListener(e -> observer.onNavigate("GOODBYE"));
        add(startButton, BorderLayout.SOUTH);
    }

    private JButton createButton(String text, int x, int y, ActionListener listener) {
        JButton btn = new StyledButton(text);
        btn.setBounds(x, y, 120, 40);
        btn.addActionListener(listener);
        add(btn);
        controls.add(btn);
        return btn;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 300, 20);
        add(label);
        return label;
    }

    private JRadioButton createRadioButton(String text, int x, int y, ActionListener listener) {
        JRadioButton radio = new JRadioButton(text);
        radio.setBounds(x, y, 120, 40);
        radio.addActionListener(listener);
        add(radio);
        controls.add(radio);
        return radio;
    }

    private void addTips(int x, int y, String text) {
        JLabel label = new JLabel("<html><div style='width:300px;'>" + text + "</div></html>");
        label.setBounds(x, y, 300, 100);
        add(label);
    }

    private void setStatus(String text) {
        resultLabel.setText(text);
    }

    private void enableAllButtons(boolean enable) {
        for (JComponent comp : controls) {
            comp.setEnabled(enable);
        }
    }

    private void doTask(int taskID) {
        enableAllButtons(false);
        setStatus("Processing...");

        SwingWorker<Void, Void> worker = createWorker(taskID);
        worker.execute();
    }

    private SwingWorker<Void, Void> createWorker(int taskID) {
        return new SwingWorker<Void, Void>() {
            String statusText = "";
            int exitCode = -1;

            @Override
            protected Void doInBackground() throws Exception {
                switch (taskID) {
                    case 0:
                        exitCode = rocketService.rocketStart();
                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 1:
                        exitCode = rocketService.rocketScan("John", "Doe", 0, "000000000000");
                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 2:
//                        exitCode = rocketService.rocketScan(false, "John", "Doe", 0, "000000000000");
//                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 3:
                        exitCode = rocketService.rocketSave();
                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 4:
                        exitCode = rocketService.rocketExit();
                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 5:
                        exitCode = rocketService.rocketMachine();
                        statusText = String.valueOf(exitCode);
                        break;
                    case 6:
                        exitCode = rocketService.rocketTurnOnOffHeelToeLaser(1);
                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 7:
                        exitCode = rocketService.rocketTurnOnOffHeelToeLaser(0);
                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 8:
//                        exitCode = rocketService.rocketScanByFootSwitch(true, "John", "Doe", 0, "000000000000");
//                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    case 9:
//                        exitCode = rocketService.rocketScanByFootSwitch(false, "John", "Doe", 0, "000000000000");
//                        statusText = rocketService.getStatusInfo(exitCode);
                        break;
                    default:
                        statusText = "Unknown task";
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    setStatus(statusText);
                    enableAllButtons(true);
                } catch (Exception e) {
                    //todo use exception class
                    setStatus("Error: " + e.getMessage());
                    enableAllButtons(true);
                }

            }
        };
    }

    @Override
    public void onNavigate(String destination) {
        // Handle any cleanup before navigation if needed
    }
}
