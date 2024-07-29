package org.dotComGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DotComTest {

    @Test
    public void whenUserSelectOneCorrectInputThenHit() {
        DotCom dotCom = new DotCom();
        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotCom.setLocationSells(locationCells);
        String actual = dotCom.checkYourself("a1");
        String expected = "Попал";
        assertEquals(expected, actual);
    }

    @Test
    public void whenUserInputIsNotCorrectThenMiss() {
        DotCom dotCom = new DotCom();
        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotCom.setLocationSells(locationCells);
        String actual = dotCom.checkYourself("a4");
        String expected = "Мимо";
        assertEquals(expected, actual);
    }

    @Test
    public void whenUserSelectAllCorrectInputThenKill() {
        DotCom dotCom = new DotCom();
        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotCom.setLocationSells(locationCells);

        String actualHit1 = dotCom.checkYourself("a1");
        assertEquals("Попал", actualHit1);
        assertEquals(2, dotCom.getLocationCells().size());
        assertFalse(dotCom.getLocationCells().contains("a1"));

        String actualHit2 = dotCom.checkYourself("a2");
        assertEquals("Попал", actualHit2);
        assertEquals(1, dotCom.getLocationCells().size());
        assertFalse(dotCom.getLocationCells().contains("a2"));

        String actualHit3 = dotCom.checkYourself("a3");
        assertEquals("Потопил", actualHit3);
        assertEquals(0, dotCom.getLocationCells().size());
        assertFalse(dotCom.getLocationCells().contains("a3"));
    }



}