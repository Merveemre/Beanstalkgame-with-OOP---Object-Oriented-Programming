package Package1;

public class MapTest {
    public static void main(String[] args) {
        MapReader mapReader = MapReader.getInstance();
        char[][] map = mapReader.getMap();

        if (map != null) {
            System.out.println("Map Contents:");

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Failed to load the map.");
        }
    }
}
