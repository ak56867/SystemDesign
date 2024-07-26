import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner;

    public Game() {
        initialiseGame();
    }

    private void initialiseGame() {
        board = new Board(10,4,3);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame() {

        while(winner == null) {

            Player playerTurn = findPlayerTurn();
            System.out.println("Player ID for current turn is: " + playerTurn.playerId + " and current position is: " + playerTurn.currentPos);

            int diceNumbers = dice.rollDice();

            int playerNewPosition = playerTurn.currentPos + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPos = playerNewPosition;

            System.out.println("New position for player is: " + playerNewPosition);

            if(playerNewPosition >= board.cells.length * board.cells.length-1) {
                winner = playerTurn;
            }
        }

        System.out.println("Winner is: " + winner.playerId);
    }

    private Player findPlayerTurn() {
        Player playerTurn = playerList.removeFirst();
        playerList.addLast(playerTurn);
        return playerTurn;
    }

    private int jumpCheck(int pos) {

        if(pos > board.cells.length * board.cells.length-1) {
            return pos;
        }
        Cell cell = board.getCell(pos);

        if(cell.nextCell != null && cell.nextCell.start == pos) {
            return cell.nextCell.end;
        }

        return pos;
    }
}
