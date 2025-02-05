package nl.solevision.svscan.service;

import java.util.ArrayList;
import java.util.List;

public interface RocketService {

    String getStatusInfo(int iIndex);

    int rocketStart();

    int rocketMachine();

    int rocketTurnOnOffHeelToeLaser(int iOn);

    int rocketScan(boolean bLeft, String strFirstName, String strLastName,
                          int iGender, String strPassword);

    int rocketScanByFootSwitch(boolean bLeft, String strFirstName,
                                      String strLastName, int iGender, String strPassword);

    int rocketSave();

    int rocketExit();
}
