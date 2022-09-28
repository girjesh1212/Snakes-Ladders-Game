import java.util.Random;

public class Board {
    private int[] ladder_from;
    private int[] ladder_to;

    private int[] snake_from;
    private int[] snake_to;

    private int[] skip;

    Board() {
        this.ladder_from = new int[] { 7, 9, 21, 36, 41, 44, 50, 61, 66, 67 };
        this.ladder_to = new int[] { 26, 55, 97, 64, 94, 65, 92, 98, 86, 88 };
        this.snake_from = new int[] { 32, 43, 46, 52, 58, 62, 73, 91, 95, 99 };
        this.snake_to = new int[] { 5, 17, 15, 11, 24, 22, 3, 51, 65, 10 };
        this.skip = new int[] { 18, 34, 56, 70, 82 };
    }

    public int throwDice() {
        Random rand = new Random();
        return 1 + rand.nextInt(6);
    }

    public int checkLadder(int position) {
        for (int i = 0; i < ladder_from.length; i++) {
            if (ladder_from[i] == position) {
                System.out.println("# Climbing ladder from " + ladder_from[i] + " to " + ladder_to[i]);
                return ladder_to[i];
            }
        }
        return position;
    }

    public int checkSnake(int position) {
        for (int i = 0; i < snake_from.length; i++) {
            if (snake_from[i] == position) {
                System.out.println(" ~ Eaten by snake from " + snake_from[i] + " to " + snake_to[i]);
                return snake_to[i];
            }
        }
        return position;
    }

    public boolean checkSkip(int position) {
        for (int i = 0; i < skip.length; i++) {
            if (skip[i] == position) {
                return true;
            }
        }
        return false;
    }
}
