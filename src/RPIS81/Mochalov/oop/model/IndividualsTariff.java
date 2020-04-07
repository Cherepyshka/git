package RPIS81.Mochalov.oop.model;

import java.util.Arrays;
import java.util.Objects;

public class IndividualsTariff {
    private Service[] services;
    private int size;

    /*конструктор по-умолчанию, инициирующий массив из 8 элементов (сами элементы имеют значение null)*/
    public IndividualsTariff() {
        services = new Service[8];
        size = 8;
    }

    //конструктор принимающий целое число – емкость массива, инициирующий массив указанным числом элементов
    public IndividualsTariff(int size) {
        services = new Service[size];
        this.size = size;
    }

    /*конструктор принимающий массив услуг. В этом конструкторе происходит копирование элементов в новый массив,
    и ссылка на него записывается в атрибут.*/
    public IndividualsTariff(Service[] services) {
        this.services = new Service[services.length];
        System.arraycopy(services, 0, this.services, 0, services.length);
        size = services.length;
    }

    /*метод добавляющий услугу в первое свободное место в массиве (принимает ссылку на экземпляр класса Service).
    Пока этот метод возвращает истину после выполнения операции добавления элемента.*/
    public boolean addService(Service service) {
        if (size == 0) return false;
        for (int i = 0; i < services.length; i++) {
            if (services[i] == null) {
                services[i] = service;
                size--;
                break;
            }
        }
        return true;
    }

    /*метод добавляющий услугу в заданное место в массиве (принимает номер и ссылку на экземпляр класса Service).
    Пока этот метод возвращает истину после выполнения операции добавления элемента.*/
    public boolean addServiceInto(Service service, int index) {
        if (size == 0 || index >= services.length || index < 0) return false;
        System.arraycopy(services, index, services, index + 1, services.length - index);
        size--;
        return true;
    }

    /*метод возвращающий ссылку на экземпляр класса Service по его номеру в массиве.*/
    public Service getServiceAt(int index) {
        if (index < 0 || index > services.length) return null;
        return services[index];
    }

    /*метод возвращающий ссылку на экземпляр класса Service, по названию.
   В качестве параметра принимает строку – название услуги.*/
    public Service getServiceByTitle(String serviceName) {
        for (Service elem : services) {
            if (serviceName.equals(elem.getName())) return elem;
        }
        return null;
    }

    /*метод определяющий, есть ли в тарифе услуга с заданным названием.
    В качестве параметра принимает строку – название услуги. Возвращает логическое значение.*/
    public boolean isContainByTitle(String serviceName) {
        for (Service elem : services) {
            if (serviceName.equals(elem.getName())) return true;
        }
        return false;
    }

    /*метод изменяющий ссылку на экземпляр класса Service по его номеру в массиве.
    Принимает в качестве параметров номер и ссылку на экземпляр класса Service. Возвращает ссылку, которую заменили.*/
    public Service removeService(Service service, int index) {
        if (index < 0 || index > services.length) return null;
        Service temp = services[index];
        if (temp == null) size--;
        services[index] = service;
        return temp;
    }

    /*метод удаляющий услугу по номеру в массиве (принимает номер в массиве в качестве параметра).
    Возвращает удаленную из массива ссылку на экземпляр класса Service.*/
    public Service removeServiceAt(int index) {
        if (index < 0 || index > services.length) return null;
        Service temp = services[index];
        services[index] = null;
        size++;
        return temp;
    }

    /*метод удаляющий услугу с заданным названием (принимает строку – название услуги в качестве параметра).
    Возвращает удаленную из массива ссылку на экземпляр класса Service.*/
    public Service removeServiceByTitle(String serviceName) {
        Service temp = null;
        for (int i = 0; i < services.length; i++) {
            if (serviceName.equals(services[i].getName())) {
                temp = services[i];
                services[i] = null;
                size++;
                break;
            }
        }
        return temp;
    }

    /*метод возвращающий общее число услуг.*/
    public int getServicesCount() {
        return services.length - size;
    }

    /*метод возвращающий массив услуг (значений null в массиве быть не должно,
    его размер должен быть равен числу элементов в исходном массиве).*/
    public Service[] getAllServices() {
        return Arrays.stream(services).filter(Objects::nonNull).toArray(Service[]::new);
    }

    /*метод возвращающий массив услуг, отсортированный по возрастанию их стоимости
    (значений null в массиве быть не должно, его размер должен быть равен числу элементов в массиве).*/
    public Service[] getAllServicesSortedByPrice() {
        return Arrays.stream(services).filter(Objects::nonNull).sorted().toArray(Service[]::new);
    }

    /*метод возвращающий стоимость тарифа (суммарная стоимость всех услуг + сбор за обслуживание, равный 50)*/
    public double getTotalCost() {
        return Arrays.stream(services).filter(Objects::nonNull).mapToDouble(Service::getCost).sum() + 50;
    }

}
