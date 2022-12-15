package JavaProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    private static ArrayList<InputStream> streams = new ArrayList<>();
    private Scanner input;

    public InputHandler() {
        this(System.in);
    }

    public InputHandler(InputStream s) {

        if (streams.contains(s)) {
            throw new IllegalStateException("Existing input-instance assosiated with input stream");
        }
        input = new Scanner(s);
        streams.add(s);
    }

    public int readInt(String text) {
        System.out.print(text + "?>");
        int data = input.nextInt();
        input.nextLine();
        return data;
    }

    public double readDouble(String text) {
        System.out.print(text + "?>");
        double data = input.nextDouble();
        input.nextLine();
        return data;
    }

    public String readString(String text) {
        String data = "";
        do {
            System.out.print(text + "?>"); //* */
            data = input.nextLine().trim();
            if (data.isBlank())
                System.out.println("ERROR WRONG INPUT TRY AGAIN");

        } while (data.isBlank());
        return data;
    }
}