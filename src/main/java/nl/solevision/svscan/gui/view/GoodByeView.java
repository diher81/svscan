package nl.solevision.svscan.gui.view;

import javax.swing.*;
import java.awt.*;

public class GoodByeView extends StyledPanel {

    public GoodByeView() {
        setLayout(new BorderLayout());
        add(new JLabel("<html><center>Dank u wel om gebruik te maken van onze service!</center></html>"),
                BorderLayout.CENTER);
    }
}
