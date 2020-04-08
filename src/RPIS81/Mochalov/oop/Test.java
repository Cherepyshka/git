package RPIS81.Mochalov.oop;

import RPIS81.Mochalov.oop.model.*;

public class Test {
    public static void main(String[] args) {

        //System.out.println("Я сделал");
        lab1tests();
    }
 public static void lab1tests(){
    Service Beeline = new Service();
    Service Tele2 = new Service("Интернет 75мб/с", 200);
    Service MTS = new Service("500 SMS", 50);
     IndividualsTariff individualsTariff = new IndividualsTariff();
     individualsTariff.addService(Beeline);
     individualsTariff.addService(Tele2);
     individualsTariff.addService(MTS);
     System.out.println("Получить сервис по индексу");
     System.out.println(individualsTariff.getServiceAt(1).getName());
     System.out.println("Получить сервис по имени");
     System.out.println(individualsTariff.getServiceByTitle("500 SMS").getName());
     System.out.println("Есть ли услуга с заданным названием");
     System.out.println(individualsTariff.isContainByTitle("Интернет 75мб/с"));
     System.out.println("Изменить ссылку по номеру");
     System.out.println(individualsTariff.setService(MTS,3).getName());
     System.out.println("Удалить по номеру");
     System.out.println(individualsTariff.removeServiceAt(0).getName());
     System.out.println("Удалить по имени");
     System.out.println(individualsTariff.removeServiceByTitle("интернет 100 мб\\сек").getName());
     System.out.println("число услуг");
     System.out.println(individualsTariff.getServicesCount());
     System.out.println("Массив услуг");
     for (Service service:individualsTariff.getAllServices()){
         System.out.println(service.getName());
     }
     System.out.println("Сортировка по цене");
     for (Service service:individualsTariff.getAllServicesSortedByPrice()){
         System.out.println(service.getCost());
     }
     System.out.println("Общая стоимость");
     System.out.println(individualsTariff.getTotalCost());
     Person person0 = new Person("Name0","Surname0");
     Person person1 = new Person("Name1","Surname1");
     Person person2 = new Person("Name2","Surname2");
     Account account0 = new Account(0,person0);
     Account account1 = new Account(1,person1);
     Account account2 = new Account(2,person2);
     AccountManager accountManager = new AccountManager(2);
     accountManager.addAccount(account0);
     accountManager.addAccount(account1);
     accountManager.addAccount(account2);
     System.out.println("Получить ссылку по номеру");
     System.out.println(accountManager.getAccountAt(1).getNumber());
     System.out.println("Изменить ссылку по номеру");
     System.out.println(accountManager.setAccount(account2 ,2));
      System.out.println("Удалить по номеру");
      System.out.println(accountManager.removeAccountAt(0).getNumber());
     System.out.println("число счетов");
     System.out.println(accountManager.getAccountsCount());
     System.out.println("массив счетов");
     for (Account account:accountManager.getAccounts()){
         System.out.println(account.getNumber());
     }
     System.out.println("получить тариф по номеру");
     account0.setTariff(individualsTariff);
     for (Service service:accountManager.getTariff(0).getAllServices()){
         System.out.println(service.getName());
     }
 }
}
