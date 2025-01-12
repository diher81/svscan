package nl.solevision.svscan.gui;

import nl.solevision.svscan.util.RocketHelper;

import javax.swing.*;

public class CallRocketDemo extends JFrame {
    private final RocketHelper rocketHelper = new RocketHelper();
    private final JLabel resultLabel;
    private JRadioButton onButton, offButton;

    public CallRocketDemo() {
        setTitle("CallRocket");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        resultLabel = new JLabel("Status:");
        resultLabel.setBounds(10, 420, 400, 40);
        add(resultLabel);

        JButton startButton = new JButton("Start Rocket");
        startButton.setBounds(125, 60, 120, 40);
        startButton.addActionListener(e -> setResult(rocketHelper.rocketStart()));
        add(startButton);

        onButton = new JRadioButton("Laser On");
        onButton.setBounds(180, 120, 100, 40);
        onButton.addActionListener(e -> setResult(rocketHelper.rocketTurnOnOffHeelToeLaser(true)));
        add(onButton);

        offButton = new JRadioButton("Laser Off");
        offButton.setBounds(300, 120, 100, 40);
        offButton.addActionListener(e -> setResult(rocketHelper.rocketTurnOnOffHeelToeLaser(false)));
        add(offButton);

        ButtonGroup laserGroup = new ButtonGroup();
        laserGroup.add(onButton);
        laserGroup.add(offButton);

        JButton exitButton = new JButton("Exit Rocket");
        exitButton.setBounds(125, 360, 120, 40);
        exitButton.addActionListener(e -> {
            setResult(rocketHelper.rocketExit());
            System.exit(0);
        });
        add(exitButton);

        setVisible(true);
    }

    private void setResult(String text) {
        resultLabel.setText("Status: " + text);
    }
}
