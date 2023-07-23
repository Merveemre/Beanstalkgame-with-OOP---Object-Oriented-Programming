package Package1;
import java.util.Scanner;

public class Man extends Cell implements Move {
    private int moveCount;
    private int stepCount;
    public Move currentSpecialMove; // Geçerli özel hareket

    public BeanstalkGame game;

    public Man(int x, int y, BeanstalkGame game) {
        super(x, y);
        moveCount = 0;
        stepCount = 0;
        this.game = game;
    }

    @Override
    public char getSymbol() {
        return 'M';
    }

    @Override
    public void performMove() {
        Scanner scanner = new Scanner(System.in);
        moveCount++;
        stepCount++;

        if (stepCount % 10 == 0) {
            if (currentSpecialMove != null) {
                currentSpecialMove.applyMove(this);
                return;
            }

            if (moveCount % 10 == 0) {
                System.out.println("You have unlocked a new move! Select your move:\n1: Run \n2: Slide \n3: Strong Punch \n4: Strong Push \n5: Pull");
                int choice = scanner.nextInt();
                currentSpecialMove = selectSpecialMove();
                if (currentSpecialMove != null) {
                    currentSpecialMove.applyMove(this);
                    return;
                }
            }
        }

        moveMan();
    }

    @Override
    public Move selectSpecialMove() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new Run();
            case 2:
                return new Slide();
            case 3:
                return new StrongPunch();
            case 4:
                return new StrongPush();
            case 5:
                return new Pull();
            default:
                return null;
        }
    }

    @Override
    public void moveMan(int dx, int dy) {

    }

    public void moveMan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the direction (W/A/S/D): ");
        String directionStr = scanner.nextLine().toUpperCase();

        int dx = 0;
        int dy = 0;

        switch (directionStr) {
            case "W":
                dy = -1;
                break;
            case "A":
                dx = -1;
                break;
            case "S":
                dy = 1;
                break;
            case "D":
                dx = 1;
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }

        int newManX = getX() + dx;
        int newManY = getY() + dy;

        if (!game.isWall(newManX, newManY)) { // duvar yoksa
            if (game.isItem(newManX, newManY)) {
                if (game.isPushableItem(newManX, newManY)) { //itilebilecek cisim varsa
                    game.pushItem(newManX, newManY, dx, dy);
                }
            } else {
                game.setX(newManX);
                game.setY(newManY);
            }
        }
    }

    @Override
    public void applyMove(Man man) {
    }
}
