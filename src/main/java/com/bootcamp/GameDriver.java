package com.bootcamp;

import com.bootcamp.models.Ladder;
import com.bootcamp.models.Player;
import com.bootcamp.models.Snake;
import com.bootcamp.service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;

public class GameDriver {

    public static void main(String[] args) {

        int numberOfSnakes = 5;
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(20,10));
        snakes.add(new Snake(89,77));
        snakes.add(new Snake(54,45));
        snakes.add(new Snake(43,36));
        snakes.add(new Snake(25,7));

        int numberOfLadders = 5;
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(7,12));
        ladders.add(new Ladder(20,46));
        ladders.add(new Ladder(42,67));
        ladders.add(new Ladder(53,88));
        ladders.add(new Ladder(72,93));

        int numberOfPlayers = 4;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Roy"));
        players.add(new Player("Tony"));
        players.add(new Player("Grant"));
        players.add(new Player("Steve"));

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService(100);
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setPlayersQueue(players);

        snakeAndLadderService.startGame();
    }
}
