package nl.solevision.svscan;

import nl.solevision.svscan.frontend.JavaFxApp;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SvScanApplication {

	public static void main(String[] args) {
		JavaFxApp.launch(JavaFxApp.class, args);
	}

}
