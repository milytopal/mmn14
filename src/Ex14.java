import com.sun.security.jgss.GSSUtil;

/**
 *
 */

public class Ex14 {
    public static int size(boolean[][] mat, int x, int y)
    {
       int numOfRows = mat.length;
       int numOfColumns = mat[x].length;

       if (!isCoordinateValid(x, y, numOfRows, numOfColumns)||(mat[x][y] == false))
           return 0;

       //default initialization of int array in java is zero
       int[][] trackingMat = new int[numOfRows][numOfColumns];

       return size(mat, x, y, trackingMat, numOfRows, numOfColumns);
    }

    public static int size(boolean[][] mat, int x, int y,int[][] trackingMat, int numOfRows,int numOfColumns)
   {
       if(!isCoordinateValid(x,y,numOfRows,numOfColumns) || (mat[x][y] == false))
           return 0;
       // if we already checked this cell return 0
       if(trackingMat[x][y] == 1)
           return 0;
       // if cell is not false mark the spot in the tracking array
       trackingMat[x][y] = 1;
       //checking around
       int sumOfReturnedNeighbors = 1; //1 is for self
       sumOfReturnedNeighbors += size(mat,x-1,y-1,trackingMat, numOfRows, numOfColumns);
       sumOfReturnedNeighbors += size(mat,x-1, y ,trackingMat, numOfRows, numOfColumns);
       sumOfReturnedNeighbors += size(mat,x-1,y+1, trackingMat , numOfRows, numOfColumns);
       sumOfReturnedNeighbors += size(mat, x ,y-1, trackingMat , numOfRows, numOfColumns);
       sumOfReturnedNeighbors += size(mat, x ,y+1, trackingMat , numOfRows, numOfColumns);
       sumOfReturnedNeighbors += size(mat,x+1,y-1,trackingMat, numOfRows, numOfColumns);
       sumOfReturnedNeighbors += size(mat,x+1, y , trackingMat , numOfRows, numOfColumns);
       sumOfReturnedNeighbors += size(mat,x+1,y+1 , trackingMat , numOfRows, numOfColumns);

       return sumOfReturnedNeighbors;
   }
   private static boolean isCoordinateValid(int x, int y, int numOfRows, int numOfColumns)
   {
       if((x<0 || x>numOfRows) || (y<0 || y> numOfColumns))
           return false;
       return true;
   }

}
