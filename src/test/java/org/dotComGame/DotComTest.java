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
        GameStatus actual = dotCom.checkYourself("a1");
        GameStatus expected = GameStatus.HIT;
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
        GameStatus actual = dotCom.checkYourself("a4");
        GameStatus expected = GameStatus.MISS;
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

        GameStatus actualHit1 = dotCom.checkYourself("a1");
        assertEquals(GameStatus.HIT, actualHit1);
        assertEquals(2, dotCom.getLocationCells().size());
        assertFalse(dotCom.getLocationCells().contains("a1"));

        GameStatus actualHit2 = dotCom.checkYourself("a2");
        assertEquals(GameStatus.HIT, actualHit2);
        assertEquals(1, dotCom.getLocationCells().size());
        assertFalse(dotCom.getLocationCells().contains("a2"));

        GameStatus actualHit3 = dotCom.checkYourself("a3");
        assertEquals(GameStatus.KILL, actualHit3);
        assertEquals(0, dotCom.getLocationCells().size());
        assertFalse(dotCom.getLocationCells().contains("a3"));
    }




}