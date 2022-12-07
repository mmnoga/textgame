package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemContainerTest {
    private ItemContainer itemContainer;
    private ItemList itemList;
    private Item item;
    private Device device;

    @Test
    void shouldReturnItemContainerObject() {
        itemContainer = ItemContainer
                .builder()
                .name("sample item container name")
                .description("sample description")
                .isVisible(true)
                .canBeTaken(true)
                .items(null)
                .isOpen(true)
                .canBeOpen(true)
                .build();

        assertTrue(itemContainer instanceof ItemContainer);
    }

    @Test
    void shouldReturnDescriptionOfItemContainer() {
        itemList = new ItemList();
        item = Item
                .builder()
                .name("item name")
                .description("item description")
                .isVisible(true)
                .canBeTaken(true)
                .build();
        device = Device
                .builder()
                .name("sample device")
                .description("sample device description")
                .isVisible(true)
                .canBeTaken(true)
                .isSwitch(true)
                .canBeSwitch(true)
                .build();
        itemList.add(item);
        itemList.add(device);
        itemContainer = ItemContainer
                .builder()
                .name("item container name")
                .description("item container description")
                .isVisible(true)
                .canBeTaken(false)
                .items(itemList)
                .isOpen(true)
                .canBeOpen(true)
                .build();

        System.out.println(itemContainer.toString());

    }

}