package nl.solevision.svscan.controller;

import lombok.Getter;
import nl.solevision.svscan.ui.MainView;
import org.springframework.stereotype.Controller;

@Getter
@Controller
public class MainController {

    private final MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }
}
