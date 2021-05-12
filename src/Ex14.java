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

    /**
     * this method checks if the given coordinates are in the range of the matrix
     * if the coordinates are in the range returns true, if out of bounds returns false.
     * @param coordinateX - coordinate x as received by user
     * @param coordinateY - coordinate y as received by user
     * @param numOfRows - the number of rows
     * @param numOfColumns - the number of columns
     * @return - true is in bound, false if out of bound
     */
    private static boolean isCoordinateValid(int coordinateX, int coordinateY, int numOfRows, int numOfColumns)
    {
        if((coordinateX < 0 || coordinateX >= numOfRows) || (coordinateY < 0 || coordinateY >= numOfColumns))
            return false;
        return true;
    }
// ******************************* Question 2 ***************************** //

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isPermutation(int[] a, int[] b)
    {
        if(a.length != b.length)
            return false;
        boolean numFind = isPermutation(b, a,a[0], 0,0);
        return numFind;

    }


    public static boolean isPermutation(int[] arrA, int[] arrB, int num, int i, int j)
    {
        System.out.println(" entered inner func  ");
        if(i==arrB.length-1 || j==arrA.length-1) {

            //********************* DEBUG ********************//
            if((i==arrB.length-1 || j==arrA.length-1)==false)
                System.out.println(" exiting inner func    i==arrB.length || j==arrA.length ---> returned false ");

            return false;
        }
        boolean returnedFromB=false;
        if(i<arrB.length && j<arrA.length)
            returnedFromB = isPermutation(arrA, arrB, arrA[j], i+1, j);

        if(arrB[i]==num && returnedFromB) {
            System.out.println(" exiting inner func " +arrB[i] +" == "+num +"  returned true");
            return true;
        }
        boolean returnedFromA = returnedFromB;


        if(i<arrB.length && j<arrA.length)
            returnedFromA = isPermutation(arrA, arrB, arrA[j+1], i, j+1);


        if(arrB[i]!=num)
            return false;

        System.out.println(" exiting inner func:  returnedFromB = " +returnedFromB +" &&  returnedFromA =  "+returnedFromA );

        return returnedFromB && returnedFromA;
    }



}
