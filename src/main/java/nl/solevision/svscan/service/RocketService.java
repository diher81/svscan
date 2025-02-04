package nl.solevision.svscan.service;

import nl.solevision.svscan.enums.XsolTaskStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RocketService {

    private Map<Integer, String> rocketStatus = new HashMap<>();
    private int statusNumber = 0;

    public RocketService() {
        initStatus();
    }

    private void initStatus() {
        int iIndex = XsolTaskStatus.XSOL_EXIT_FATAL_ERROR.getValue();
        rocketStatus.put(iIndex, iIndex + " - System fatal error.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Run Rocket without arguments.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Run Rocket with invalid arguments.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Rocket is busy.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Another Rocket is running.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - No Rocket is running.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Lock Pin is engaged and not removed.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - No found control board and cameras.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - No found control board.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - No found cameras.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Start Rocket successful.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Request Rocket to scan foot.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Scan foot failed.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Scan foot failed due to camera frame dropping.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Scan foot successful.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Request Rocket to save file.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Save failed because the save path does not exist.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Save failed because scan data does not exist.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Save file successful.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Request Rocket to exit.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Rocket exited.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Request Rocket to get serial no.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Request Rocket to turn on/off heel/toe laser.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Turn on heel/toe laser.");
        iIndex++;
        rocketStatus.put(iIndex, iIndex + " - Turn off heel/toe laser.");
        statusNumber = iIndex;
    }

    public String getStatusInfo(int iIndex) {
        return rocketStatus.getOrDefault(iIndex, "Unknown status code");
    }

    private int callRocket(List<String> command) {
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();
            return process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int rocketStart() {
        List<String> command = new ArrayList<>();
        command.add("C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe");
        command.add("-start");
        return callRocket(command);
    }

    public int rocketMachine() {
        List<String> command = new ArrayList<>();
        command.add("C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe");
        command.add("-machine");
        return callRocket(command);
    }

    public int rocketTurnOnOffHeelToeLaser(int iOn) {
        List<String> command = new ArrayList<>();
        command.add("C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe");
        command.add("-TurnOnOffHeelToeLaser");
        command.add(iOn == 0 ? "0" : "1");
        return callRocket(command);
    }

    public int rocketScan(boolean bLeft, String strFirstName, String strLastName,
                          int iGender, String strPassword) {
        List<String> command = new ArrayList<>();
        command.add("C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe");
        command.add("-scan");
        command.add(bLeft ? "-l" : "-r");
        command.add(strFirstName);
        command.add(strLastName);
        command.add(String.valueOf(iGender));
        command.add(strPassword);
        return callRocket(command);
    }

    public int rocketScanByFootswitch(boolean bLeft, String strFirstName,
                                      String strLastName, int iGender, String strPassword) {
        List<String> command = new ArrayList<>();
        command.add("C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe");
        command.add("-scanbyfootswitch");
        command.add(bLeft ? "-l" : "-r");
        command.add(strFirstName);
        command.add(strLastName);
        command.add(String.valueOf(iGender));
        command.add(strPassword);
        return callRocket(command);
    }

    public int rocketSave() {
        List<String> command = new ArrayList<>();
        command.add("C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe");
        command.add("-save");
        return callRocket(command);
    }

    public int rocketExit() {
        List<String> command = new ArrayList<>();
        command.add("C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe");
        command.add("-exit");
        return callRocket(command);
    }
}


