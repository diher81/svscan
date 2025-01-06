package nl.solevision.svscan;

import nl.solevision.svscan.ui.JavaFxApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SvScanApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SvScanApplication.class, args);
		JavaFxApp.launchApp(context, args);
	}
}
