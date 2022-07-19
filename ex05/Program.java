package ex05;

public class Program {

    public static void main(String[] args) {
        String profile = args[0];

        Menu menu = new Menu(profile);
        menu.start();
    }
}
