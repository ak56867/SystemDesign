import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Board board;
    Deque<Player> playerList;
    int freeCells = 3 * 3;

    public void initialize(){
        playerList = new LinkedList<>();

        PieceX pieceX = new PieceX();
        Player player1 = new Player("abhinav", pieceX);

        PieceO pieceo = new PieceO();
        Player player2 = new Player("Mohini", pieceo);

        playerList.add(player1);
        playerList.add(player2);

        board = new Board(3);
    }

    public void startGame(){
        boolean isWinner = false;
        int row, col;

        while(!isWinner) {
            Player playerTurn = playerList.removeFirst();
            System.out.println(playerTurn.name + "'s Turn => ");
            board.printBoard();

            if(freeCells == 0){
                System.out.println("Its a draw!!");
                isWinner = true;
                continue;
            }

            System.out.println("Enter coordinates of cell where you want to put your piece: ");

            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");

            row = Integer.valueOf(values[0]);
            col = Integer.valueOf(values[1]);

            row--; col--;

            boolean pieceAddedSuccessfully = board.addPiece(row,col,playerTurn.playingPiece);

            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect input, please enter again");
                playerList.addFirst(playerTurn);
                continue;
            }

            freeCells--;
            playerList.addLast(playerTurn);

            isWinner = winnerFound(row,col,playerTurn.playingPiece.piece);

            if(isWinner){
                System.out.println("CONGRATULATIONS " + playerTurn.name + " WON!!!");
                continue;
            }
        }
    }

    public boolean winnerFound(int row, int col, Piece piece){

        boolean checkRow = true;
        boolean checkCol = true;
        boolean checkMajorDiagonal = true;
        boolean checkMinorDiagonal = true;

        for(int i=0;i<board.size;i++)
        {
            if((board.board[i][col] == null) || (board.board[i][col].piece != piece)){
                checkCol = false;
                break;
            }
        }

        for(int j=0;j<board.size;j++)
        {
            if(board.board[row][j] == null || (board.board[row][j].piece != piece)){
                checkRow = false;
                break;
            }
        }

        for(int i=0;i<board.size;i++){
            if(board.board[i][i] == null || board.board[i][i].piece != piece){
                checkMajorDiagonal = false;
                break;
            }
        }

        for(int i=0;i<board.size;i++) {
            for(int j=0;j<board.size;j++) {
                if(i + j + 1 == board.size && (board.board[i][j] == null || board.board[i][j].piece != piece)) {
                    checkMinorDiagonal = false;
                    break;
                }
            }
        }

        return (checkRow || checkCol || checkMajorDiagonal || checkMinorDiagonal);
    }
}
