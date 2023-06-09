package laptopshop.classes;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Methods {
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
                .collect(Collectors.toSet());
    }

}
