public class Answer {
    public static int totalMove;
    public static int answer(int t, int n) {

        // Your code goes here.
        if (t < n-1) {
            return 0;
        }

        if (t == n-1) {
            return 1;
        }

        int extraMove = t - n;
        if (extraMove == 1) {
            return t;
        }
        // let L = -1, S = 0, R = 1
        totalMove = 0;
        BruteCount(t-1, 0, n-1);
        BruteCount(t, 1, n-1);

        return totalMove;
    }

import java.util.ArrayList;

public class Answer {
    public static int totalMove;
    public static int answer(int t, int n) {

        // Your code goes here.
        if (t < n-1) {
            return 0;
        }

        if (t == n-1) {
            return 1;
        }

        int extraMove = t - n;
        if (extraMove == 1) {
            return t;
        }
        // let L = -1, S = 0, R = 1
        totalMove = 0;
        ArrayList<String> move = new ArrayList<>();
        move.add("stay");
        BruteCount(t-1, 0, n-1, move);
        move.remove(move.size()-1);
        move.add("right");
        BruteCount(t-1, 1, n-1, move);

        return totalMove;
    }

    public static void BruteCount(int moveNum, int state, int dest, ArrayList<String> move) {
        //System.out.println(moveNum + " " + state + " " + dest);
        if (dest == state) {
            System.out.println(moveNum + " " + state + " " + dest);
            System.out.println("Ding!!");
            totalMove++;
            System.out.println(move);
            return;
        }
        if (moveNum == 0) {
            //System.out.println("Busted!");

            return;
        }
        if( !(moveNum-1 < state-dest)) {
            if (!(state - 1 < 0)) {
                move.add("left");
                BruteCount(moveNum - 1, state - 1, dest, move);
                move.remove(move.size()-1);
            }
            if (!(state + 1 > dest)) {
                move.add("right");
                BruteCount(moveNum - 1, state + 1, dest, move);
                move.remove(move.size()-1);
            }
            move.add("stay");
            BruteCount(moveNum - 1, state, dest, move);
            move.remove(move.size()-1);
        }
    }

    public static void main(String[] args){
        System.out.println(answer(5, 3));
    }
}

    public static void main(String[] args){
        System.out.println(answer(5, 3));
    }
}