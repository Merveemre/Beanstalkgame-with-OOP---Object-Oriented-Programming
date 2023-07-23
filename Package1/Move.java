package Package1;

public interface Move {
    void performMove();
    Move selectSpecialMove();
    void moveMan(int dx, int dy);
    void applyMove(Man man);

}
