package Package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KeyControlsReader {
    private static KeyControlsReader instance;
    private String upKey;
    private String downKey;
    private String leftKey;
    private String rightKey;

    private KeyControlsReader() {
        loadControlsFromFile();
    }

    public static KeyControlsReader getInstance() {
        if (instance == null) {
            instance = new KeyControlsReader();
        }
        return instance;
    }

    public String getUpKey() {
        return upKey;
    }

    public String getDownKey() {
        return downKey;
    }

    public String getLeftKey() {
        return leftKey;
    }

    public String getRightKey() {
        return rightKey;
    }

    private void loadControlsFromFile() {
        String filePath = "C:\\Users\\Merveler\\Desktop\\IKCU Yazilim\\Nesne Yönelimli Analiz ve Tasarım\\MerveEmreY220240194\\src\\key_controls.txt";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            upKey = scanner.nextLine();
            downKey = scanner.nextLine();
            leftKey = scanner.nextLine();
            rightKey = scanner.nextLine();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: key_controls.txt file not found!");
        }
    }
}