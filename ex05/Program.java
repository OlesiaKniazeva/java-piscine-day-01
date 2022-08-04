package ex05;

public class Program {

    public static void main(String[] args) {
        if (args.length != 1 || !(args[0].equals("--profile=dev") || args[0].equals("--profile=production"))) {
            System.out.println("Wrong profile argument");
            return;
        }
        String profile = args[0].substring(args[0].indexOf('=') + 1);

        Menu menu = new Menu(profile);
        menu.start();
    }
}
