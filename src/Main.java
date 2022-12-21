import hashmap.CountMeMountains;
import hashmap.MapData;
import hashmap.MapPoint;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        MapData.printMap();
        System.out.println("Plains are green, mountains are black with double ^^");


        List<Set<MapPoint>> result = CountMeMountains.countMountains();

        System.out.println("Number of mountains: " + result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println("mountain " + (i + 1) + " is " + result.get(i).size() + " ^^ big");
        }
    }

}
