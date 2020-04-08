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
        this.tariff= tariff;
        this.person = person;
        this.number = number;
    }

    public Account() {}


    //метод возвращающий номер счета
    public long getNumber() {
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
    public IndividualsTariff getTariff(){
        return tariff;
    }
    //метод устанавливающий новую ссылку на экземпляр класса IndividualsTariff
    public void setTariff(IndividualsTariff tariff) {
        this.tariff = tariff;
    }


}
