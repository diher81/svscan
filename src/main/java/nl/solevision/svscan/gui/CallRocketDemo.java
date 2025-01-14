package nl.solevision.svscan.gui;

import nl.solevision.svscan.util.RocketHelper;

import javax.swing.*;

public class CallRocketDemo extends JFrame {
    private final RocketHelper rocketHelper = new RocketHelper();
    private final JLabel lblResult;

    public CallRocketDemo() {
        setTitle("CallRocket");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //todo is this button necessary?
        JButton btnStart = new JButton("Start Rocket");
        btnStart.setBounds(125, 60, 120, 40);
        btnStart.addActionListener(e -> setResult(rocketHelper.rocketStart()));
        add(btnStart);

        JButton btnScannerSerialNo = new JButton("Obtain Serial No.");
        btnScannerSerialNo.setBounds(250, 60, 120, 40);
        btnScannerSerialNo.addActionListener(e -> rocketHelper.obtainSerialNo());
        add(btnScannerSerialNo);

        JLabel lblTurnOnOffLaser = new JLabel("Turn on/off heel/toe laser");
        lblTurnOnOffLaser.setBounds(20, 119, 320, 40);
        add(lblTurnOnOffLaser);

        JRadioButton btnOn = new JRadioButton("Laser On");
        btnOn.setBounds(180, 120, 100, 40);
        btnOn.addActionListener(e -> setResult(rocketHelper.rocketTurnOnOffHeelToeLaser(true)));
        add(btnOn);

        JRadioButton btnOff = new JRadioButton("Laser Off");
        btnOff.setBounds(300, 120, 100, 40);
        btnOff.addActionListener(e -> setResult(rocketHelper.rocketTurnOnOffHeelToeLaser(false)));
        add(btnOff);

        ButtonGroup laserGroup = new ButtonGroup();
        laserGroup.add(btnOn);
        laserGroup.add(btnOff);

        JButton btnScanLeftFoot = new JButton("Scan Left Foot");
        btnScanLeftFoot.setBounds(50, 180, 120, 40);
        btnScanLeftFoot.addActionListener(e -> rocketHelper.scanLeftFoot());
        add(btnScanLeftFoot);

        JButton btnScanRightFoot = new JButton("Scan Right Foot");
        btnScanRightFoot.setBounds(200, 180, 120, 40);
        btnScanRightFoot.addActionListener(e -> rocketHelper.scanRightFoot());
        add(btnScanRightFoot);

        JButton btnExit = new JButton("Exit Rocket");
        btnExit.setBounds(125, 360, 120, 40);
        btnExit.addActionListener(e -> {
            setResult(rocketHelper.rocketExit());
            System.exit(0);
        });
        add(btnExit);

        lblResult = new JLabel("Status:");
        lblResult.setBounds(10, 420, 400, 40);
        add(lblResult);

        setVisible(true);
    }

    private void setResult(String text) {
        lblResult.setText("Status: " + text);
    }
}
