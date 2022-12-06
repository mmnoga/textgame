package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    private Device unswitchableLamp = new Device("lamp", "lamp description",
            true, false,
            false, false);
    private Device lamp;

    @Test
    void unswitchableDeviceShouldReturnCanNonBeSwitchedOnResponse() {
        assertEquals("can not be turned on", unswitchableLamp.turnOn());
    }

    @Test
    void unswitchableDeviceShouldReturnCanNonBeSwitchedOffResponse() {
        assertEquals("can not be turned off", unswitchableLamp.turnOff());
    }

    private Device unvisibleLamp = new Device("lamp", "lamp description",
            false, false,
            false, true);

    @Test
    void unvisibleDeviceShouldReturnThereSNoDeviceOnSwitchOn() {
        assertEquals("there's no device", unvisibleLamp.turnOn());
    }

    @Test
    void unvisibleDeviceShouldReturnThereSNoDeviceOnSwitchOff() {
        assertEquals("there's no device", unvisibleLamp.turnOff());
    }

    private Device turnedOnLamp = new Device("lamp", "lamp description",
            true, false,
            true, true);

    @Test
    void switchedOnDeviceShouldResponseItSAlreadyTurnedOn() {
        assertEquals("it's already turned on", turnedOnLamp.turnOn());
    }

    @Test
    void switchedOffDeviceShouldResponseItSAlreadyTurnedOff() {
        turnedOnLamp.turnOff();
        assertEquals("it's already turned off", turnedOnLamp.turnOff());
    }

    private Device visibleLamp = new Device("lamp", "lamp description",
            true, false,
            false, true);

    @Test
    void visibleSwitchOffCanBeSwitchedDeviceShouldReturnItSBeenTurnedOnResponse() {
        assertEquals("it's been turned on", visibleLamp.turnOn());
    }

    @Test
    void visibleSwitchOnCanBeSwitchedDeviceShouldReturnItSBeenTurnedOffResponse() {
        lamp.turnOn();
        assertEquals("it's been turned off", lamp.turnOff());
    }

    @Test
    void toStringShouldReturnDeviceDescription() {
        lamp = new Device("lamp", "lamp description",
                true, false,
                false, true);

        String switchDesc = lamp.isSwitch() ? "it's switch on" : "it's switch off";
        final String lampDesc = lamp.getName() + " (" + lamp.getDescription() + ")\n" + switchDesc;

        assertEquals(lampDesc, lamp.toString());
    }

}