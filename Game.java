public class Game {
    private Player winner;
    public Player p1;
    public Player p2;
    public Board board;
    private int nextMoveBy;

    Game(String name1, String name2) {
        this.winner = null;
        this.p1 = new Player(name1);
        this.p2 = new Player(name2);
        this.board = new Board();
        this.nextMoveBy = 0;
    }

    public Player checkWinner() {
        return winner;
    }

    public void startGame() {
        System.out.println("Starting the game");
        while (winner == null) {

            int dice = board.throwDice();
            // Player p1 chance
            if (nextMoveBy == 0 && p1.getSkip() == 0) {
                System.out.println(p1.getName() + " threw " + dice + " on dice");
                int newPosition = p1.getPosition() + dice;
                newPosition = board.checkLadder(newPosition);
                newPosition = board.checkSnake(newPosition);
                boolean skip = board.checkSkip(newPosition);

                if (newPosition <= 100) {
                    p1.setPosition(newPosition);
                }

                System.out.println(p1.getName() + "\'s new position is " + p1.getPosition());
                if (skip) {
                    System.out.println("X:" + p1.getName() + " landed on skip tile, next 3 chances will be skipped");
                    p1.setSkip();
                }
            }

            // Player p2 chance
            else if (nextMoveBy == 1 && p2.getSkip() == 0) {
                System.out.println(p2.getName() + " threw " + dice + " on dice");
                int newPosition = p2.getPosition() + dice;
                newPosition = board.checkLadder(newPosition);
                newPosition = board.checkSnake(newPosition);
                boolean skip = board.checkSkip(newPosition);

                if (newPosition <= 100) {
                    p2.setPosition(newPosition);
                }

                System.out.println(p2.getName() + "\'s new position is " + p2.getPosition());
                if (skip) {
                    System.out.println("X:" + p2.getName() + " landed on skip tile, next 3 chances will be skipped");
                    p2.setSkip();
                }
            } else {
                if (p1.getSkip() > 0) {
                    System.out.println("Skipping " + p1.getName() + "\'s chance");
                    p1.decreaseSkip();
                }

                if (p2.getSkip() > 0) {
                    System.out.println("Skipping " + p1.getName() + "\'s chance");
                    p2.decreaseSkip();
                }
            }

            if (p1.getPosition() == 100) {
                winner = p1;
                System.out.println(p1.getName() + " won the game");
            } else if (p2.getPosition() == 100) {
                winner = p2;
                System.out.println(p2.getName() + " won the game");
            }

            nextMoveBy = (nextMoveBy + 1) % 2;
        }
    }

}
