package common;

public enum Direction{
    UP(-1, 0, 'u'),
    DOWN(1, 0, 'd'),
    LEFT(0, -1, 'l'),
    RIGHT(0, 1, 'r');

    Direction(int xChange, int yChange) {
        this.xChange = xChange;
        this.yChange = yChange;
    }

    Direction(int xChange, int yChange, char signal) {
        this.xChange = xChange;
        this.yChange = yChange;
        this.signal = signal;
    }

    public int getxChange() {
        return xChange;
    }

    public int getyChange() {
        return yChange;
    }


    public char getSignal() {
        return signal;
    }

    private int xChange;
    private int yChange;
    private char signal;

}