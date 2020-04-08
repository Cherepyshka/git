package RPIS81.Mochalov.oop.model;


public class AccountManager {
    private Account [] accounts;
    private int size;
    private final static Account DEFAULT_ACCOUNT = new Account();
    final static IndividualsTariff DEFAULT_TARIFF = new IndividualsTariff();
    //конструктор принимающий один параметр – число счетов, инициализирующий массив
    //соответствующим числом элементов (сами элементы имеют значение null)
    public AccountManager(int size) {
        this.accounts = new Account[size];
        this.size = size;
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
    public Account setAccount(Account account, int index) {
        if (index < 0 || index > accounts.length) return null;
        Account temp = accounts[index];
        if (temp == null) size--;
        accounts[index] = account;
        return DEFAULT_ACCOUNT;
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
    public Account[] getAccounts(){
        Account[] newServices = new Account[getAccountsCount()];
        int counter = 0;
        for (Account account : accounts){
            if (account!=null) {
                newServices[counter] = account;
                counter++;
            }
        }
        return newServices;
    }

    //  возвращающий ссылку на экземпляр класса IndividualsTariff для счета с заданным номером
    public IndividualsTariff getTariff(long accountNumber){
        for (Account account: getAccounts()){
            if (account.getNumber()==accountNumber) return account.getTariff();
        }
        return DEFAULT_TARIFF;
    }

    /*метод возвращающий ссылку на экземпляр класса IndividualsTariff для счета с заданным
номером.
   В качестве параметра принимает номер счета.*/
    public  IndividualsTariff setTariff(int accountNumber,IndividualsTariff tariff){
        IndividualsTariff individualsTariff = getTariff(accountNumber);
        for (int i = 0; i< getAccounts().length; i++){
            if (getAccounts()[i].getNumber()==accountNumber) accounts[i].setTariff(tariff);
        }
        return individualsTariff;
    }
}
