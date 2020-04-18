package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private int sizeOfBoard;
    private List<Snack> snacks;
    private List<Ladder> ladders;
    private Map<Integer, Integer> playerPositions;

    public Board(int size) {

        this.sizeOfBoard = size;
        this.snacks = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPositions = new HashMap<>();
    }

    public List<Snack> getSnacks() {
        return this.snacks;
    }

    public List<Ladder> getLadders() {
        return this.ladders;
    }

    public Map<Integer, Integer> getPlayerPositions() {
        return this.playerPositions;
    }

    public int getSizeOfBoard() {
        return this.sizeOfBoard;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }

    public void setPlayerPositions(Map<Integer, Integer> playerPositions) {
        this.playerPositions = playerPositions;
    }
}
