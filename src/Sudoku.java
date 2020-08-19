import java.util.Arrays;
public class Sudoku {

    public static int[][] grid ={
                    /*{7, 2, 3, 0, 0, 0, 1, 5, 9},
                    {6, 0, 0, 3, 0, 2, 0, 0, 8},
                    {8, 0, 0, 0, 1, 0, 0, 0, 2},
                    {0, 7, 0, 6, 5, 4, 0, 2, 0},
                    {0, 0, 4, 2, 0, 7, 3, 0, 0},
                    {0, 5, 0, 9, 3, 1, 0, 4, 0},
                    {5, 0, 0, 0, 7, 0, 0, 0, 3},
                    {4, 0, 0, 1, 0, 3, 0, 0, 6},
                    {9, 3, 2, 0, 0, 0, 7, 1, 4}*/

                    {1,0,0,2,3,4,0,0,12,0,6,0,0,0,7,0},
                    {0,0,8,0,0,0,7,0,0,3,0,0,9,10,6,11},
                    {0,12,0,0,10,0,0,1,0,13,0,11,0,0,14,0},
                    {3,0,0,15,2,0,0,14,0,0,0,9,0,0,12,0},
                    {13,0,0,0,8,0,0,10,0,12,2,0,1,15,0,0},
                    {0,11,7,6,0,0,0,16,0,0,0,15,0,0,5,13},
                    {0,0,0,10,0,5,15,0,0,4,0,8,0,0,8,0},
                    {16,0,0,5,9,12,0,0,1,0,0,0,0,0,8,0},
                    {0,2,0,0,0,0,0,13,0,0,12,5,8,0,0,3},
                    {0,13,0,0,15,0,3,0,0,14,8,0,16,0,0,0},
                    {5,8,0,0,1,0,0,0,2,0,0,0,13,9,15,0},
                    {0,0,12,4,0,6,16,0,13,0,0,7,0,0,0,5},
                    {0,3,0,0,12,0,0,0,6,0,0,4,11,0,0,16},
                    {0,7,0,0,16,0,5,0,14,0,0,1,0,0,2,0},
                    {11,1,15,9,0,0,13,0,0,2,0,0,0,14,0,0},
                    {0,14,0,0,0,11,0,2,0,0,13,3,5,0,0,12}
    };

    public int[][]board;
    public static final int size =grid.length;

    public Sudoku (int[][] board){
        this.board = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                this.board[i][j] = board[i][j];
            }
        }

    }

    //check if alread in row
    public boolean inrow(int row, int num){
        for(int i=0;i<size;i++){
            if(board[row][i] == num){
                return true;
            }
        }
        return false;
    }
    //check if alread in column
    public boolean incol(int col, int num){
        for(int i=0;i<size;i++){
            if(board[i][col] == num){
                return true;
            }
        }
        return false;
    }
    //check if already in 3x3 box
    public boolean inbox(int row,int col, int num){
        int box = (int) (Math.sqrt(grid.length));
        int r = row - row % box;
        int c =col- col % box;
        for(int i = r; i < r + box;i++){
            for(int j =c; j<c+box;j++){
                if(board[i][j]==num){
                    return true;
                }

            }
        }
        return false;
    }
    //check if 3 conditions all correct
    public boolean allcorrect (int row, int col, int num){
        if( !inbox(row,col,num) && !incol(col,num) && !inrow(row,num)) {
            return true;
        }
        return false;
    }

    //Inserting num solve the suudoku
    public boolean solvesoduku(){
        for(int row =0; row<size;row++){
            for(int col =0; col<size;col++){
                if(board[row][col]== 0){
                    for(int num =1; num<=size; num++){
                        if(allcorrect(row,col,num)) {
                            board[row][col] = num;
                            if(solvesoduku()){ // backtacking
                                return true;//if solvesuku finaly return true, then is true
                            }
                            else {
                                board[row][col]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;// all correct and solved sudoku
    }
    public void print(){
        for (int i =0;i<size;i++){
            for(int j =0; j<size;j++){
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
            System.out.println();
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(grid);
        System.out.println(" Soduku to solve");
        sudoku.print();

         if(sudoku.solvesoduku()){
             System.out.println("soduku solved");
               sudoku.print();
         }
            else {
                 System.out.println("unsolvable");
            }
    }
}
