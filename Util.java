package util;

import pojo.Board;
import pojo.Ladder;
import pojo.Snack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {

    public static String CheckParameters(Board board) {

        StringBuilder errormsg = new StringBuilder();
        for(Snack snack : board.getSnacks()) {

            for(Ladder ladder : board.getLadders()) {

                if(ladder.getHead() == snack.getHead() || ladder.getHead() == snack.getTail() || ladder.getTail() == snack.getHead() || ladder.getTail() == snack.getHead()) {
                    errormsg.append("Snack and Ladder can not be at same position : Ladder : " + ladder.getHead() + "," + ladder.getTail() + " Snack : " + snack.getHead() + ", " + snack.getTail());
                }
            }
        }

        for(Snack snack : board.getSnacks()) {

            if(snack.getHead() == 1) {
                errormsg.append("Snack ccan not be at position 1");
            }
            if(snack.getHead() == snack.getTail()) {
                errormsg.append("Snack's head and tail can not be same");
            }
        }

        for(Ladder ladder : board.getLadders()) {

            if(ladder.getHead() == 1) {
                errormsg.append("Ladder ccan not be at position 1");
            }
            if(ladder.getHead() == ladder.getTail()) {
                errormsg.append("Ladder's head and tail can not be same");
            }
        }


        ArrayList<Integer> head = new ArrayList<Integer>();

        for(Snack snack : board.getSnacks()) {
            head.add(snack.getHead());
        }
        Collections.sort(head);

        int cnt = 1;
        for(int i=1; i<head.size(); i++) {
            if(head.get(i) == head.get(i-1) + 1) cnt++;
            else cnt = 1;
            if(cnt == 6) {
                errormsg.append("Given snacks positions is not valid");
                break;
            }
        }

        return errormsg.toString();
    }
}
