package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;

    @Test
    void shouldReturnRoomObject() {
        room = Room
                .builder()
                .name("room name")
                .description("sample room description")
                .items(null)
                .build();
        assertTrue(room instanceof Room);
    }

}