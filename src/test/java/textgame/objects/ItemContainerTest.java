package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemContainerTest {
    private ItemContainer itemContainer;

    @Test
    void shouldReturnItemContainerObject(){
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

}