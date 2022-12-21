package hashmap;

import java.util.*;

public class CountMeMountains {
    private static int[][] done = new int[MapData.numberOfRows][MapData.numberOfColumns]; // java fills it with 0
    public static MapData sourceMap = new MapData();


    public static List<Set<MapPoint>> countMountains() {

        List<Set<MapPoint>> result = new ArrayList<>();
        MapPoint firstPoint;

        for (int row = 0; row < MapData.numberOfRows; row++) {
            for (int column = 0; column < MapData.numberOfColumns; column++) {
                firstPoint = new MapPoint(row, column);

                if (done[row][column] == 0 && sourceMap.isMountain(firstPoint)) {
                    result.add(findMountain(firstPoint));
                } else {
                    done[row][column] = 1;
                }
            }
        }

        return result;
    }

    private static Set<MapPoint> findMountain(MapPoint point) {

        Set<MapPoint> mountain = new HashSet<>();

        mountain.add(point);
        done[point.row_Y][point.column_X] = 1;

        //pick one way of finding surrounding points

        //Set<MapPoint> m = surroundingPointsStraightLine(point);
        //Set<MapPoint> m = surroundingPointsStraightAndCorners(point);
        //Set<MapPoint> m = surroundingContinuesMapStraight(point);

        Set<MapPoint> m = surroundingContinuesStraightAndCorners(point);


        for (MapPoint nehbour : m) {
            if (done[nehbour.row_Y][nehbour.column_X] == 0 && sourceMap.isMountain(nehbour)) {
                mountain.addAll(findMountain(nehbour));
            }
        }

        return mountain;
    }

    private static Set<MapPoint> surroundingPointsStraightLine(MapPoint point) {
        Set<MapPoint> surrounding = new HashSet<>();
        surrounding.add(point.upper());
        surrounding.add(point.lower());
        surrounding.add(point.left());
        surrounding.add(point.right());

        return surrounding;
    }

    private static Set<MapPoint> surroundingPointsStraightAndCorners(MapPoint point) {
        Set<MapPoint> surrounding = new HashSet<>();
        surrounding.add(point.upper());
        surrounding.add(point.lower());
        surrounding.add(point.left());
        surrounding.add(point.right());
        surrounding.add(point.upper().right());
        surrounding.add(point.upper().left());
        surrounding.add(point.lower().right());
        surrounding.add(point.lower().left());

        return surrounding;
    }

    private static Set<MapPoint> surroundingContinuesMapStraight(MapPoint point) {
        Set<MapPoint> surrounding = new HashSet<>();
        surrounding.add(point.upperCont());
        surrounding.add(point.lowerCont());
        surrounding.add(point.leftCont());
        surrounding.add(point.rightCont());

        return surrounding;
    }

    private static Set<MapPoint> surroundingContinuesStraightAndCorners(MapPoint point) {
        Set<MapPoint> surrounding = new HashSet<>();
        surrounding.add(point.upperCont());
        surrounding.add(point.lowerCont());
        surrounding.add(point.leftCont());
        surrounding.add(point.rightCont());
        surrounding.add(point.upperCont().rightCont());
        surrounding.add(point.upperCont().leftCont());
        surrounding.add(point.lowerCont().rightCont());
        surrounding.add(point.lowerCont().leftCont());

        return surrounding;
    }

}


    