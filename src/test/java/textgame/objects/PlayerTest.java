package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @Test
    void shouldReturnPlayerObject() {
        player = Player
                .builder()
                .name("player name")
                .description("sample player description")
                .items(null)
                .build();
        assertTrue(player instanceof Player);
    }

}