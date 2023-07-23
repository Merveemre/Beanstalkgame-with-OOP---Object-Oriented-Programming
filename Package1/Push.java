package Package1;

import java.util.Scanner;

public class Push implements Move {

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

        // Konumda obje var mı kontrol et
        if (man.game.isItem(nextX, nextY)) {
            int nextNextX = nextX + dx;
            int nextNextY = nextY + dy;

            // Hedef konumda duvar var mı kontrol et
            if (man.game.isWall(nextNextX, nextNextY)) {
                System.out.println("Cannot push the item!");
                return;
            }

            // Obje itme işlemi
            man.game.moveItem(nextX, nextY, nextNextX, nextNextY);
        } else {
            System.out.println("No item to push!");
        }
    }
}
