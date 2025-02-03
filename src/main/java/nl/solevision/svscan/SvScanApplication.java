package nl.solevision.svscan;

import nl.solevision.svscan.gui.CallRocketDemo;

import javax.swing.*;

public class SvScanApplication extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CallRocketDemo().setVisible(true));
    }
}
