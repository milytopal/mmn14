public class Test {
    public static void main(String[] args) {
        boolean[][] mat = new boolean[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {

                mat[i][j] = false;
            }
        }
        mat[1][1] = true;
        mat[1][2] = true;
        mat[2][3] = true;
        //mat[6][5] = true;
        System.out.println("\n on entry");
        System.out.println("\nsize of stain is: " + Ex14.size(mat,1,2) + "\n");
         for (int m = 0; m < 4; m++) {
             for (int n = 0; n < 5; n++) {

                 System.out.print(" , " +mat[m][n] + " , ");
             }
         }
        System.out.println();
        System.out.println();
        boolean[][] Mat = new boolean[4][5];
         System.out.println(Mat[0][0]);
    }
}
