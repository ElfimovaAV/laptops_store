package laptopshop;

import laptopshop.classes.Laptop;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Laptop> laptops = getLaptopList();
        HashMap<Integer, String> sortingValues = getSortingMap();
        HashMap<String, ArrayList<String>> allStr = getStringChoices(sortingValues, laptops);
        Scanner scanner = new Scanner(System.in);

        int firstChoice = filterFirst(sortingValues, scanner);

        int secondChoice = filterSecond(sortingValues, laptops, allStr, scanner, firstChoice);

        filterFinal(firstChoice, secondChoice, allStr, laptops);

        scanner.close();
    }

    // Метод для проведения финального этапа фильтрации и вывод результатов в консоль
    public static void filterFinal(int first, int second, HashMap<String, ArrayList<String>> dictionaryMap, ArrayList<Laptop> laptopArrayList) {
        ArrayList<Laptop> matching = new ArrayList<>();

        switch (first) {
            case 1:
                for (Laptop el: laptopArrayList)
                    if (el.RAM >= second)
                        matching.add(el);
                break;

            case 2:
                for (Laptop el: laptopArrayList)
                    if (el.SSD >= second)
                        matching.add(el);
                break;

            case 3:
                if (dictionaryMap.get("Операционная система").size() <= second - 1 || second < 1) {
                    System.out.println("Такого выбора нет!");
                    break;
                }

                for (Laptop el: laptopArrayList)
                    if (dictionaryMap.get("Операционная система").get(second - 1).equals(el.OS))
                        matching.add(el);
                break;

            case 4:
                if (dictionaryMap.get("Цвет").size() <= second - 1 || second < 1) {
                    System.out.println("Такого выбора нет!");
                    break;
                }

                for (Laptop el: laptopArrayList)
                    if (dictionaryMap.get("Цвет").get(second - 1).equals(el.color))
                        matching.add(el);
                break;

            default:
                break;
        }

        if (matching.size() < 1) System.out.println("Нет подходящих вариантов(");
        else {
            System.out.println("\n---- Все подходящие варианты ----\n");
            for (Laptop el: matching) el.getInfo();
            System.out.println("\n---------------------------------\n");
        }
    }

    // Метод для проведения второго этапа фильтрации
    public static int filterSecond(HashMap<Integer, String> mapOfParamerets, ArrayList<Laptop> laptopArrayList, HashMap<String, ArrayList<String>> dictionaryMap, Scanner scanner, int firstChoice) {
        int choice = -1;

        if (firstChoice > 0 && firstChoice < 3) {
            System.out.println("Напишите минимально подходящее кол-во памяти (" + mapOfParamerets.get(firstChoice) + ").");
            System.out.print("Кол-во памяти (ГБ): ");

            choice = scanner.nextInt();
            scanner.nextLine();
        }

        else if (firstChoice > 2 && firstChoice < 5) {
            ArrayList<String> strChoices = dictionaryMap.get(mapOfParamerets.get(firstChoice));
            System.out.println("Выберите один из подходящих вариантов (" + mapOfParamerets.get(firstChoice) + "):");

            for (int i = 0; i < strChoices.size(); i++) {
                System.out.println((i + 1) + ". " + strChoices.get(i));
            }

            System.out.print("\nВаш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        else {
            System.out.println("Такого выбора нет!");
        }

        return choice;
    }

    // Метод для создания словаря с уникальными значениями ОС и цвета
    public static HashMap<String, ArrayList<String>> getStringChoices(HashMap<Integer, String> mapOfParamerets, ArrayList<Laptop> laptopArrayList) {
        HashMap<String, ArrayList<String>> dictionaryMap = new HashMap<>();

        HashSet<String> oses = new HashSet<>();
        HashSet<String> colors = new HashSet<>();
        ArrayList<String> osList = new ArrayList<>();
        ArrayList<String> colorList = new ArrayList<>();

        for (Laptop el: laptopArrayList) {
            oses.add(el.OS);
            colors.add(el.color);
        }

        osList.addAll(oses);
        colorList.addAll(colors);

        dictionaryMap.put(mapOfParamerets.get(3), osList);
        dictionaryMap.put(mapOfParamerets.get(4), colorList);

        return dictionaryMap;
    }

    // Метод для проведения первого этапа фильтрации
    public static int filterFirst(HashMap<Integer, String> mapOfParamerets, Scanner scanner) {
        System.out.println("Choose number with needed parameter: ");

        for (Map.Entry<Integer, String> el: mapOfParamerets.entrySet()) System.out.println(el.getKey() + ". " + el.getValue());

        System.out.print("\nYou have choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    // Метод для создания словаря с критериями фильтрации
    public static HashMap<Integer, String> getSortingMap() {
        HashMap<Integer, String> mapOfParamerets = new HashMap<>();
        mapOfParamerets.put(1, "RAM");
        mapOfParamerets.put(2, "SSD");
        mapOfParamerets.put(3, "OS");
        mapOfParamerets.put(4, "color");

        return mapOfParamerets;
    }

    public static ArrayList<Laptop> getLaptopList() {
        ArrayList<Laptop> laptopArrayList = new ArrayList<>();
        Laptop laptop = new Laptop("MacBook Air", "M2 Entry", "Apple macOS 12 Monterey", 8, 256, "Silver");
        Laptop laptop1 = new Laptop("MacBook Air", "M2 Entry", "Apple macOS 12 Monterey", 16, 1024, "Black");
        Laptop laptop2 = new Laptop("MacBook Pro", "13", "Apple macOS 12 Monterey", 8, 256, "White");
        Laptop laptop3 = new Laptop("MacBook Pro", "13", "Apple macOS 12 Monterey", 16, 1024, "Gray");
        Laptop laptop4 = new Laptop("Asus Zenbook", "S 13 OLED", "Microsoft Windows 11 Home", 16, 1024, "Gray");
        Laptop laptop5 = new Laptop("Asus Zenbook", "S 13 OLED", "Microsoft Windows 11 Home", 16, 512, "Blue");
        Laptop laptop6 = new Laptop("Samsung Galaxy Book2", "Pro 13", "Microsoft Windows 11 Home", 8, 256, "Gray");
        Laptop laptop7 = new Laptop("Samsung Galaxy Book2", "Pro 13", "Microsoft Windows 11 Home", 8, 512, "Silver");
        Laptop laptop8 = new Laptop("Huawei MateBook", "13s", "Microsoft Windows 10 Home 64 Bit", 16, 512, "Blue");
        Laptop laptop9 = new Laptop("Huawei MateBook", "13s", "Microsoft Windows 10 Home 64 Bit", 16, 1024, "Black");
        Laptop laptop10 = new Laptop("Dell XPS", "13 9310 OLED", "Microsoft Windows 10 Home 64 Bit", 16, 512, "White");
        Laptop laptop11 = new Laptop("Dell XPS", "13 9310 OLED", "Microsoft Windows 10 Home 64 Bit", 16, 1024, "Silver");

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

    }
}
