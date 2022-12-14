package textgame.helpers;

import textgame.TextGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static List<String> oneWordCommands = new ArrayList<>(Arrays.asList("help", "tools", "me", "look","time"));
    private static List<String> twoWordsCommands = new ArrayList<>(Arrays.asList("take", "drop", "open", "close", "turnon", "turnoff"));
    private static List<String> items = new ArrayList<>(Arrays.asList("key", "code", "trunk", "table", "lamp", "torch", "safe", "treasure"));

    public static String executeOneWordCommand(List<String> commandList) {
        String response = "";
        String command = commandList.get(0);
        if (oneWordCommands.contains(command)) {
            switch (command) {
                case "me":
                    TextGame.game.playerDescription();
                    break;
                case "look":
                    TextGame.game.roomDescription();
                    break;
                case "time":
                    TextGame.game.getTime();
                    break;
                case "help":
                    TextGame.game.help();
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

    public static String executeTwoWordsCommand(List<String> commandList) {
        String response = "";
        String command = commandList.get(0);
        String object = commandList.get(1);
        boolean error = false;
        if (!twoWordsCommands.contains(command)) {
            response = command + " not recognized command!\n";
            error = true;
        }
        if (!items.contains(object)) {
            response = object + " not recognized object!\n";
            error = true;
        }
        if (!error) {
            switch (command) {
                case "turnon":
                    response = TextGame.game.turnOn(object);
                    break;
                case "turnoff":
                    response = TextGame.game.turnOff(object);
                    break;
                case "take":
                    response = TextGame.game.take(object);
                    break;
                case "drop":
                    response = TextGame.game.drop(object);
                    break;
                case "open":
                    response = TextGame.game.open(object);
                    break;
                case "close":
                    response = TextGame.game.close(object);
                    break;
                default:
                    response = "not implemented!";
                    break;
            }
        }
        return response;
    }
}
