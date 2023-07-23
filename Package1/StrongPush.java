package Package1;

import java.util.Scanner;

public class StrongPush implements Move {
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

        // Konumda cisim var mı kontrol et
        if (man.game.isItem(nextX, nextY) && man.game.isItem(next2X, next2Y)) {
            // yanyana 2 cisimi itekle
            man.game.moveItem(nextX, nextY, nextX + dx, nextY + dy);
            man.game.moveItem(next2X, next2Y, next2X + dx, next2Y + dy);
        } else {
            System.out.println("Cannot perform Strong Push!");
        }
    }


}
