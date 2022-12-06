package textgame.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    Device unswitchableLamp = new Device("lamp", "lamp description",
            true, false,
            false,false);

    @Test
    void unswitchableDeviceShouldReturnCanNonBeSwitchedOnResponse(){
        assertEquals("can not be turned on", unswitchableLamp.turnOn());
    }

    @Test
    void unswitchableDeviceShouldReturnCanNonBeSwitchedOffResponse(){
        assertEquals("can not be turned off", unswitchableLamp.turnOff());
    }

    Device unvisibleLamp = new Device("lamp", "lamp description",
            false, false,
            false,true);

    @Test
    void unvisibleDeviceShouldReturnThereSNoDeviceOnSwitchOn(){
        assertEquals("there's no device", unvisibleLamp.turnOn());
    }

    @Test
    void unvisibleDeviceShouldReturnThereSNoDeviceOnSwitchOff(){
        assertEquals("there's no device", unvisibleLamp.turnOff());
    }

    Device turnedOnLamp = new Device("lamp", "lamp description",
            true, false,
            true,true);

    @Test
    void switchedOnDeviceShouldResponseItSAlreadyTurnedOn(){
        assertEquals("it's already turned on", turnedOnLamp.turnOn());
    }

    @Test
    void switchedOffDeviceShouldResponseItSAlreadyTurnedOff(){
        turnedOnLamp.turnOff();
        assertEquals("it's already turned off", turnedOnLamp.turnOff());
    }

    Device lamp = new Device("lamp", "lamp description",
            true, false,
            false,true);

    @Test
    void visibleSwitchOffCanBeSwitchedDeviceShoudReturnItSBeenTurnedOnResponse(){
        assertEquals("it's been turned on", lamp.turnOn());
    }

    @Test
    void visibleSwitchOnCanBeSwitchedDeviceShoudReturnItSBeenTurnedOffResponse(){
        lamp.turnOn();
        assertEquals("it's been turned off", lamp.turnOff());
    }

}