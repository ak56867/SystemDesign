package Model;

public class Board {

    int size;
    PlayingPiece[][] board;

    //Taking a size and constructing a board of that size
    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    //it checks if input is valid or not and if its valid it adds the piece to board
    public boolean addPiece(int row, int column, PlayingPiece playingPiece){
        if(row < 0 || row >= size || column < 0 || column >= size || board[row][column] != null){
            return false;
        }

        board[row][column] = playingPiece;
        return true;
    }

    public void printBoard(){

        for(int i=0;i<6;i++) {
            if(i%2 == 1){
                System.out.println();
                continue;
            }
            for (int j = 0; j < 7; j++) {

            }
        }
    }
}
