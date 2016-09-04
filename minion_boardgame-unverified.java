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

    public static void BruteCount(int moveNum, int state, int dest) {
        System.out.println(moveNum + " " + state + " " + dest);
        if (dest == state) {
            totalMove++;
            return;
        }
        if (moveNum == 0 || state < 0 || state > dest || moveNum < state-dest) {
            System.out.println("Busted!");
            return;
        }
        BruteCount(moveNum-1, state, dest);
        BruteCount(moveNum-1, state-1, dest);
        BruteCount(moveNum-1, state+1, dest);
    }

    public static void main(String[] args){
        System.out.println(answer(5, 3));
    }
}