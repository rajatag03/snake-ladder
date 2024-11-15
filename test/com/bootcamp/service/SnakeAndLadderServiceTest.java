package com.bootcamp.service;

import com.bootcamp.models.Ladder;
import com.bootcamp.models.Player;
import com.bootcamp.models.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeAndLadderServiceTest {

    private SnakeAndLadderService snakeAndLadderService;

    @BeforeEach
    void setUp() {
        snakeAndLadderService = new SnakeAndLadderService(100); // Board size 100
    }

    @Test
    void testPlayersMoveSimple() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        snakeAndLadderService.setPlayersQueue(Arrays.asList(player1, player2));

        snakeAndLadderService.nextMove(player1,7);

        assertEquals(7, snakeAndLadderService.getPlayerPosition(player1));
    }

    @Test
    void testPlayersMoveUsingLadder() {
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(7,12));

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        snakeAndLadderService.setPlayersQueue(Arrays.asList(player1, player2));
        snakeAndLadderService.setLadders(ladders);

        snakeAndLadderService.nextMove(player1,7);

        assertEquals(12, snakeAndLadderService.getPlayerPosition(player1));
    }

    @Test
    void testPlayersMoveEatenBySnake() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(17,9));

        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        snakeAndLadderService.setPlayersQueue(Arrays.asList(player1, player2));
        snakeAndLadderService.setSnakes(snakes);

        snakeAndLadderService.nextMove(player1,17);

        assertEquals(9, snakeAndLadderService.getPlayerPosition(player1));
    }

}
