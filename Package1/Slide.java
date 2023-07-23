package Package1;

import java.util.Scanner;

public class Slide implements Move {
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

        int nextX = man.getX();
        int nextY = man.getY();

        // duvara kadar ilerle
        while (!man.game.isWall(nextX + dx, nextY + dy)) {
            nextX += dx;
            nextY += dy;
        }

        // adamın yeni pozisyonu
        man.moveMan(nextX - man.getX(), nextY - man.getY());
    }

}