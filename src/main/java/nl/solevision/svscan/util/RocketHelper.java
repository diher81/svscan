package nl.solevision.svscan.util;

import java.io.IOException;

public class RocketHelper {

    private String callRocket(String command) {
        String rocketPath = "C:\\XSOL_3D_Foot_Scan\\Bin\\XSOL_Rocket.exe";
        try {
            Process process = Runtime.getRuntime().exec(rocketPath + " " + command);
            process.waitFor();
            return "Command executed: " + command;
        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public String rocketStart() {
        return callRocket("-start");
    }

    public String obtainSerialNo() {
        return callRocket("-machine");
    }

    public String rocketExit() {
        return callRocket("-exit");
    }

    public String rocketTurnOnOffHeelToeLaser(boolean on) {
        return callRocket("-TurnOnOffHeelToeLaser " + (on ? "1" : "0"));
    }

    public String rocketScan(boolean left, String firstName, String lastName, int gender, String password) {
        String footSide = left ? "-l" : "-r";
        return callRocket("-scan " + footSide + " " + firstName + " " + lastName + " " + gender + " " + password);
    }

    public String scanLeftFoot() {
        //todo to implement?
        return callRocket("todo");
    }

    public String scanRightFoot() {
        //todo to implement?
        return callRocket("todo");
    }
}
