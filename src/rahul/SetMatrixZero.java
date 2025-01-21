package rahul;

public class SetMatrixZero {
    private static void setZeroes(int[][] matrix) {
        int fir = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j==0) fir=0;
                    else matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                for(int j=0;j<matrix.length;j++)
                    matrix[j][i] =0;
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j=0;j<matrix[0].length;j++)
                    matrix[i][j] =0;
            }
        }
        if(matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        if(fir==0){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;


        }

    }

    private static void print(int[][]arr){
        for(int[] i:arr){
            for (int j:i)
                System.out.print(j+ " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        print(matrix);
        setZeroes(matrix);
        print(matrix);
    }
}
