package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item;

    @Test
    void shouldReturnItemObject(){
        item = Item
                .builder()
                .name("sample item")
                .description("sample item description")
                .isVisible(true)
                .canBeTaken(true)
                .build();
        assertTrue(item instanceof Item);
    }

}