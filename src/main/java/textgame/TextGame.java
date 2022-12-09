package textgame;

import textgame.game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextGame {
    public static Game game;

    public static void main(String[] args) throws IOException {
        game = new Game();
        BufferedReader buffer;
        buffer = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String response = "";

        do {
            System.out.print("> ");
            input = buffer.readLine();

            switch (input) {
                case "quit":
                    response = "end of the game!";
                    break;
                default:
                    response = game.executeCommand(input);
                    break;
            }
            System.out.println(response);
        } while (!"quit".equals(input));
    }

}
