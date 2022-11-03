package utils;

public enum CompanySize {
    SIZE_0_4("0-4 employees"),
    SIZE_5_50("5-50 employees"),
    SIZE_51_350("51-350 employees"),
    SIZE_351_1000("351-1,000 employees"),
    SIZE_1001_3000("1,001-3,000 employees"),
    SIZE_3001_5000("3,001-5,000 employees"),
    SIZE_5000_PLUS(">5,000 employees");

    private String value;

    CompanySize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
