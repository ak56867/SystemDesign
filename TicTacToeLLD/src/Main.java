import org.graalvm.collections.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String player1Name = sc.nextLine();
        Player player1 = new Player(player1Name, 'X');
        String player2Name = sc.nextLine();
        Player player2 = new Player(player2Name, 'O');

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        List<List<Integer>> coords = new ArrayList<>();
        while(true) {
            String input = sc.nextLine();
            if(input.equals("exit")) {
                break;
            }

            String[] token = input.split(" ");
            int row = Integer.parseInt(token[0]);
            int col = Integer.parseInt(token[1]);

            List<Integer> coord = new ArrayList<>();
            coord.add(row-1);
            coord.add(col-1);

            coords.add(coord);
        }

        Game game = new Game(players, coords);
        game.startGame();
    }
}