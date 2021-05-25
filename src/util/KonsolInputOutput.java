package util;

import java.util.Scanner;
// Wrapper klasse mhb på unit test af views
public class KonsolInputOutput {

    private Scanner input = new Scanner(System.in);

    public String getNextString() {
        return input.next();
    }

    public int getNextInt() {
        return input.nextInt();
    }

    public void println(String s) {
        System.out.println(s);
    }

    public void printf(String formatString, Object... args) {
        System.out.printf(formatString, args);
    }

    public void print(String s) {
        System.out.print(s);
    }
}
