package hashmap;

public class MapPoint {
    public final int column_X;
    public final int row_Y;

    public MapPoint(int row_Y, int column_X){
        this.row_Y = row_Y;
        this.column_X = column_X;
    }

    public MapPoint upper(){ //0,0 is top left ;)
        int y = row_Y - 1;
        int x = column_X;

        if ( y > -1 ) {                 // shuld not exceed map
            return new MapPoint(y, x);
        } else {
            return this;
        }
    }

    public MapPoint lower(){
        int y = row_Y + 1;
        int x = column_X;

        if (y < MapData.numberOfRows) {
            return new MapPoint(y, x);
        } else {
            return this;
        }
    }

    public MapPoint left(){
        int y = row_Y;
        int x = column_X - 1;

        if (x > -1) {
            return new MapPoint(y, x);
        } else {
            return this;
        }
    }

    public MapPoint right(){
        int y = row_Y;
        int x = column_X + 1;

        if (x < MapData.numberOfColumns) {
            return new MapPoint(y, x);
        } else {
            return this;
        }
    }


    public MapPoint upperCont(){
        int y = row_Y - 1;
        if( y < 0 ) y = MapData.numberOfRows - 1;
        int x = column_X;

        return new MapPoint(y,x);
    }

    public MapPoint lowerCont(){
        int y = row_Y + 1;
        if (y >= MapData.numberOfRows) y = 0;

        int x = column_X;

        return new MapPoint(y,x);
    }

    public MapPoint leftCont(){
        int y = row_Y;
        int x = column_X - 1;
        if( x < 0 ) x = MapData.numberOfColumns - 1;

        return new MapPoint(y,x);
    }

    public MapPoint rightCont(){
        int y = row_Y;
        int x = column_X + 1;
        if (x >= MapData.numberOfColumns) x = 0;

        return new MapPoint(y,x);
    }


}
