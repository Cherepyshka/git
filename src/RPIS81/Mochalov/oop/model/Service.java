package RPIS81.Mochalov.oop.model;

public class Service<string> {
    private string Name;
    private double cost;
    public string getName(string Name) {
        return Name;
    }
    public void setName(string Newname) {
        this.Name = Newname;
    }
    public static double getCost(double cost) {
        return cost;
    }
    public void setCost(double NewCost) {
        this.cost = NewCost;
    }

    public static void main(String[] args) {
        Service Beeline = new Service();
        Service Tele2 = new Service();
        Person Yakov = new Person("Yakov", "Mochalov");
        Person Pavel = new Person("Pavel", "Bureev");
    }
    Service() {
        Name = (string) "Интернет 100 мб/сек";
        cost = 300;
    }
    Service(String Name, int price) {
        this.Name = (string) Name;
        this.cost = price;
    }


    public string getName() {
        return Name;
    }
    public double getCost() {
        return cost;
    }

}