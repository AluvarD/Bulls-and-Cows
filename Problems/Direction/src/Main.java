import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String direction;
        int directionNumber = scanner.nextInt();
        switch (directionNumber) {
            case 1:
                direction = "move up";
                break;
            case 2:
                direction = "move down";
                break;
            case 3:
                direction = "move left";
                break;
            case 4:
                direction = "move right";
                break;
            case 0:
                direction = "do not move";
                break;
            default:
                direction = "error!";
        }
        System.out.println(direction);
    }
}