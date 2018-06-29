
import java.util.Scanner;

public class RotatePicture {

    private static void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
    }
    public static void rotateByNinetyToLeft(int[][] m) {
        int e = m.length - 1;
        int c = e / 2;
        int b = e % 2;
        for (int r = c; r >= 0; r--) {
            for (int d = c - r; d < c + r + b; d++) {
                int t   = m[c - r][d];
                m[c - r][d] = m[d][e - c + r];
                m[d][e - c + r] = m[e - c + r][e - d];
                m[e - c + r][e - d] = m[e - d][c - r];
                m[e - d][c - r] = t;
            }
        }
    }
    public static void rotateByNinetyToRight(int[][] m) {
        transpose(m);
        for (int  j = 0; j < m[0].length/2; j++) {
            for (int i = 0; i < m.length; i++) {
                int x = m[i][j];
                m[i][j] = m[i][m[0].length -1 -j];
                m[i][m[0].length -1 -j] = x;
            }
        }
    }
    public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol){
        System.out.println("Your Matrix is : ");
        for (int i = 0; i < matrixRow; i++)
        {
            for (int j = 0; j < matrixCol; j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System. in);
        System.out.println("Enter the Flag value");
        int flag = scan.nextInt();
        System.out.println("Enter The Number Of Matrix Rows");
        int matrixRow = scan.nextInt();
        System.out.println("Enter The Number Of Matrix Columns");
        int matrixCol = scan.nextInt();
        System.out.println("Enter Matrix Data");
        int[][] matrix = new int[matrixRow][matrixCol];
        for (int i = 0; i < matrixRow; i++)
        {
            for (int j = 0; j < matrixCol; j++)
            {
                matrix[i][j] = scan.nextInt();
            }
        }

        rotatePictureMethod(matrix,flag);
        printMatrix(matrix,matrixRow,matrixCol);
    }
    private static void rotatePictureMethod(int[][] matrix, int flag) {
        if(flag == 0){
            rotateByNinetyToLeft(matrix);
        }else{
            rotateByNinetyToRight(matrix);
        }
    }
}
