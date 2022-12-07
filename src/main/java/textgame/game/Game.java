package textgame.game;

import textgame.objects.*;

public class Game {
    private Player player;

    public Game() {
        Item paper = Item
                .builder()
                .name("paper")
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
                .isVisible(true)
                .canBeTaken(false)
                .build();
        ItemList trunkItems = new ItemList();
        trunkItems.add(paper);
        ItemContainer trunk = ItemContainer
                .builder()
                .name("trunk")
                .description("big, wooden box")
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
                .isVisible(true)
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
                .isVisible(true)
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
                .build();
    }

    public Player getPlayer() {
        return player;
    }

}
