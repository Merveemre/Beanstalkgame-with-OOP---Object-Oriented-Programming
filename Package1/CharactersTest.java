package Package1;

public class CharactersTest {
    public static void main(String[] args) {
        testCharacterSymbols();
    }

    private static void testCharacterSymbols() {
        CharactersReader characters = CharactersReader.getInstance();

        // Karakterleri doğru şekilde okuyup okumadığını test etme
        System.out.println(characters.getCharacterSymbolMeaning('M'));
        System.out.println(characters.getCharacterSymbolMeaning('S'));
        System.out.println(characters.getCharacterSymbolMeaning('B'));
        System.out.println(characters.getCharacterSymbolMeaning('X'));
        System.out.println(characters.getCharacterSymbolMeaning('F'));
        System.out.println(characters.getCharacterSymbolMeaning('H'));
        System.out.println(characters.getCharacterSymbolMeaning('#'));
    }


}
