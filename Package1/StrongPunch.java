package Package1;

import java.util.Scanner;

public class StrongPunch implements Move {
    @Override
    public void performMove() {

    }

    @Override
    public Move selectSpecialMove() {
        return null;
    }

    @Override
    public void moveMan(int dx, int dy) {

    }

    @Override
    public void applyMove(Man man) {
        Scanner scanner = new Scanner(System.in);
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

        int nextX = man.getX() + dx;
        int nextY = man.getY() + dy;
        int next2X = man.getX() + (2 * dx);
        int next2Y = man.getY() + (2 * dy);

        // konumda obje var mı kontrol et
        if (man.game.isItem(nextX, nextY)) {
            // objeyi 2 adım itekle
            man.game.moveItem(nextX, nextY, next2X, next2Y);
        } else {
            System.out.println("No item to punch!");
        }
    }

}
