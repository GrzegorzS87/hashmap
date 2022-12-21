package hashmap;

public class MapData {
    // Given 2d map with fields(0) and mountains(1) count mountains.
    // Connect points in straight lines,
    // in lines and also by corners,
    // on flat map with and without edges (continues map)

    public static final int numberOfRows = 10;
    public static final int numberOfColumns = 10;

    private static final int[][] map = {
            {1,0,0,0,0,1,1,0,0,1},
            {0,0,1,1,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,1},
            {0,0,0,0,1,1,0,0,0,1},
            {1,0,0,0,1,1,0,0,0,0},
            {1,0,0,0,0,0,0,0,1,1},
            {1,0,0,1,1,1,0,0,1,1},
            {0,0,0,0,0,0,1,0,0,0},
            {0,1,1,0,1,1,1,0,0,0},
            {0,1,1,0,0,1,1,0,0,1}
    };

    public boolean isMountain(MapPoint point){
        return map[point.row_Y][point.column_X] == 1;
    }

    //drawing this for 'convenience'
    public static void printMap(){

        String line = ("  *");
        for(int i=0; i<numberOfColumns; i++) {
            line += "-" + i;
        }
        line += "*";
        System.out.println(line);

        for(int row=0; row<numberOfColumns;row++)
        {
            line = " " + row + "|";
            for(int column=0; column<numberOfRows; column++){
                if(map[row][column] == 0){
                    line += (Color.GREEN_BACKGROUND + "  ");
                }
                else{
                    line += (Color.BLACK_BACKGROUND + Color.YELLOW + "^^");
                }
            }
            line += (Color.RESET+ "|");
            System.out.println(line);
        }

        line = "  *";
        for(int i=0; i<numberOfColumns; i++) {
            line += "--";
        }
        line += "*";
        System.out.println(line);
    }

}
