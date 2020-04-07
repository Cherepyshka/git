package RPIS81.Mochalov.oop.model;

public class Account {
    private long number;
    private Person person;
    private IndividualsTariff tariff;



    public Account(long number, Person person){
        System.out.println("интернет 100мб/сек");
        System.out.println("Стоимость - 300");
    }
    public Account(long number, Person person, IndividualsTariff tariff){

    }
    //метод возвращающий номер счета
    public long getNumber(long number) {
        return number;
    }
    //метод возвращающий ссылку на экземпляр класса Person
    public Person getPerson(Person person){
       return person;
    }
    //метод устанавливающий новую ссылку на экземпляр класса Person
    public void setPerson(Person person) {
        this.person = person;
    }
    //метод возвращающий ссылку на экземпляр класса IndividualsTariff
    public IndividualsTariff getTariff(IndividualsTariff tariff){
        return tariff;
    }
    //метод устанавливающий новую ссылку на экземпляр класса IndividualsTariff
    public void setTariff(IndividualsTariff tariff) {
        this.tariff = tariff;
    }
}
