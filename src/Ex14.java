import com.sun.security.jgss.GSSUtil;

/**
 *
 */

public class Ex14 {
    /**
     * this method checks the size of a stain in a given set of coordinates by calling to a recursive method
     * @param mat - a given boolean 2D array
     * @param x - coordinate x
     * @param y - coordinate y
     * @return - number of cells assembling the stain
     */
    public static int size(boolean[][] mat, int x, int y)
    {
        int numOfRows = mat.length;
        int numOfColumns = mat[x].length;
        // check if the coordinates are valid (in bounds of the matrix) and if the given cell is part of a stain (equals true), if not return
        if (!isCoordinateValid(x, y, numOfRows, numOfColumns)||(mat[x][y] == false))
            return 0;

        //default initialization of int array in java is zero
        // this matrix represents the given boolean matrix in size, and will be used to track if we already checked a cell
        int[][] trackingMat = new int[numOfRows][numOfColumns];

        return size(mat, x, y, trackingMat, numOfRows, numOfColumns);
    }

    /**
     * a recursive method witch checks if the cell (given by the coordinates x and y) is part of a stain, if so sums itself up with the returned numbers from
     * the neighbors
     * the recursive calls check the neighbor cells
     * @param mat - the given matrix
     * @param x - the given x coordinate
     * @param y - the given y coordinate
     * @param trackingMat - the tracking matrix to check if we already checked this cell
     * @param numOfRows - number of rows in the given boolean matrix
     * @param numOfColumns - number of columns in the given boolean matrix
     * @return - if the cell was checked or the cell is not part of a stain or if the coordinates are out of the matrix bounds returns zero, else returns
     * the number of cells assembling the stain
     *
     */
    public static int size(boolean[][] mat, int x, int y,int[][] trackingMat, int numOfRows,int numOfColumns)
    {
        if(!isCoordinateValid(x,y,numOfRows,numOfColumns) || (mat[x][y] == false))      // base case
            return 0;
        // if we already checked this cell return 0
        if(trackingMat[x][y] == 1)
            return 0;
        // if cell is not false mark the spot in the tracking array
        trackingMat[x][y] = 1;
        //checking around
        int sumOfReturnedNeighbors = 1; //1 is for self
        sumOfReturnedNeighbors += size(mat,x-1,y-1,trackingMat, numOfRows, numOfColumns);  // check the neighbor on the upper left corner
        sumOfReturnedNeighbors += size(mat,x-1, y ,trackingMat, numOfRows, numOfColumns);  // check the neighbor on the left
        sumOfReturnedNeighbors += size(mat,x-1,y+1, trackingMat , numOfRows, numOfColumns); // check the neighbor on the bottom left corner
        sumOfReturnedNeighbors += size(mat, x ,y-1, trackingMat , numOfRows, numOfColumns); // check the neighbor above
        sumOfReturnedNeighbors += size(mat, x ,y+1, trackingMat , numOfRows, numOfColumns); // check the neighbor bellow
        sumOfReturnedNeighbors += size(mat,x+1,y-1,trackingMat, numOfRows, numOfColumns);   // check the neighbor on the upper right corner
        sumOfReturnedNeighbors += size(mat,x+1, y , trackingMat , numOfRows, numOfColumns); // check the neighbor on the right
        sumOfReturnedNeighbors += size(mat,x+1,y+1 , trackingMat , numOfRows, numOfColumns);    // check the neighbor on the bottom right corner

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
     * the method checks by calling a recursive method, if two given arrays are permutation of each other
     * @param a - array of integers a
     * @param b - array of integers b
     * @return - false if the arrays are not same in length, returned answer from the call to the recursive function - true if the two arrays are
     * permutation of each other, false if not.
     */
    public static boolean isPermutation(int[] a, int[] b)
    {
        if(a.length != b.length)
            return false;
        boolean numFind = isPermutation(a, b,0); // call to the recursive method witch checks the case
        return numFind;
    }

    /**
     * a recursive method witch checks if two given arrays are permutation of each other, in every call the method checks if the given index is
     * out of array's bounds, if not, calls a recursive private method with the array to search in, the number to find and index 0
     * @param arrA - the given array a from the father method
     * @param arrB - the given array b from the father method
     * @param i - the index of the number in array a to search in array b
     * @return -
     */

    public static boolean isPermutation(int[] arrA, int[] arrB, int i)
    {
        if(i==arrB.length)      // base case
            return true;
        // check if the number in the given index in a, exists in array b somewhere
        boolean isExisting = isExistingNumber(arrB, arrA[i], 0);
        if(isExisting)
            return isPermutation(arrA,arrB,i+1);        // recursive call if the number exists in array b
        // if the number does not exist array a and array b are not permutations therefore return false
        return false;
    }

    /**
     * a private recursive method witch checks if a given number equals to the number in the given index of the array
     * if equals, returns true, else calls to itself with the next index
     * if the index is out of array bounds it means all numbers where checked and returns false
     * @param arrB - the array the number is compared to
     * @param num - the number given from the calling method (the father) given from array a
     * @param i - the index of the number to compare to
     * @return - true if the numbers equal, false if the index is out of bounds, recursive call if the numbers are not equal
     */
    private static boolean isExistingNumber(int[] arrB, int num, int i)
    {
        if( i==arrB.length)     // base case
            return false;
        // if the number in the array b equals to the number sent from array a return true
        if(arrB[i]==num)
            return true;
        // if the numbers are not equal call to self with the next index
        return isExistingNumber(arrB,num,i+1);      // recursive call
    }


}
