import Models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Jump> getSnakes() {
        int numSnakes;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of snakes:");
        numSnakes = scanner.nextInt();

        List<Jump> snakes = new ArrayList<>();

        System.out.println("Enter start and end of snakes:");
        for(int i=0;i<numSnakes;i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            Jump jump = new Jump();
            jump.start = start;
            jump.end = end;

            snakes.add(jump);
        }
        return snakes;
    }
    static List<Jump> getLadders() {
        int numLadders;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of Ladders:");
        numLadders = scanner.nextInt();

        List<Jump> ladders = new ArrayList<>();

        System.out.println("Enter start and end of ladders:");
        for(int i=0;i<numLadders;i++)  {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            Jump jump = new Jump();
            jump.start = start;
            jump.end = end;

            ladders.add(jump);
        }
        return ladders;
    }
    static List<Player> getPlayers() {
        int numPlayers;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of players:");
        numPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();

        System.out.println("Enter player names:");
        for(int i=0;i<numPlayers;i++) {
            String name = scanner.nextLine();
            Player player = new Player(name);

            players.add(player);
        }

        return players;
    }
    public static void main(String[] args) {
        List<Jump> snakes = getSnakes();
        List<Jump> ladders = getLadders();
        List<Player> players = getPlayers();

        Game game = new Game(players,snakes,ladders,10);
        game.startGame();
    }
}