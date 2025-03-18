public class Fruit {
    private int id;
    private String name;
    private String origin;
    private double price;
    private int quantity;

    public Fruit(int id, String name, String origin, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getOrigin() { return origin; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
