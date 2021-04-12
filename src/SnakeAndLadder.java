import Model.Player;
import Model.Snake;
import Util.Dice;
import Util.Game;

import java.util.*;

public class SnakeAndLadder {

    public static void main(String[] args) {
        int numOfSnakes, numOfLadders, numOfPlayers;
        Scanner sc = new Scanner(System.in);
        numOfSnakes = sc.nextInt();
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();
        List<Player> players = new ArrayList<>();
        for(int i=0; i<numOfSnakes; i++){
            int head, tail;
            head = sc.nextInt();
            tail = sc.nextInt();
            snakes.put(head, tail);
        }
        numOfLadders = sc.nextInt();
        for(int i=0; i<numOfLadders; i++){
            int start, end;
            start = sc.nextInt();
            end = sc.nextInt();
            ladders.put(start, end);
        }
        numOfPlayers = sc.nextInt();
        for(int i=0; i<numOfPlayers; i++){
            String name = sc.next();
            players.add(new Player(name, 0));
        }

        Game game = new Game(snakes, ladders, players);
        game.play();

    }

}
