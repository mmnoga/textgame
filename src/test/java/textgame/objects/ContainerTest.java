package textgame.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import textgame.game.Game;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    private Container container;
    private Container warehouse;

    @Test
    void shouldReturnContainerObject() {
        container = Container
                .builder()
                .name("sample container")
                .description("sample container description")
                .isVisible(true)
                .canBeTaken(true)
                .items(null)
                .build();
        assertTrue(container instanceof Container);
    }

    @Test
    void shouldReturnContainerDescription() {
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
                .isVisible(true)
                .canBeTaken(false)
                .canBeOpen(true)
                .isOpen(true)
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
                .isOpen(true)
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
        warehouseItems.addAll(Arrays.asList(trunk,lamp,table,safe));
        warehouse = Room
                .builder()
                .name("warehouse")
                .description("old, creepy and completely dark place")
                .items(warehouseItems)
                .build();
        System.out.println(warehouse.toString());
    }

    @Test
    void toStringShouldReturnEmptyStringForNotVisibleContainer(){
        container = Container
                .builder()
                .name("sample container")
                .description("sample container description")
                .isVisible(false)
                .canBeTaken(true)
                .build();
        String result = "";
        assertEquals(result, container.toString());
    }

    @Test
    void toStringTest(){
        Item key = Item
                .builder()
                .name("key")
                .description("big, metal")
                .isVisible(true)
                .canBeTaken(true)
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
        System.out.println(table.toString());
    }
}