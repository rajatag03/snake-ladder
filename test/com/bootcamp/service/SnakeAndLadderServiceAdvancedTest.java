package com.bootcamp.service;

import com.bootcamp.models.Ladder;
import com.bootcamp.models.Player;
import com.bootcamp.models.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeAndLadderServiceAdvancedTest {

    private SnakeAndLadderService snakeAndLadderService;

    @BeforeEach
    void setUp() {
        snakeAndLadderService = new SnakeAndLadderService(100); // Board size 100
    }

    @Test
    void testPlayersMoveUsingLadderThenSnake() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(12,9));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(7,12));

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        snakeAndLadderService.setPlayersQueue(Arrays.asList(player1, player2));
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);

        snakeAndLadderService.nextMove(player1,7);

        assertEquals(9, snakeAndLadderService.getPlayerPosition(player1));
    }

    @Test
    void testPlayersMoveEatenBySnakeThenLadder() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(17,9));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(9,24));

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        snakeAndLadderService.setPlayersQueue(Arrays.asList(player1, player2));
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);

        snakeAndLadderService.nextMove(player1,17);

        assertEquals(24, snakeAndLadderService.getPlayerPosition(player1));
    }

    @Test
    void testPlayersMoveMultiSnakeAndLadder() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(17,9));
        snakes.add(new Snake(34,6));
        snakes.add(new Snake(17,9));
        snakes.add(new Snake(23,8));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(9,18));
        ladders.add(new Ladder(18,34));
        ladders.add(new Ladder(6,45));
        ladders.add(new Ladder(45,23));

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        snakeAndLadderService.setPlayersQueue(Arrays.asList(player1, player2));
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);

        snakeAndLadderService.nextMove(player1,17);

        assertEquals(8, snakeAndLadderService.getPlayerPosition(player1));
    }

}
