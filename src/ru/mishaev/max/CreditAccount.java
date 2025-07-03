package ru.mishaev.max;

public class CreditAccount extends Account {
    private final long creditLimit;

    public CreditAccount(long amount) {
        super(amount < 0 ? amount : amount * (-1));
        amount = amount < 0 ? amount : amount * (-1);
        this.creditLimit = amount;
    }

    public void setBalance(long amount) {
        this.balance = amount;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    @Override
    public boolean add(long amount) {
        amount = amount < 0 ? amount : amount * (-1);
        if (amount + getBalance() >= creditLimit) {
            setBalance(getBalance() + amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        amount = amount > 0 ? amount : amount * (-1);
        if (amount + getBalance() <= 0) {
            setBalance(getBalance() + amount);
            return true;
        }
        return false;
    }

}
