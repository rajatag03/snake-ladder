package com.bootcamp.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {

    int size;
    List<Snake> snakes;
    List<Ladder> ladders;
    Map<String,Integer> playerPosition;

    public SnakeAndLadderBoard(int size) {
        this.snakes = new ArrayList<>();
        this.size = size;
        this.ladders = new ArrayList<>();
        this.playerPosition = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Map<String, Integer> playerPosition) {
        this.playerPosition = playerPosition;
    }
}
