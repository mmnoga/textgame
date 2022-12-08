package textgame.game;

import textgame.helpers.Parser;
import textgame.objects.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;

    public Game() {
        Item paper = Item
                .builder()
                .name("paper")
                .description("a piece of paper with code: 6-3-9")
                .isVisible(false)
                .canBeTaken(true)
                .build();
        Item key = Item
                .builder()
                .name("key")
                .description("big, metal")
                .isVisible(false)
                .canBeTaken(true)
                .build();
        Item treasure = Item
                .builder()
                .name("treasure")
                .description("$1000000 in cash!")
                .isVisible(false)
                .canBeTaken(true)
                .build();
        Device torch = Device
                .builder()
                .name("torch")
                .description("an electric device using batteries")
                .canBeSwitch(true)
                .isSwitch(false)
                .isVisible(false)
                .canBeTaken(true)
                .build();
        Device lamp = Device
                .builder()
                .name("lamp")
                .description("it's hanging from the celling on a metal chain")
                .canBeSwitch(true)
                .isSwitch(false)
                .isVisible(false)
                .canBeTaken(false)
                .build();
        ItemList trunkItems = new ItemList();
        trunkItems.add(paper);
        ItemContainer trunk = ItemContainer
                .builder()
                .name("trunk")
                .description("big, wooden box")
                .isVisible(false)
                .canBeTaken(false)
                .canBeOpen(true)
                .isOpen(false)
                .items(trunkItems)
                .build();
        ItemList safeItems = new ItemList();
        safeItems.add(treasure);
        ItemContainer safe = ItemContainer
                .builder()
                .name("safe")
                .description("secured unbreakable container, to open the code is needed")
                .isVisible(false)
                .canBeOpen(true)
                .isOpen(false)
                .canBeTaken(false)
                .items(safeItems)
                .build();
        ItemList tableItems = new ItemList();
        tableItems.add(key);
        Container table = Container
                .builder()
                .name("table")
                .description("old, round and scratched")
                .isVisible(false)
                .canBeTaken(false)
                .items(tableItems)
                .build();
        ItemList warehouseItems = new ItemList();
        warehouseItems.add(lamp);
        warehouseItems.add(table);
        warehouseItems.add(safe);
        warehouseItems.add(trunk);
        Room warehouse = Room
                .builder()
                .name("warehouse")
                .description("old, creepy and completely dark place")
                .items(warehouseItems)
                .build();
        ItemList playerItems = new ItemList();
        playerItems.add(torch);
        player = Player
                .builder()
                .name("Dewey")
                .description("fearless treasure hunter")
                .isVisible(true)
                .items(playerItems)
                .room(warehouse)
                .build();
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> getCommandWordListFromString(String command) {
        List<String> commandWordList = new ArrayList<>();
        String[] words = command.split(" ");

        for (String w : words) {
            commandWordList.add(w);
        }
        return commandWordList;
    }

    public String executeCommand(String command) {
        String response = "";
        List<String> commandWordList;
        String lowerCaseCommand = command.trim().toLowerCase();

        if (!lowerCaseCommand.equals("quit")) {
            if (command.equals("")) {
                response = "please enter a command!";
            } else {
                commandWordList = getCommandWordListFromString(lowerCaseCommand);
                response = parseCommand(commandWordList);
            }
        }
        return response;
    }

    public String parseCommand(List<String> commands) {
        String response = "";
        if (commands.size() == 1) {
            response = Parser.executeOneWordCommand(commands);

        } else if (commands.size() == 2) {
            response = Parser.executeTwoWordsCommand(commands);
        } else {
            response = "command not recognized!";
        }
        return response;
    }

    public void helpDescription() {
        System.out.println("available commands: me, look, help, turnon, turnoff");
        System.out.println("please enter a singe command or a command with object");
        System.out.println("enter quit to end the game");
    }

    public void playerDescription() {
        System.out.println(getPlayer().toString());
    }

    public void roomDescription() {
        System.out.println(getPlayer().getPosition().getItems().toString());
    }

    public String turnOn(String device) {
        String response = "";
        Item itemPlayer = player.getItems().thisObject(device);
        Item itemRoom = player.getPosition().getItems().thisObject(device);
        if (itemPlayer == null && itemRoom == null) {
            response = "there's no that item!";
            return response;
        }
        if (itemPlayer != null) {
            if (!(itemPlayer instanceof Device)) {
                response = "can't turn on this item!";
            } else {
                ((Device) itemPlayer).turnOn();
                response = "device's been turned on!";
                showObject();
            }
        } else {
            if (!(itemRoom instanceof Device)) {
                response = "can't turn on this item!";
            } else {
                ((Device) itemRoom).turnOn();
                response = "device's been turned on!";
                showObject();
            }
        }
        return response;
    }

    public String turnOff(String device) {
        String response = "";
        Item itemPlayer = player.getItems().thisObject(device);
        Item itemRoom = player.getPosition().getItems().thisObject(device);
        if (itemPlayer == null && itemRoom == null) {
            response = "there's no that item!";
            return response;
        }
        if (itemPlayer != null) {
            if (!(itemPlayer instanceof Device)) {
                response = "can't turn off this item!";
            } else {
                ((Device) itemPlayer).turnOff();
                response = "device's been turned off!";
                hideObjects();
            }
        } else {
            if (!(itemRoom instanceof Device)) {
                response = "can't turn off this item!";
            } else {
                ((Device) itemRoom).turnOn();
                response = "device's been turned off!";
                hideObjects();
            }
        }
        return response;
    }

    public void hideObjects() {
        ItemList items = getPlayer().getPosition().getItems();
        for (Item item : items) {
            item.hide();
        }
    }

    public void showObject(){
        ItemList items = getPlayer().getPosition().getItems();
        for (Item item : items) {
            item.show();
        }
    }

}
