package laptopshop;

import laptopshop.classes.Laptop;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String selectedType;

        Scanner scanner = new Scanner(System.in);

    }

    public static ArrayList<Laptop> getLaptopList() {
        ArrayList<Laptop> laptopArrayList = new ArrayList<>();
        Laptop laptop = new Laptop("MacBook Air", "M2 Entry", "Apple macOS 12 Monterey", "8", "256", "Silver");
        Laptop laptop1 = new Laptop("MacBook Air", "M2 Entry", "Apple macOS 12 Monterey", "16", "1024", "Black");
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

        laptopArrayList.add(laptop);
        laptopArrayList.add(laptop1);
        laptopArrayList.add(laptop2);
        laptopArrayList.add(laptop3);
        laptopArrayList.add(laptop4);
        laptopArrayList.add(laptop5);
        laptopArrayList.add(laptop6);
        laptopArrayList.add(laptop7);
        laptopArrayList.add(laptop8);
        laptopArrayList.add(laptop9);
        laptopArrayList.add(laptop10);
        laptopArrayList.add(laptop11);

        return laptopArrayList;


       /* while (true) {
        System.out.print("\nEnter the number of one or more parameters separated by a space:" +
                "\n1. Brand; 2. Model; 3. OS; 4. RAM; 5. SSD; 6. Color");
        System.out.print("\nPrint number of the parameter from 1 to 6 or input 0 for exit: ");

        List<String> parameters = Arrays.asList(scanner.nextLine().split(" "));
        System.out.println(Arrays.toString(parameters.toArray()));

            for(int i=0;i<parameters.size();i++){

                if (parameters.get(i).equals("0")) {
                    System.out.println("Come again!");
                    break;
                    }

                switch (parameters.get(i)) {
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

    public static Collection<Laptop> filterBrands(Map<Integer, Laptop> laptopsMap, String brand) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getBrand().equals(brand))
                .sorted(Comparator.comparing(Laptop::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptop> filterModels(Map<Integer, Laptop> laptopsMap, String Model) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getModel().equals(Model))
                .sorted(Comparator.comparing(Laptop::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptop> filterOS(Map<Integer, Laptop> laptopsMap, String OS) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getOS().equals(OS))
                .sorted(Comparator.comparing(Laptop::getBrand))
                .collect(Collectors.toList());
    }


    public static Collection<Laptop> filterRAM(Map<Integer, Laptop> laptopsMap, String RAM) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getRAM().equals(RAM))
                .sorted(Comparator.comparing(Laptop::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptop> filterSSD(Map<Integer, Laptop> laptopsMap, String SSD) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getSSD().equals(SSD))
                .sorted(Comparator.comparing(Laptop::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptop> filterByColor(Map<Integer, Laptop> laptopsMap, String color) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getColor().equals(color))
                .sorted(Comparator.comparing(Laptop::getBrand))
                .collect(Collectors.toList());
    }

    public static void outLaptop (Collection<Laptop> laptopsCollection) {
        laptopsCollection.stream()
                .forEach(laptop -> System.out.printf("%s —— \t %s | %s | %s | %s | %s \n",
                        laptop.getBrand(), laptop.getModel(), laptop.getOS(),
                        laptop.getRAM(), laptop.getSSD(),
                        laptop.getColor()));
    }

    public static Set<String> getColors(Map<Integer, Laptop> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getColor())
                .collect(Collectors.toSet());
    }

    public static Set<String> getBrand(Map<Integer, Laptop> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getBrand())
                .collect(Collectors.toSet());
    }

    public static Set<String> getModels(Map<Integer, Laptop> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getModel())
                .collect(Collectors.toSet());
    }

    public static Set<String> getOS(Map<Integer, Laptop> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getOS())
                .collect(Collectors.toSet());
    }


    public static Set<String> getRAM(Map<Integer, Laptop> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getRAM())
                .collect(Collectors.toSet());
    }

    public static Set<String> getVideoModels(Map<Integer, Laptop> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getSSD())
                .collect(Collectors.toSet());*/
    }

}
