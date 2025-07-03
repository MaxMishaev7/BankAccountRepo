/*
Задание 1 (обязательное)
Создайте систему классов для описания двух видов счетов:

SimpleAccount — обычный счёт, с которого можно платить, пока на нём есть деньги,
и пополнять сколько угодно раз.

CreditAccount — кредитный счёт, который может уходить в минус до кредитного лимита,
указанного в конструкторе, но не может уходить в плюс.

Оба счёта логично сделать наследниками общего класса Account.

У любого счёта должно быть три операции. Никакая из трёх операций ничего не должна выводить на экран:

boolean add(long amount) — пополнение счёта на amount, возвращает true,
если пополнение успешно, и false, если иначе;

boolean pay(long amount) — покупка со счёта на amount, возвращает true,
если покупка успешна, и false, если иначе;

boolean transfer(Account account, long amount) — перевод денег со счёта, у которого был вызван метод,
на счёт из параметра на сумму в размере amount, возвращает true, если пополнение успешно,
и false, если иначе;

long getBalance() — метод возвращает текущий баланс на счёте.

Мы советуем реализовать операцию transfer как комбинацию из двух других операций.



Задание 2 (обязательное)
Перед вами интерфейс Logger, описывающий объекты, умеющие логировать,
т. е. журналировать сообщения из программы. В нашем случае журналом будет консоль:

public interface Logger {
    void log(String msg);
}
Напишите две реализации этого интерфейса: SimpleLogger и SmartLogger.

Логгер типа SimpleLogger при вызове метода log должен выводить на экран текст вида: [2022-12-17T19:04:28.907390] <сообщение>, где в квадратных скобках указаны точная дата и время вызова метода. Его можно получить с помощью LocalDateTime.now(), возвращённый этой командой объект можно напрямую склеивать с текстом через +.

Логгер типа SmartLogger должен иметь текст вида INFO#13 [2022-12-17T19:04:28.907390] <сообщение>. Вместо 13 следует указать порядковый номер вызова метода log у этого логгера (нумеровать с 1). В случае, если в сообщении есть слово error (всё равно в каком регистре), то INFO следует заменить на ERROR.

 */

import ru.mishaev.max.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SimpleAccount myAccount = new SimpleAccount(100_000);
        System.out.println("Balance: " + myAccount.getBalance());

        if (myAccount.add(50_000)) {
            System.out.println("Добавлено. Счёт: " + myAccount.getBalance());
        } else {
            System.out.println("Не добавлено. Счёт: " + myAccount.getBalance());
        }

        Account yourAccount = new SimpleAccount(120_000);
        System.out.println("Счёт пополнен? " + yourAccount.add(30_000) + " Баланс: " + yourAccount.getBalance());
        System.out.println("Оплата проведена? " + yourAccount.pay(70_000) + " Баланс: " + yourAccount.getBalance());
        System.out.println("Transfer: " + myAccount.transfer(yourAccount, 40_000) + ", Баланс: " + myAccount.getBalance() + ", " + yourAccount.getBalance());
        System.out.println("Transfer2: " + yourAccount.transfer(myAccount, 20_000) + ", Баланс: " + myAccount.getBalance() + ", " + yourAccount.getBalance());

        System.out.println("\nCredit Account");
        CreditAccount myCreditAccount = new CreditAccount(50_000);
        System.out.println("Кредитный лимит: " + myCreditAccount.getCreditLimit());
        System.out.println("Оплата на 24_000 проведена? " + myCreditAccount.pay(24_000) + ", Баланс: " + myCreditAccount.getBalance());
        System.out.println("Пополнение кредитного счёта на 14_000 проведено? " + myCreditAccount.add(14_000) + ", Баланс: " + myCreditAccount.getBalance());
        System.out.println("Пополнение кредитного счёта на 20_000 проведено? " + myCreditAccount.add(20_000) + ", Баланс: " + myCreditAccount.getBalance());
        System.out.println("Оплата с кредитного счёта на сумму 50_000 проведено? " + myCreditAccount.pay(50_000) + ", Баланс: " + myCreditAccount.getBalance());

        System.out.println("\nПеревод с кредитного счёта на сумму 20_000 на обычный проведён? " + myCreditAccount.transfer(myAccount, 20_000)
                + ", Баланс кредитного счёта: " + myCreditAccount.getBalance()
                + ", Баланс обычного счёта: " + myAccount.getBalance());

        System.out.println("\nПеревод с обычного счёта на сумму 70_000 проведён? " + myAccount.transfer(myCreditAccount, 70_000)
                + ", Баланс кредитного счёта: " + myCreditAccount.getBalance()
                + ", Баланс обычного счёта: " + myAccount.getBalance());

        System.out.println("\nПеревод с обычного счёта на сумму 20_000 проведён? " + myAccount.transfer(myCreditAccount, 20_000)
                + ", Баланс кредитного счёта: " + myCreditAccount.getBalance()
                + ", Баланс обычного счёта: " + myAccount.getBalance());

        System.out.println("\nПеревод с обычного счёта на сумму 10_000 проведён? " + yourAccount.transfer(myCreditAccount, 10_000)
                + ", Баланс кредитного счёта: " + myCreditAccount.getBalance()
                + ", Баланс обычного счёта: " + yourAccount.getBalance());

        System.out.println("\nПеревод с кредитного счёта на обычный на сумму 20_000 проведён? " + myCreditAccount.transfer(yourAccount, 20_000)
                + ", Баланс кредитного счёта: " + myCreditAccount.getBalance()
                + ", Баланс обычного счёта: " + yourAccount.getBalance());


    }
}