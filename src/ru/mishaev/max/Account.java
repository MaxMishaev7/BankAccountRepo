package ru.mishaev.max;

public abstract class Account {
    protected long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }


    public abstract boolean add(long amount);

    public abstract boolean pay(long amount);

    /*
    boolean transfer(Account account, long amount) — перевод денег со счёта,
    у которого был вызван метод,на счёт из параметра на сумму в размере amount. Возвращает true,
    если пополнение успешно, и false, если иначе;
     */

    //public abstract boolean transfer(Account account, long amount);

    public boolean transfer(Account account, long amount) {
        if (pay(amount)) {
            if (account.add(amount)) {
                return true;
            } else {
                add(amount);
                return false;
            }
        }
        return false;
    }

}
