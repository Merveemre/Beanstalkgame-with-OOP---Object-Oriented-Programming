package Package1;
public abstract class Game {
    private int x;
    private int y;

    public Game(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void pushItem(int dx, int dy) {
        int newManX = getX() + dx;
        int newManY = getY() + dy;

        // Yeni konumda itilebilir bir obje var mı kontrol et
        if (isPushableItem(newManX, newManY)) {
            // İtemi itme işlemini gerçekleştir
            int newItemX = newManX + dx;
            int newItemY = newManY + dy;
            moveItem(newManX, newManY, newItemX, newItemY);

            // Adamın konumunu güncelle
            setX(newManX);
            setY(newManY);
        } else {
            // İtme işlemi yapılamıyorsa sadece adamın konumunu güncelle
            setX(newManX);
            setY(newManY);
        }
    }

    public abstract boolean isPushableItem(int newManX, int newManY);

    public abstract void moveItem(int newManX, int newManY, int newItemX, int newItemY);

    public abstract void pushItem(int newManX, int newManY, int dx, int dy);

    public void play() {
    }
}
