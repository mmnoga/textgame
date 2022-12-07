package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    private Device device;

    @Test
    void shouldReturnDeviceObject(){
        device = Device
                .builder()
                .name("sample device")
                .description("sample device description")
                .isVisible(true)
                .canBeTaken(true)
                .isSwitch(true)
                .canBeSwitch(true)
                .build();
        assertTrue(device instanceof Device);
    }
}