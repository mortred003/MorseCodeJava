package morsecode;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
public class MorseCodeConverter {
    private static final Map<Character, String> TEXT_TO_MORSE = new HashMap<>();
    private static final Map<String, Character> MORSE_TO_TEXT = new HashMap<>();

    static {
        // Define Morse Code Mappings
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < letters.length; i++) {
            TEXT_TO_MORSE.put(letters[i], morse[i]);
            MORSE_TO_TEXT.put(morse[i], letters[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Text to Morse code - press 1 | Morse code to text - press 2: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Enter text to convert to Morse code: ");
            String inputText = scanner.nextLine().toUpperCase();
            String morseCode = textToMorse(inputText);
            System.out.println("Text to Morse Code: " + morseCode);
        } else if (choice.equals("2")) {
            System.out.print("Enter Morse code (separate letters with spaces): ");
            String inputMorse = scanner.nextLine();
            String decodedText = morseToText(inputMorse);
            System.out.println("Morse Code to Text: " + decodedText);
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        scanner.close();
    }

    public static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (TEXT_TO_MORSE.containsKey(c)) {
                morse.append(TEXT_TO_MORSE.get(c)).append(" ");
            } else {
                morse.append(" "); // Spaces remain spaces
            }
        }
        return morse.toString().trim();
    }

    public static String morseToText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] morseWords = morseCode.split(" ");
        for (String morse : morseWords) {
            if (MORSE_TO_TEXT.containsKey(morse)) {
                text.append(MORSE_TO_TEXT.get(morse));
            } else {
                text.append(" "); // Spaces between words
            }
        }
        return text.toString();
    }
}