package RPIS81.Mochalov.oop.model;

import java.util.Arrays;
import java.util.Objects;

public class AccountManager {
    private Account [] accounts;
    private int size;
    //конструктор принимающий один параметр – число счетов, инициализирующий массив
    //соответствующим числом элементов (сами элементы имеют значение null)
    public AccountManager(int NumberOfCounts) {
        accounts = new Account[NumberOfCounts];
        size = NumberOfCounts;
    }
    /* конструктор принимающий массив счетов. В этом конструкторе происходит копирование элементов в
новый массив, и ссылка на него записывается в атрибут. */
    public AccountManager(Account[] accounts) {
        this.accounts = new Account[accounts.length];
        System.arraycopy(accounts, 0, this.accounts, 0, accounts.length);
        size = accounts.length;
    }
    /*метод добавляющий счет в первое свободное место в массиве (принимает ссылку класса Account).
    Пока этот метод возвращает истину после выполнения операции добавления элемента.*/
    public boolean addAccount(Account account) {
        if (size == 0) return false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                size--;
                break;
            }
        }
        return true;
    }
    /*метод добавляющий счет в заданное место в массиве (принимает номер и ссылку на экземпляр класса Account).
   Пока этот метод возвращает истину после выполнения операции добавления элемента.*/
    public boolean addAccountInto(Account account, int index) {
        if (size == 0 || index >= accounts.length || index < 0) return false;
        System.arraycopy(account, index, account, index + 1, accounts.length - index);
        size--;
        return true;
    }
    /*метод возвращающий ссылку на экземпляр класса Account по его номеру в массиве.*/
    public Account getAccountAt(int index) {
        if (index < 0 || index > accounts.length) return null;
        return accounts[index];
    }
    /*метод изменяющий ссылку на экземпляр класса Account по его номеру в массиве.
    Принимает в качестве параметров номер и ссылку на экземпляр класса Account. Возвращает ссылку, которую заменили.*/
    public Account removeAccount(Account account, int index) {
        if (index < 0 || index > accounts.length) return null;
        Account temp = accounts[index];
        if (temp == null) size--;
        accounts[index] = account;
        return temp;
    }
    /*метод удаляющий элемент по номеру в массиве (принимает номер в массиве в качестве параметра).
    Возвращает удаленную из массива ссылку на экземпляр класса Account.*/
    public Account removeAccountAt(int index) {
        if (index < 0 || index > accounts.length) return null;
        Account temp = accounts[index];
        accounts[index] = null;
        size++;
        return temp;
    }
    /*метод возвращающий общее число счетов.*/
    public int getAccountsCount() {
        return accounts.length - size;
    }

    /*метод возвращающий массив счетов (значений null в массиве быть не должно,
    его размер должен быть равен числу элементов в исходном массиве).*/
    public Service[] getAllAccount() {
        return Arrays.stream(accounts).filter(Objects::nonNull).toArray(Service[]::new);
    }

    /*метод возвращающий ссылку на экземпляр класса IndividualsTariff для счета с заданным
номером.
   В качестве параметра принимает номер счета.*/
 /*   public IndividualsTariff findSIndividualsTariffByTitle(int Number) {
        for (IndividualsTariff elem : numbers) {
            if (Number.equals(elem.getNumber())) return elem;
        }
        return null;
    } */
}
