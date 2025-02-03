package nl.solevision.svscan.gui;

import nl.solevision.svscan.service.RocketHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CallRocketDemo extends JFrame {
    private RocketHelper rocketHelper = new RocketHelper();
    private JLabel resultLabel = new JLabel();
    private java.util.List<JComponent> controls = new ArrayList<>();
    private ButtonGroup laserGroup = new ButtonGroup();

    public CallRocketDemo() {
        initializeUI();
        doTask(0); // Start Rocket
    }

    private void initializeUI() {
        setTitle("CallRocket");
        setSize(800, 600);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                doTask(4);
            }
        });

        // Components
        JButton btnSerial = createButton("Obtain Serial No.", 125, 60, e -> doTask(5));
        JLabel laserLabel = createLabel("hiel/teen laser", 20, 125);

        JRadioButton btnLaserOn = createRadioButton("Aan", 180, 120, e -> doTask(6));
        JRadioButton btnLaserOff = createRadioButton("Uit", 240, 120, e -> doTask(7));
        laserGroup.add(btnLaserOn);
        laserGroup.add(btnLaserOff);

        JButton btnScanLeft = createButton("Scan linkervoet", 50, 180, e -> doTask(1));
        JButton btnScanRight = createButton("Scan rechtervoet", 200, 180, e -> doTask(2));
        JButton btnScanLeftFootswitch = createButton("Scan Left Foot By Foot switch", 10, 240, e -> doTask(8));
        JButton btnScanRightFootswitch = createButton("Scan Right Foot By Foot switch", 210, 240, e -> doTask(9));
        JButton btnSave = createButton("Bestand opslaan", 125, 300, e -> doTask(3));
        JButton btnExit = createButton("Afsluiten", 125, 360, e -> doTask(4));

        resultLabel.setBounds(10, 420, 400, 40);
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.WHITE);
        add(resultLabel);

        addTips(450, 50, "Rocket callout draws parameters from settings XML file under " +
                "C:\\XSOL_3D_Foot_Scan\\Bin\\Customize\\Settings. Refer to Command-Line section. " +
                "You can edit the settings XML file before each scan.");
        addTips(450, 200, "You also need to ensure the file save folder exist and you can write to it. " +
                "Otherwise our software will write the files to the desktop.");
    }

    private JButton createButton(String text, int x, int y, ActionListener listener) {
        JButton btn = new JButton(text);
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
        setStatus(" ");

        SwingWorker<Void, Void> worker = createWorker(taskID);
        worker.execute();

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
                        exitCode = rocketHelper.rocketStart();
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 1:
                        exitCode = rocketHelper.rocketScan(true, "John", "Doe", 0, "000000000000");
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 2:
                        exitCode = rocketHelper.rocketScan(false, "John", "Doe", 0, "000000000000");
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 3:
                        exitCode = rocketHelper.rocketSave();
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 4:
                        exitCode = rocketHelper.rocketExit();
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 5:
                        exitCode = rocketHelper.rocketMachine();
                        statusText = String.valueOf(exitCode);
                        break;
                    case 6:
                        exitCode = rocketHelper.rocketTurnOnOffHeelToeLaser(1);
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 7:
                        exitCode = rocketHelper.rocketTurnOnOffHeelToeLaser(0);
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 8:
                        exitCode = rocketHelper.rocketScanByFootswitch(true, "John", "Doe", 0, "000000000000");
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    case 9:
                        exitCode = rocketHelper.rocketScanByFootswitch(false, "John", "Doe", 0, "000000000000");
                        statusText = rocketHelper.getStatusInfo(exitCode);
                        break;
                    default:
                        statusText = "Unknown task";
                }
                return null;
            }

            @Override
            protected void done() {
                setStatus(statusText);
                enableAllButtons(true);
                if (taskID == 4) {
                    new Timer(1000, e -> dispose()).start();
                }
            }
        };
    }
}
