public class Board {
    char [][] board;
    int size;
    int emptyCells; //to check if valid moves are left

     Board(int size) {
        this.size = size;
        emptyCells = size * size;
        board = new char[size][size];
        initializeBoard();
    }

    void initializeBoard()  {
         for(int i=0;i<size;i++) {
             for(int j=0;j<size;j++) {
                 board[i][j] = '-';
             }
         }
    }

    boolean addPiece(int row, int col, char ch) {
        if(row < 0 || row >= size || col < 0 || col >= size || board[row][col] != '-')  return false;
        board[row][col] = ch;
        printBoard();
        emptyCells--;
        return true;
    }

    boolean isEmptyCellAvailable() {
        if(emptyCells == 0) return false;
        return true;
    }

    void printBoard() {
         for(int i=0;i<size;i++) {
             for (int j=0;j<size;j++) {
                 System.out.print(board[i][j] + " ");
             }
             System.out.println();
         }
    }

    boolean playerWon(int row, int col) {
         char ch = board[row][col];

         boolean horizontal = true;
         boolean vertical = true;
         boolean leftdiagonal = true;
         boolean rightdiagonal = true;

         for(int j=0;j<size;j++) {
             if(board[row][j] != ch) {
                 horizontal = false;
                 break;
             }
         }

         for(int i=0;i<size;i++) {
             if(board[i][col] != ch) {
                 vertical = false;
                 break;
             }
         }

         for(int i = 0;i<size;i++) {
             if(board[i][i] != ch) {
                 leftdiagonal = false;
                 break;
             }
         }

         for(int i=0;i<size;i++) {
             for(int j=0;j<size;j++) {
                 if(i + j == size && board[i][j] != ch) {
                     rightdiagonal = false;
                     break;
                 }
             }
         }

         return (horizontal || vertical || leftdiagonal || rightdiagonal);
    }
}
