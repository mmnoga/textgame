package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    private Container container;

    @Test
    void shouldReturnContainerObject(){
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

}