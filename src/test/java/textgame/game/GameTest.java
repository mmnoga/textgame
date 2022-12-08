package textgame.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @Test
    void toStringShouldReturnEmptyStringOnHideObject() {
        game = new Game();
        game.hideObjects();
        String result = "";
        assertEquals(result, game.getPlayer().getPosition().getItems().toString());
    }

}