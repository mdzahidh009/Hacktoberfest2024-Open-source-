import java.util.Scanner;

public class AsciiArtGenerator {

    // ASCII representation for each letter A-Z (5x5 grid)
    static String[][] alphabet = {
        {" A  ", "A A ", "AAA ", "A A ", "A A "}, // A
        {"BB  ", "B B ", "BB  ", "B B ", "BB  "}, // B
        {" CC ", "C   ", "C   ", "C   ", " CC "}, // C
        {"DD  ", "D D ", "D D ", "D D ", "DD  "}, // D
        {"EEE ", "E   ", "EEE ", "E   ", "EEE "}, // E
        {"FFF ", "F   ", "FFF ", "F   ", "F   "}, // F
        {" GG ", "G   ", "G G ", "G G ", " GG "}, // G
        {"H H ", "H H ", "HHH ", "H H ", "H H "}, // H
        {" I  ", " I  ", " I  ", " I  ", " I  "}, // I
        {"  J ", "   J", "   J", "J  J", " JJ "}, // J
        {"K  K", "K K ", "KK  ", "K K ", "K  K"}, // K
        {"L   ", "L   ", "L   ", "L   ", "LLL "}, // L
        {"M M ", "MMM ", "M M ", "M M ", "M M "}, // M
        {"N N ", "NN N", "N N ", "N N ", "N N "}, // N
        {" O  ", "O O ", "O O ", "O O ", " O  "}, // O
        {"PP  ", "P P ", "PP  ", "P   ", "P   "}, // P
        {" QQ ", "Q  Q", "Q  Q", "Q QQ", " QQ "}, // Q
        {"RR  ", "R R ", "RR  ", "R R ", "R R "}, // R
        {" SS ", "S   ", " SS ", "   S", " SS "}, // S
        {"TTT ", " I  ", " I  ", " I  ", " I  "}, // T
        {"U U ", "U U ", "U U ", "U U ", " UU "}, // U
        {"V V ", "V V ", "V V ", " V  ", " V  "}, // V
        {"W W ", "W W ", "W W ", " W W", " W W"}, // W
        {"X X ", " X  ", " X  ", " X  ", "X X "}, // X
        {"Y Y ", " Y  ", " Y  ", " Y  ", " Y  "}, // Y
        {"ZZZ ", "  Z ", " Z  ", "Z   ", "ZZZ "}  // Z
    };

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Get the word from the user
        System.out.println("Enter a word (A-Z only): ");
        String input = scanner.nextLine().toUpperCase();

        // Validate the input
        if (!input.matches("[A-Z]+")) {
            System.out.println("Invalid input! Please enter only letters A-Z.");
            return;
        }

        // Loop through each row of the ASCII art
        for (int row = 0; row < 5; row++) {
            StringBuilder rowOutput = new StringBuilder();
            
            // Build each letter row by row
            for (char c : input.toCharArray()) {
                int index = c - 'A'; // Calculate the index of the letter in the alphabet array
                rowOutput.append(alphabet[index][row]).append(" "); // Add letter to the row
            }
            System.out.println(rowOutput.toString()); // Print the row
        }

        // Ask the user if they want to animate it
        System.out.println("\nDo you want to see the text animate? (yes/no)");
        String animate = scanner.nextLine().toLowerCase();

        if (animate.equals("yes")) {
            animateAscii(input);
        }

        scanner.close();
    }

    // Function to animate the ASCII text like a wave
    public static void animateAscii(String input) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.print("\033[H\033[2J"); // Clear the screen (works in most terminals)
            System.out.flush();

            // Move the banner up and down
            int offset = (int) (Math.sin(i * 0.3) * 5) + 5;

            for (int j = 0; j < offset; j++) {
                System.out.println();
            }

            // Print the ASCII art again with the current offset
            for (int row = 0; row < 5; row++) {
                StringBuilder rowOutput = new StringBuilder();
                for (char c : input.toCharArray()) {
                    int index = c - 'A';
                    rowOutput.append(alphabet[index][row]).append(" ");
                }
                System.out.println(rowOutput.toString());
            }

            Thread.sleep(200); // Pause for 200 milliseconds to create animation effect
        }
    }
}
