package utils;

public enum ReportType {
    CLIENT_PER_MONTH("CLIENT_PER_MONTH"),
    CLIENT_PER_DOCTOR("CLIENT_PER_DOCTOR"),
    TIME_IN_DAY("TIME_IN_DAY");

    private String name;
     ReportType(String value){
        name = value;
     }

}
