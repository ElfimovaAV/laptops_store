package laptopshop.classes;

/*Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы.
Реализовать в Java.
Создать множество ноутбуков.

Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

“Введите цифру, соответствующую необходимому критерию:
1 - бренд
2 - цвет

Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации
можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

СПОЙЛЕР:

1) создаете класс ноутбук (equals, hashCode)
2) создаете сет ноутбукоа
3) создаете и заполняете Map<Integer, Laptop>
4) запрашиваете через сканнер у пользователя критерий фильтрации
5) циклом проходите по Map.Entry<Integer, Laptop> entry: entries
6) В результирующий Set<Laptop> складываете ноутбуки entry.getValue() у которых
   равны критерию пользователя*/


import java.util.Objects;

public class Laptop {
    private String brand;
    private String model;
    public String OS;
    public int RAM;
    public int SSD;
    public String color;

    // Конструктор класса
    public Laptop(String brand, String model, String OS,
                   int RAM, int SSD, String color) {

        this.brand = brand;
        this.model = model;
        this.OS = OS;
        this.RAM = RAM;
        this.SSD = SSD;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }


    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getSSD() {
        return SSD;
    }

    public void setSSD(int SSD) {
        this.SSD = SSD;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void getInfo() {
        System.out.println(this.model + ":\n\tЦвет: " + this.color + "\n\tОЗУ: " + this.RAM + "\n\tОбъем ЖД: " + this.SSD + "\n\tОперационная система: " + this.OS + "\n");
    }

    @Override
    public String toString() {
        return "Laptop \n" +
                "brand = " + brand +
                ", model = " + model +
                ", OS = " + OS +
                ", RAM = " + RAM +
                ", SSD = " + SSD +
                ", color = " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Laptop))
            return false;
        Laptop notebooks = (Laptop) o;
        return Objects.equals(brand, notebooks.brand)
                && Objects.equals(model, notebooks.model)
                && Objects.equals(OS, notebooks.OS)
                && Objects.equals(RAM, notebooks.RAM)
                && Objects.equals(SSD, notebooks.SSD)
                && Objects.equals(color, notebooks.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, OS, RAM, SSD, color);
    }

}