package problems.tictactoe;

import problems.tictactoe.models.Game;
import problems.tictactoe.models.Player;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Shreyance", 'X');
        Player p2 = new Player("Rahul", 'O');

        Game game = new Game(p1, p2);

        game.playMove(0,0);
        game.playMove(1,0);

        game.playMove(0,1);
        game.playMove(1,1);

        game.playMove(0,2); // Player 1 wins
    }
}
