package textgame.helpers;

import textgame.TextGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static List<String> oneWordCommands = new ArrayList<>(Arrays.asList("help", "tools", "me"));
    private static List<String> twoWordsCommands = new ArrayList<>(Arrays.asList("take", "drop", "open", "close", "turnon", "turnoff"));
    private static List<String> items = new ArrayList<>(Arrays.asList("key", "paper", "trunk", "table", "lamp", "torch", "safe", "treasure"));

    public static String executeOneWordCommand(List<String> commandList) {
        String response = "";
        String command = commandList.get(0);
        if (oneWordCommands.contains(command)) {
            switch (command) {
                case "me":
                    TextGame.game.playerDescription();
                    break;
                case "help":
                    TextGame.game.helpDescription();
                    break;
                default:
                    response = command + " not implemented!";
                    break;
            }
        } else {
            response = command + " not recognized command!";
        }
        return response;
    }
}
