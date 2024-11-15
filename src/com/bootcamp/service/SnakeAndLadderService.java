package com.bootcamp.service;

import com.bootcamp.models.Ladder;
import com.bootcamp.models.Player;
import com.bootcamp.models.Snake;
import com.bootcamp.models.SnakeAndLadderBoard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderService {

    private SnakeAndLadderBoard board;
    Queue<Player> playersQueue;
    private int initialNumberOfPlayers;

    public SnakeAndLadderService(Integer boardSize) {
        this.board = new SnakeAndLadderBoard(boardSize);
        playersQueue = new LinkedList<>();
    }

    public Queue<Player> getPlayersQueue() {
        return playersQueue;
    }

    public void setPlayersQueue(List<Player> players) {
        this.initialNumberOfPlayers = players.size();
        for(Player player:players){
            this.playersQueue.add(player);
            board.getPlayerPosition().put(player.getId(),0);
        }
    }

    public void setSnakes(List<Snake> snakes) {
        board.setSnakes(snakes); // Add snakes to board
    }

    public void setLadders(List<Ladder> ladders) {
        board.setLadders(ladders); // Add ladders to board
    }

    public void nextMove(Player player,int move){
        int oldPosition = getPlayerPosition(player);
        int newPosition = oldPosition + move;

        //Logic if the movement valid
        board.getPlayerPosition().put(player.getId(),newPosition);

        System.out.println(player.getName() + " rolled a " + move + " and moved to " + newPosition);
    }

    private boolean isGameOver(){
        return playersQueue.size()<initialNumberOfPlayers;
    }

    public void startGame(){
        while(!isGameOver()){
            Player currentPlayer = playersQueue.poll();
            int diceRoll = DiceService.rollDice();
            nextMove(currentPlayer,diceRoll);
            if(hasPlayerWon(currentPlayer)){
                System.out.println(currentPlayer.getName() + " won the game!!");
                board.getPlayerPosition().remove(currentPlayer.getId());
            }
            else {
                playersQueue.add(currentPlayer);
            }
        }
    }

    private boolean hasPlayerWon(Player currentPlayer) {
        int currentPlayerPosition = getPlayerPosition(currentPlayer);
        return currentPlayerPosition == board.getSize();
    }

    public int getPlayerPosition(Player player){
        return board.getPlayerPosition().get(player.getId());
    }
}
