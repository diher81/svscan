package nl.solevision.svscan.exception;

public enum ExceptionCode {

        APPLICATION_FAILED_TO_START("Application XSOL_3D_Foot_Scan failed to start");

    private final String detail;

    ExceptionCode(final String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
