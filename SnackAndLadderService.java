package service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pojo.Board;
import pojo.Ladder;
import pojo.Player;
import pojo.Snack;

import java.util.*;

public class SnackAndLadderService {
    private List<Player> players;
    private Board board;
    private Boolean gameEnd = false;
    private int noOfPlayers;

    private Queue<Player> playerQueue;


    public SnackAndLadderService(int size) {
        this.players = new ArrayList<>();
        this.board = new Board(size);
        this.playerQueue = new LinkedList<>();
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
        this.noOfPlayers = players.size();
        Map<Integer, Integer> playesPos = new HashMap<>();
        for(Player p : players) {
            playesPos.put(p.getId(), 0);
            playerQueue.add(p);
        }
        this.board.setPlayerPositions(playesPos);
    }

    public Board getBoard() {
        return this.board;
    }

    public void setLadders(List<Ladder> ladders) {
        this.board.setLadders(ladders);
    }

    public void setSnacks(List<Snack> snacks) {
        this.board.setSnacks((snacks));
    }

    private void movePlayer(Player player, int moves) {

        int currPosition = this.board.getPlayerPositions().get(player.getId());
        int nextPosition = currPosition + moves;

        if(nextPosition > this.board.getSizeOfBoard()) {
            nextPosition = currPosition;
        } else {

            //check of snack is there into next position
            for(Snack snack : this.board.getSnacks()) {
                if(snack.getHead() == nextPosition) {
                    nextPosition = snack.getTail();
                }
            }

            //check of ladder is there into next position
            for(Ladder ladder : this.board.getLadders()) {
                if(ladder.getHead() == nextPosition) {
                    nextPosition = ladder.getTail();
                }
            }
        }
        this.board.getPlayerPositions().put(player.getId(), nextPosition);
        System.out.println("player with Id " + player.getId() + " moves from " + currPosition + " to " + nextPosition);
    }

    private Boolean isPlayerWin(Player player) {

        if(this.board.getPlayerPositions().get(player.getId()) == this.board.getSizeOfBoard()) {
            return true;
        }

        return false;
    }

    private Boolean isGameEnded() {
        if (this.playerQueue.size() == 1) {
            return true;
        }
        return false;
    }
    public void startGame() {

        while(!isGameEnded()) {

            int nextMove = DiceService.roll();
            Player currePlayer = playerQueue.poll();
            movePlayer(currePlayer, nextMove);

            if(isPlayerWin(currePlayer)) {
                System.out.println("Player with name and id : " + currePlayer.getName() + " " + currePlayer.getId() + " won !!");
            } else {
                this.playerQueue.add(currePlayer);
            }

        }
    }
}
