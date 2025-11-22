package vending;

public class Snack {
    private String _name;
    private double _price;
    private int _quantity;

    public Snack(String name, double price, int quantity) {
        this._name = name;
        this._price = price;
        this._quantity = quantity;
    }

    public String getName() {
        return _name;
    }

    public double getPrice() {
        return _price;
    }

    public int getQuantity() {
        return _quantity;
    }

    public boolean isAvailable() {
        throw new UnsupportedOperationException("stub");
    }

    public void decrement() {
        throw new UnsupportedOperationException("stub");
    }
}
