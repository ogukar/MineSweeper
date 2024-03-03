package MineSweeper;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Start start = new Start();
        System.out.println("write map length");
        int l = in.nextInt();
        System.out.println("write map width");
        int w = in.nextInt();
        start.setLength(l);
        start.setWidth(w);
        start.gameMap();
        //start.xRay();
        int b,a;
        do {
            System.out.println("choose vertical");
            b = in.nextInt();
            System.out.println("choose horizontal");
            a = in.nextInt();
        } while (start.gameBoard(b-1, a-1));

    }
}
