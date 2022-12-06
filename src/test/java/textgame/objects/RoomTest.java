package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Item paper = new Item("paper", "paper description",true,true);
    private Item key = new Item("key","key description",true,true);
    private ItemList roomItems = new ItemList();
    private ItemList boxItems = new ItemList();
    private Device lamp = new Device("lamp","lamp description",
            true,false,
            false,true);
    private ItemContainer box = new ItemContainer("box","box description",
            true,false,
            false,true,
            boxItems);
    private Room room = new Room("room","room description", roomItems);

    @Test
    void toStringShouldReturnRoomDescription(){
        boxItems.add(paper);
        roomItems.add(lamp);
        roomItems.add(box);
        System.out.println(room.toString());
    }

}