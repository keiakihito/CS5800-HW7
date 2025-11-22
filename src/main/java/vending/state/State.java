package vending.state;

public interface State {
    void selectSnack(String name);
    void insertMoney(double amount);
    void dispense();
}
