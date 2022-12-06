package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item key = new Item("key", "key description",true,false);
    private final String keyDesc = "key (key description)\nit can't be taken";
    private Item unvisibleKey = new Item("key", "key description",false,false);

    @Test
    void toStringShouldReturnItemDescription(){
        assertEquals(keyDesc, key.toString());
    }

    @Test
    void toStringShouldReturnThereSNoItemForUnvisibleItem(){
        assertEquals("there's no item", unvisibleKey.toString());
    }

}