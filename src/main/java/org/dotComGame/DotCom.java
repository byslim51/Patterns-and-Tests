package org.dotComGame;

import java.util.ArrayList;
import java.util.List;

public class DotCom {
    private List<String> locationCells = new ArrayList<>();
    private String name;

    public List<String> getLocationCells() {
        return locationCells;
    }

    /**
     * Конструкторы в виде примера:
     */
    public DotCom() {
    }
    public DotCom(String name) {
        this.name = name;
    }
    public DotCom(List<String> locationCells, String name) {
        this.locationCells = locationCells;
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    public void setLocationSells(List<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public GameStatus checkYourself(String userInput) {
        GameStatus gameStatus = GameStatus.MISS;

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                gameStatus = GameStatus.KILL;
            } else {
                gameStatus = GameStatus.HIT;
            }
        }
        return gameStatus;
    }
}
