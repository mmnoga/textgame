package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemContainerTest {
    private Item paper = new Item("paper", "paper description",true,false);
    private Item key = new Item("key", "key description",true,true);
    private ItemList boxItems = new ItemList();
    private ItemContainer invisibleBox = new ItemContainer("box", "box description",
            false,true,
            true, true,
            boxItems);
    private String invisibleBoxDesc = "there's no item";
    private ItemContainer visibleBox = new ItemContainer("box", "box description",
            true,false,
            false, false,
            boxItems);
    private String visibleBoxDesc = "box (box description)\nit can't be taken";
    private ItemContainer openBox = new ItemContainer("box", "box description",
            true,false,
            true, true,
            boxItems);

    @Test
    void toStringShuldReturnThereSNoItemForInvisibleItemContainer(){
        assertEquals(invisibleBoxDesc, invisibleBox.toString());
    }

    @Test
    void toStringShuldReturnDescriptionForVisibleItemContainer(){
        System.out.println(visibleBox.toString());
        assertEquals(visibleBoxDesc, visibleBoxDesc.toString());
    }

    @Test
    void toStringShouldReturnDescriptionForCanBeOpenAndOpenItemContainer(){
        boxItems.add(paper);
        boxItems.add(key);
        openBox.setItems(boxItems);
        System.out.println(openBox.toString());
    }

}