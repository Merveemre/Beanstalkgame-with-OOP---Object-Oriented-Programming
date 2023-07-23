package Package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapReader {
    private static MapReader instance;
    private char[][] map;

    private MapReader() {
        loadMapFromFile();
    }

    public static MapReader getInstance() {
        if (instance == null) {
            instance = new MapReader();
        }
        return instance;
    }

    public char[][] getMap() {
        return map;
    }

    private void loadMapFromFile() {
        String filePath = "C:\\Users\\Merveler\\Desktop\\IKCU Yazilim\\Nesne Yönelimli Analiz ve Tasarım\\MerveEmreY220240194\\src\\map.txt";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int numRows = 0;
            int numColumns = 0;

            // Haritanın boyutlarını belirle
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                numColumns = Math.max(numColumns, line.length());
                numRows++;
            }

            map = new char[numRows][numColumns];

            //  Tarayıcıyı dosyanın başından okumak için sıfırla
            scanner = new Scanner(file);

            // Haritayı dizide depola
            int row = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int col = 0; col < line.length(); col++) {
                    map[row][col] = line.charAt(col);
                }
                row++;
            }

            scanner.close();

            System.out.println("Map Dimensions: " + numRows + "x" + numColumns);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load the map.");
            e.printStackTrace();
        }
    }
}