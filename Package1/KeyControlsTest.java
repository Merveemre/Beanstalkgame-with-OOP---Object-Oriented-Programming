package Package1;

public class KeyControlsTest {
    public static void main(String[] args) {
        testKeyControls();
    }

    private static void testKeyControls() {
        KeyControlsReader keyControls = KeyControlsReader.getInstance();

        // Kontrol tuşlarını doğru şekilde döndürüp döndürmediğini test etme
        System.out.println("Up Key: " + keyControls.getUpKey());
        System.out.println("Down Key: " + keyControls.getDownKey());
        System.out.println("Left Key: " + keyControls.getLeftKey());
        System.out.println("Right Key: " + keyControls.getRightKey());
    }
}
