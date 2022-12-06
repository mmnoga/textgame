package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private Item key;
    private Device torch;
    private ItemList playerItems = new ItemList();
    private Room playerRoom;

    @Test
    void toStringShouldReturnPlayerDescription() {
        key = new Item("key", "key description",
                true,
                true);
        torch = new Device("torch", "torch description",
                true, true,
                false, true);
        playerItems.add(key);
        playerItems.add(torch);
        playerRoom = new Room("room", "room description", null);
        player = new Player("player", "player description",
                playerItems,
                playerRoom);

        String playerDesc = player.getName() + " (" + player.getDescription() + ")" + "\n";
        playerDesc += "equipment:\n";
        playerDesc += key.toString() + "\n";
        playerDesc += torch.toString() + "\n";

        assertEquals(playerDesc, player.toString());
    }


}