package nl.solevision.svscan;

import nl.solevision.svscan.gui.MainFrame;

import javax.swing.*;

public class SvScanApplication extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
