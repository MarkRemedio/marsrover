public class Rover {
    private int x;
    private int y;
    private char direction;

    public Rover() {
        this.x = 0;
        this.y = 0;
        this.direction = 'N';
    }

    public String processInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction:" + instruction);
            }
        }
        return this.getPosition();
    }

    private String getPosition() {
        return x + "," + y + "," + direction;
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    private void move() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                if(y > 0) {
                    y--;
                }
                break;
            case 'W':
                if(x > 0) {
                    x--;
                }
                break;
        }
    }
}
