package ru.mishaev.max;

public class SimpleAccount extends Account {

    public SimpleAccount(long balance) {
        super(balance);
    }

    public void setBalance(long amount) {
        this.balance = amount;
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        if (amount > 0 && amount <= getBalance()) {
          setBalance(getBalance() - amount);
          return true;
        }
        return false;
    }

    /*
    boolean transfer(Account account, long amount) — перевод денег со счёта,
    у которого был вызван метод,на счёт из параметра на сумму в размере amount. Возвращает true,
    если пополнение успешно, и false, если иначе;
     */
//    @Override
//    public boolean transfer(Account account, long amount) {
//        if (pay(amount)) {
//            account.add(amount);
//            return true;
//        }
//        return false;
//    }
}
