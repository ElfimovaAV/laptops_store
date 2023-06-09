package laptopshop;

import laptopshop.classes.Laptop;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static laptopshop.classes.Methods.*;

public class Main {
    public static void main(String[] args) {
        String selectedType;
        String parameterNumber;
        Scanner scanner = new Scanner(System.in);

        Laptop laptop = new Laptop("MacBook Air", "M2 Entry", "Apple macOS 12 Monterey", "8", "256", "Silver");
        Laptop laptop1 = new Laptop("MacBook Air", "M2 Entry","Apple macOS 12 Monterey", "16", "1024", "Black");
        Laptop laptop2 = new Laptop("MacBook Pro", "13", "Apple macOS 12 Monterey", "8", "256", "White");
        Laptop laptop3 = new Laptop("MacBook Pro", "13", "Apple macOS 12 Monterey", "16", "1024", "Gray");
        Laptop laptop4 = new Laptop("Asus Zenbook", "S 13 OLED", "Microsoft Windows 11 Home", "16", "1024", "Gray");
        Laptop laptop5 = new Laptop("Asus Zenbook", "S 13 OLED", "Microsoft Windows 11 Home", "16", "512", "Blue");
        Laptop laptop6 = new Laptop("Samsung Galaxy Book2", "Pro 13", "Microsoft Windows 11 Home", "8", "256", "Gray");
        Laptop laptop7 = new Laptop("Samsung Galaxy Book2", "Pro 13", "Microsoft Windows 11 Home", "8", "512", "Silver");
        Laptop laptop8 = new Laptop("Huawei MateBook", "13s", "Microsoft Windows 10 Home 64 Bit", "16", "512", "Blue");
        Laptop laptop9 = new Laptop("Huawei MateBook", "13s", "Microsoft Windows 10 Home 64 Bit", "16", "1024", "Black");
        Laptop laptop10 = new Laptop("Dell XPS", "13 9310 OLED", "Microsoft Windows 10 Home 64 Bit", "16", "512", "White");
        Laptop laptop11 = new Laptop("Dell XPS", "13 9310 OLED", "Microsoft Windows 10 Home 64 Bit", "16", "1024", "Silver");

        Map<Integer, Laptop> laptopsMap = new HashMap<Integer, Laptop>();

        laptopsMap.put(1, laptop);
        laptopsMap.put(2, laptop1);
        laptopsMap.put(3, laptop2);
        laptopsMap.put(4, laptop3);
        laptopsMap.put(5, laptop4);
        laptopsMap.put(6, laptop5);
        laptopsMap.put(7, laptop6);
        laptopsMap.put(8, laptop7);
        laptopsMap.put(9, laptop8);
        laptopsMap.put(10, laptop9);
        laptopsMap.put(11, laptop10);
        laptopsMap.put(12, laptop11);

        while (true) {
            System.out.print("\nYou can choose a parameter: 1. Brand; 2. Model; 3. OS; 4. RAM; 5. SSD; 6. Color");
            System.out.print("\nPrint number of the parameter from 1 to 6 or input 0 for exit: ");

            parameterNumber = scanner.nextLine();
            System.out.println(parameterNumber);

            if (parameterNumber.equals("0")) {
                System.out.println("Come again!");
                break;
            }

            switch (parameterNumber) {
                case "1":
                    getBrand(laptopsMap).forEach(System.out::println);
                    System.out.println("\nChoose and print brand: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterBrands(laptopsMap, selectedType)));
                    break;

                case "2":
                    getModels(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print model: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterModels(laptopsMap, selectedType)));
                    break;

                case "3":
                    getOS(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print OS: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterOS(laptopsMap, selectedType)));
                case "4":
                    getRAM(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print RAM: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterRAM(laptopsMap, selectedType)));
                    break;
                case "5":
                    getVideoModels(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print SSD: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterSSD(laptopsMap, selectedType)));
                    break;
                case "6":
                    getColors(laptopsMap).forEach(System.out::println);
                    System.out.println("\nChoose and print color: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterByColor(laptopsMap, selectedType)));
                    break;
                default:
                    break;
            }
        }
        scanner.close();

    }
}
