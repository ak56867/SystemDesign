import Models.Dice;
import Models.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Deque<Player> players;
    Dice dice;
    Board board;

    public Game(List<Player> playerList, List<Jump> snakes, List<Jump> ladders, int boardSize) {
        players = new LinkedList<>(playerList);
        dice = new Dice();
        board = new Board(boardSize);

        board.addSnakes(snakes);
        board.addLadders(ladders);
    }

    public void startGame() {
        boolean winnerFound = false;
        String winner = "";

        while(!winnerFound)  {

            Player player = players.poll();
            int position = player.position;

            int diceVal = dice.rollDice();

            int newPosition = checkJump(position + diceVal);


            if(newPosition == board.board.length * board.board.length)
                winnerFound = true;

            if(newPosition == position) {
                players.addFirst(player);
                continue;
            }

            System.out.println(player.playerName + " rolled a " + diceVal + " and moved from " + position +  " to " + newPosition);

            player.position = newPosition;
            players.addLast(player);

            if(winnerFound)  {
                winner = player.playerName;
                break;
            }

        }

        System.out.println(winner + " wins the game");
    }

    int checkJump(int position) {
        if(position >= board.board.length * board.board.length)
            return position;

        Cell cell = board.getCell(position);
        if(cell.jump != null && cell.jump.start == position)
            return cell.jump.end;
        return position;
    }
}
