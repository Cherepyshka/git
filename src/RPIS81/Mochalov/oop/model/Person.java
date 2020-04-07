package RPIS81.Mochalov.oop.model;

public class Person<string, fName, sName> {
    private string fName;
    private string sName;

    /*Конструктор принимающий два параметра – имя, фамилия.*/
    Person(String fName,String sName){
        this.fName = (string) fName;
        this.sName = (string) sName;
    }
    public string getFName(string fName) {
        return fName;
    }
    public void setFName(string fName) {
        this.fName = fName;
    }
    public string getSName(string sName) { return sName;}
    public void setSName(string sName) {
        this.sName = sName;
    }
}
