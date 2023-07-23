package Package1;

public class Goal extends Cell {
    private final char symbol;

    public Goal(int x, int y) {
        super(x, y);
        this.symbol = 'X';
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }
}
