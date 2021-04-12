package Util;

import Model.Player;

import java.util.List;
import java.util.Map;

public class Game {

    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;
    List<Player> players;
    private int currentPlayerIdx;
    private boolean isStartOfTheGame;
    private boolean gameOver;
    private int[] board;

    public Game(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }

    public void play() {
        initializeGame();
        while(!gameOver){
            Player currentPlayer = getCurrentPlayer();
            int diceVal = Dice.rollDice();
            updateGameState(diceVal, currentPlayer);
            if(currentPlayer.getPosition()==100){
                System.out.println(currentPlayer.getName() + " wins the game");
                this.gameOver = true;
            }
        }
    }

    private void updateGameState(int diceVal, Player currentPlayer) {
        int position = currentPlayer.getPosition();
        if(position+diceVal == 100){
            players.get(currentPlayerIdx).setPosition(position+diceVal);
            System.out.println(currentPlayer.getName() + " rolled a " + diceVal + " and moved from " + position + " to " + (position+diceVal));
        }else if(position+diceVal<100){
            int finalPosition;
            if(snakes.containsKey(position+diceVal)){
                finalPosition = snakes.get(position+diceVal);
            }else if(ladders.containsKey(position+diceVal)){
                finalPosition = ladders.get(position+diceVal);
            }else{
                finalPosition = position+diceVal;
            }
            players.get(currentPlayerIdx).setPosition(finalPosition);
            System.out.println(currentPlayer.getName() + " rolled a " + diceVal + " and moved from " + position + " to " + finalPosition);
        }else{
            System.out.println(currentPlayer.getName() + " rolled a " + diceVal + " and moved from " + position + " to " + position);
        }
    }

    private Player getCurrentPlayer() {
        if(isStartOfTheGame){
            isStartOfTheGame = false;
            return this.players.get(currentPlayerIdx);
        }
        currentPlayerIdx = (currentPlayerIdx + 1) % this.players.size();
        return this.players.get(currentPlayerIdx);
    }

    private void initializeGame() {
        this.board = new int[101];
        this.currentPlayerIdx = 0;
        this.isStartOfTheGame = true;
        this.gameOver = false;
    }
}
