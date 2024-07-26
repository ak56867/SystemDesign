import Model.*;
import org.graalvm.collections.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    //using deque because we will remove the first player and add him to last for turn wise game
    Deque<Player> players;

    Board board;

    Integer freeCells = 3 * 3;

    //This initializes the players and board, this can be also done dynamically if required
    public void intializeGame(){
        players = new LinkedList<>();
        PieceX crossPiece = new PieceX();
        Player player1 = new Player("Player1", crossPiece);

        PieceO noughtPiece = new PieceO();
        Player player2 = new Player("Player2", noughtPiece);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public void startGame(){

        boolean noWinner = true;

        while (noWinner){
            Player playerTurn = players.removeFirst();

            board.printBoard();

            if(freeCells == 0){
                noWinner = false;
                continue;
            }

            System.out.println(playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = board.addPiece(row,column, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect input, please enter a valid input");
                players.addFirst(playerTurn);
                continue;
            }
            freeCells--;
            players.addLast(playerTurn);

            boolean winner = WinnerFound(row,column,playerTurn.playingPiece);
        }
    }

    boolean WinnerFound(int row, int column, PlayingPiece playingPiece){
        for(int i = 0;i<3;i++){
            if(board[i][column] == null || board[i][column] != playingPiece) break;
        }
        for()
    }
}
