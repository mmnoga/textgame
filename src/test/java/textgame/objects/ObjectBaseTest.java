package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectBaseTest {

    @Test
    void shouldReturnObjectBaseObject(){
        ObjectBase item = ObjectBase
                .builder()
                .name("sample object base")
                .description("object base description")
                .build();
        assertTrue(item instanceof ObjectBase);
    }

}