package bzh.breizhhardware.tp.tp3;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();

        Animation a1 = new Animation(window.okLabel, "ABCDEF", 500);
        a1.start();
        Animation a2 = new Animation(window.cancelLabel, "123456", 250);
        a2.start();

        BoundingBallsWindow boundingBallsWindow = new BoundingBallsWindow();
    }
}
