public class Board {
    PlayingPiece board[][];
    int size;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if(row < 0 || row >= size || col < 0 || col >= size || board[row][col] != null) return false;
        board[row][col] = playingPiece;
        return true;
    }

    public void printBoard(){
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j] != null)
                    System.out.print(board[i][j].piece);
                else
                    System.out.print(" ");

                if(j < size-1)
                    System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
