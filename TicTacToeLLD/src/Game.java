import org.graalvm.collections.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Board board;
    Deque<Player> players;
    Deque<List<Integer>> coords;

    Game(List<Player> players, List<List<Integer>> coords) {
        board = new Board(3);
        this.players = new LinkedList<>(players);
        this.coords = new LinkedList<>(coords);
    }

    void startGame() {
        board.printBoard();
        if(coords.size() == 0)  return;
        while(true) {
            Player player = players.poll();
            List<Integer> coord = coords.poll();
            int row = coord.get(0);
            int col = coord.get(1);

            if(!board.isEmptyCellAvailable()) { //if no valid move left, game over
                System.out.println("Game Over");
                break;
            }

            if(board.addPiece(row,col,player.playerPiece)) { //add piece and check if the player won
                if(board.playerWon(row,col)) {
                    System.out.println(player.playerName + " won the game");
                    break;
                }
                players.addLast(player);
            } else {
                players.addFirst(player);
                System.out.println("Invalid Move");
            }
        }
    }
}
