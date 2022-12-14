package textgame.game;

import textgame.helpers.Parser;
import textgame.helpers.Timer;
import textgame.objects.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private Timer timer;

    public Game() {
        Item paper = Item
                .builder()
                .name("code")
                .description("a piece of paper with code: 6-3-9")
                .isVisible(true)
                .canBeTaken(true)
                .build();
        Item key = Item
                .builder()
                .name("key")
                .description("big, metal")
                .isVisible(true)
                .canBeTaken(true)
                .build();
        Item treasure = Item
                .builder()
                .name("treasure")
                .description("$1000000 in cash!")
                .isVisible(true)
                .canBeTaken(true)
                .build();
        Device torch = Device
                .builder()
                .name("torch")
                .description("an electric device using batteries")
                .canBeSwitch(true)
                .isSwitch(false)
                .isVisible(true)
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
                .key("key")
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
                .key("code")
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
                .description("old, creepy and completely dark place.")
                .items(warehouseItems)
                .build();
        ItemList playerItems = new ItemList();
        playerItems.add(torch);
        player = Player
                .builder()
                .name("Dewey")
                .description("fearless treasure hunter!")
                .isVisible(true)
                .items(playerItems)
                .room(warehouse)
                .build();

        intro();
        help();
        startTimer();
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

    public void intro(){
        System.out.println("Welcome to The Mystery Warehouse Game!");
        System.out.println("You are a treasure hunter and your task is to find a treasure.");
        System.out.println("Your time is 5 minutes!\n");
    }

    public void help() {
        System.out.println("Available commands: me, look, help, turnon, turnoff, take, drop, open, close, time.");
        System.out.println("Please enter a singe command or a command with object.");
        System.out.println("Enter quit to end the game.");
    }

    public void playerDescription() {
        System.out.println(getPlayer().toString());
    }

    public void roomDescription() {
        System.out.print("You are in " + getPlayer().getPosition().getName() + " - ");
        System.out.println(getPlayer().getPosition().getDescription());
        System.out.println("You can see:");
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
                if(itemPlayer.isVisible()){
                    ((Device) itemPlayer).turnOn();
                    response = itemPlayer.getName() + "'s been turned on!";
                    showObject();
                } else {
                    response = "no item!";
                }
            }
        } else {
            if (!(itemRoom instanceof Device)) {
                response = "can't turn on " + itemRoom.getName();
            } else {
                if(itemRoom.isVisible()){
                    ((Device) itemRoom).turnOn();
                    response = itemRoom.getName() + "'s been turned on!";
                    showObject();
                } else {
                    response = "no item!";
                }
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
                response = itemPlayer.getName() + "'s been turned off!";
                hideObjects();
            }
        } else {
            if (!(itemRoom instanceof Device)) {
                response = "can't turn off this item!";
            } else {
                ((Device) itemRoom).turnOn();
                response = itemRoom.getName() + "'s been turned off!";
                hideObjects();
            }
        }
        return response;
    }

    private void moveItem(Item item, ItemList from, ItemList to) {
        from.remove(item);
        to.add(item);
    }

    public String take(String object) {
        String response = "";
        if (player.getItems().thisObject(object) != null) {
            response = "you have got this item!";
            return response;
        }
        ItemList roomItems = player.getPosition().getItems();
        if (roomItems != null) {
            for (Item item : roomItems) {
                switch (item.getClass().getSimpleName()) {
                    case "Device":
                        if (item.getName().equals(object)) {
                            moveItem(item, player.getPosition().getItems(), player.getItems());
                            response = item.getName() + " has been taken!";
                        }
                        break;
                    case "Container":
                        ItemList containerItems = (((Container) item).getItems());
                        for (Item i : containerItems) {
                            if (i.getName().equals(object)) {
                                containerItems.remove(i);
                                player.getItems().add(i);
                                response = i.getName() + " has been taken!";
                                break;
                            }
                        }
                        break;
                    case "ItemContainer":
                        ItemList itemContainerItems = (((ItemContainer) item).getItems());
                        for (Item i : itemContainerItems) {
                            if (i.getName().equals(object)) {
                                itemContainerItems.remove(i);
                                player.getItems().add(i);
                                response = i.getName() + " has been taken!";
                                break;
                            }
                        }
                        break;
                }
            }
        }
        checkWin();
        return response;
    }

    public String drop(String object) {
        String response = "";
        Item item = player.getItems().thisObject(object);
        if (item == null) {
            response = "you don't have this item!";
        } else {
            moveItem(item, player.getItems(), player.getPosition().getItems());
            response = item.getName() + " has been dropped!";
        }
        return response;
    }

    public String open(String object) {
        String response = "";
        Item item = player.getPosition().getItems().thisObject(object);
        if (!(item instanceof ItemContainer)) {
            response = "can't open " + item.getName();
            return response;
        }
        Item key = player.getItems().thisObject("key");
        Item code = player.getItems().thisObject("code");
        if (item == null) {
            response = "no item to open!";
        }
        if (((ItemContainer) item).canBeOpen()) {
            if (((ItemContainer) item).isOpen()) {
                response = item.getName() + " already open!";
            } else {
                if (((ItemContainer) item).isKeyNeeded()) {
                    String k = ((ItemContainer) item).getKey();
                    if (key != null && key.getName() == k) {
                        ((ItemContainer) item).open(key.getName());
                        response = item.getName() + " has been opened!";
                        return response;
                    }
                    if (code != null && code.getName() == k) {
                        ((ItemContainer) item).open(code.getName());
                        response = item.getName() + " has been opened!";
                        return response;
                    }
                    response = ((ItemContainer) item).getKey() +" needed!";
                } else {
                    ((ItemContainer) item).open("");
                    response = item.getName() + " has been opened!";
                }
            }
        }
        return response;
    }

    public String close(String object) {
        String response = "";
        Item item = player.getPosition().getItems().thisObject(object);
        if (!(item instanceof ItemContainer)) {
            response = "can't close " + item.getName();
            return response;
        }
        if (item == null) {
            response = "no item to close!";
        }
        if (((ItemContainer) item).canBeOpen()) {
            if (!((ItemContainer) item).isOpen()) {
                response = item.getName() + " already closed!";
            } else {
                ((ItemContainer) item).close();
                response = item.getName() + " has been closed!";
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

    public void showObject() {
        ItemList items = getPlayer().getPosition().getItems();
        for (Item item : items) {
            item.show();
        }
    }

    private void checkWin() {
        if (player.getItems() != null) {
            for (Item i : player.getItems()) {
                if (i.getName() == "treasure") {
                    System.out.println("You have won!!!!!!!");
                    System.exit(0);
                }
            }
        }
    }

    public void getTime(){
        timer.printElapsedTime();
    }

    private void startTimer(){
        timer = new Timer(300);
        timer.start();
    }

}
