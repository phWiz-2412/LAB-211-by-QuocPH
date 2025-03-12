class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {}

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public void display() {
        System.out.printf("%-5s | %-15s | %-10.2f\n", countryCode, countryName, totalArea);
    }
}
