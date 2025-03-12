public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {}

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void display() {
        System.out.printf("%-5s | %-20s | %-10.2f", countryCode, countryName, totalArea);
    }
}
