package JavaProject;

public class SpaceInvader {
    private final static int width = 31;
    private final static int height = 29;
    private int step = 1;
    private int x, y;

    public SpaceInvader(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {

        if (x > 0 && x < width) {
            x += step;
        } else {

            if (step > 0 && x == width) {
                y++;

                step *= -1;
            } else {
                x += step;
            }

            if (step < 0 && x == 0) {
                y++;

                step *= -1;
            } else {
                x += step;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
