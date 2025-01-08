package nl.solevision.svscan.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ScanService {


    public void startScanning() {
        try {
            String command = "C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_3D_Foot_Scan.exe";

            // Run the command
//            Process process = Runtime.getRuntime().exec(command);

            // Alternatively, use ProcessBuilder
             ProcessBuilder processBuilder = new ProcessBuilder(command);
             Process process = processBuilder.start();

        } catch (IOException e) {
            // TODO exception handling
            e.printStackTrace();
        }
    }

}
