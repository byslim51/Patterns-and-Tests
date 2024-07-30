package org.dotComGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DotComBustTest {

    @Test

    public void whenUserMoveIsInTheWrongFormatThenYouEnteredSomethingIncorrectly() {
        String userGuess = "a";
        String expected = "Вы ввели что то неправильное.";
        DotComBust dotComBust = new DotComBust();
        String actual = dotComBust.checkUserGuess(userGuess);

        assertEquals(expected, actual);
    }

    @Test

    public void whenTheUserInputIsRepeatedThenYouHaveAlreadyChooseThisCell() {
        String userGuess1 = "a1";
        String userGuess2 = "a1";
        String expected = "Вы уже указывали эту ячейку";
        DotComBust dotComBust = new DotComBust();
        String notActual = dotComBust.checkUserGuess(userGuess1);
        String actual = dotComBust.checkUserGuess(userGuess2);

        assertEquals(expected, actual);
    }

    @Test

    public void whenTheUserMakesMoveThenNumberOfNumOfGuessesIncreases() {
        DotComBust dotComBust = new DotComBust();
        DotCom dotComTest = new DotCom();
        dotComTest.setName("Test.com");
        dotComBust.setDotComsList(dotComTest);

        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotComTest.setLocationSells(locationCells);

        String userGuess = "a4";
        String expected = "Мимо";
        String actual = dotComBust.checkUserGuess(userGuess);

        assertEquals(expected, actual);
    }

    @Test

    public void whenTheUserInputSelectAllCorrectInputThenKill() {
        DotComBust dotComBust = new DotComBust();
        DotCom dotComTest = new DotCom();
        dotComTest.setName("Test.com");
        dotComBust.setDotComsList(dotComTest);

        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotComTest.setLocationSells(locationCells);

        String userGuess1 = "a1";
        String expectedHit1 = "Попал";
        String actual1 = dotComBust.checkUserGuess(userGuess1);
        assertEquals(2, dotComTest.getLocationCells().size());
        assertEquals(expectedHit1, actual1);

        String userGuess2 = "a2";
        String expectedHit2 = "Попал";
        String actual2 = dotComBust.checkUserGuess(userGuess2);
        assertEquals(1, dotComTest.getLocationCells().size());
        assertEquals(expectedHit2, actual2);

        String userGuess3 = "a3";
        String expectedKill = "Потопил";
        String actual3 = dotComBust.checkUserGuess(userGuess3);
        assertEquals(0, dotComTest.getLocationCells().size());
        assertEquals(expectedKill, actual3);
    }

    @Test

    public void whenTheUserInputIsNotCorrectThenMiss() {
        DotComBust dotComBust = new DotComBust();
        DotCom dotComTest = new DotCom();
        dotComTest.setName("Test.com");
        dotComBust.setDotComsList(dotComTest);

        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotComTest.setLocationSells(locationCells);

        String userGuess = "a4";
        String expected = "Мимо";
        String actual = dotComBust.checkUserGuess(userGuess);

        assertEquals(expected, actual);
    }

    @Test

    public void whenTheUserInputIsCorrectThenHit() {
        DotComBust dotComBust = new DotComBust();
        DotCom dotComTest = new DotCom();
        dotComTest.setName("Test.com");
        dotComBust.setDotComsList(dotComTest);

        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotComTest.setLocationSells(locationCells);

        String userGuess = "a2";
        String expected = "Попал";
        String actual = dotComBust.checkUserGuess(userGuess);

        assertEquals(expected, actual);
    }

    @Test

    public void whenTheUserInputIsThreeAndUserWinThenNumOfGuessesIsThree() {
        DotComBust dotComBust = new DotComBust();
        DotCom dotComTest = new DotCom();
        dotComTest.setName("Test.com");
        dotComBust.setDotComsList(dotComTest);

        List<String> locationCells = new ArrayList<>();
        locationCells.add("a1");
        locationCells.add("a2");
        locationCells.add("a3");
        dotComTest.setLocationSells(locationCells);

//        Дополнительная проверка numOfGuesses:
        dotComBust.checkUserGuess("a10");
        dotComBust.checkUserGuess("a");
        dotComBust.checkUserGuess("1");

        String userGuess1 = "a1";
        String expectedHit1 = "Попал";
        String actual1 = dotComBust.checkUserGuess(userGuess1);
        assertEquals(2, dotComTest.getLocationCells().size());
        assertEquals(expectedHit1, actual1);

//       Дополнительная проверка numOfGuesses:
        dotComBust.checkUserGuess("a1");

        String userGuess2 = "a2";
        String expectedHit2 = "Попал";
        String actual2 = dotComBust.checkUserGuess(userGuess2);
        assertEquals(1, dotComTest.getLocationCells().size());
        assertEquals(expectedHit2, actual2);

        String userGuess3 = "a3";
        String expectedKill = "Потопил";
        int expectedNumOfGuesses = 3;
        String actual3 = dotComBust.checkUserGuess(userGuess3);
//        Проверка на удаление элементов из массива:
        assertEquals(0, dotComTest.getLocationCells().size());

//        Проверка на "Потопил"
        assertEquals(expectedKill, actual3);

//        Проверка на корректное количество ходов пользователя:
        assertEquals(expectedNumOfGuesses, dotComBust.getNumOfGuesses());

    }


}