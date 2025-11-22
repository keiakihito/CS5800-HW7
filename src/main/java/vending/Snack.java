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
        return _quantity > 0;
    }

    public void decrement() {
        if (_quantity > 0) {
            _quantity--;
        }
    }

    @Override
    public String toString() {
        return "Snack{name='%s', price=%.2f, quantity=%d}".formatted(_name, _price, _quantity);
    }
}
