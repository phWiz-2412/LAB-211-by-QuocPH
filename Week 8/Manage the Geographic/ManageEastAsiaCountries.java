import java.util.*;

public class ManageEastAsiaCountries {
    private final List<EastAsiaCountries> countryList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void addCountryInformation() {
        System.out.print("Enter country code: ");
        String code = sc.nextLine();
        System.out.print("Enter country name: ");
        String name = sc.nextLine();
        System.out.print("Enter total area: ");
        float area = sc.nextFloat();
        sc.nextLine(); 
        System.out.print("Enter country terrain: ");
        String terrain = sc.nextLine();

        countryList.add(new EastAsiaCountries(code, name, area, terrain));
    }

    public void getRecentlyEnteredInformation() {
        if (countryList.isEmpty()) {
            System.out.println("No countries entered.");
            return;
        }
        System.out.println("ID   | Name                 | Total Area | Terrain");
        countryList.get(countryList.size() - 1).display();
    }

    public void searchInformationByName() {
        System.out.print("Enter country name to search: ");
        String name = sc.nextLine();
        boolean found = false;
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                System.out.println("ID   | Name                 | Total Area | Terrain");
                country.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Country not found.");
    }

    public void sortInformationByAscendingOrder() {
        countryList.sort(Comparator.comparing(Country::getCountryName));
        System.out.println("ID   | Name                 | Total Area | Terrain");
        for (EastAsiaCountries country : countryList) {
            country.display();
        }
    }
}
