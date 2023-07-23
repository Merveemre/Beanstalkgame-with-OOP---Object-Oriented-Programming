package Package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharactersReader {
    private static CharactersReader instance;
    private final Map<Character, String> characterSymbols;

    private CharactersReader() {
        characterSymbols = new HashMap<>();
        loadCharacterSymbolsFromFile();
    }

    public static CharactersReader getInstance() {
        if (instance == null) {
            instance = new CharactersReader();
        }
        return instance;
    }

    public String getCharacterSymbolMeaning(char character) {
        String meaning = characterSymbols.get(character);
        String symbol = Character.toString(character);
        return meaning != null ? symbol + ": " + meaning : symbol;
    }



    private void loadCharacterSymbolsFromFile() {
        try {
            File file = new File("C:\\Users\\Merveler\\Desktop\\IKCU Yazilim\\Nesne Yönelimli Analiz ve Tasarım\\MerveEmreY220240194\\src\\character_symbols.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() >= 2) {
                    char symbol = line.charAt(0);
                    String meaning = line.substring(2);
                    characterSymbols.put(symbol, meaning);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
