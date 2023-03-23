import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        boolean playing = true;
                while (playing) {
                    int die1 = rnd.nextInt(6) + 1;
                    int die2 = rnd.nextInt(6) + 1;
                    int sum = die1 + die2;

                    System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

                    if (sum == 2 || sum == 3 || sum == 12) {
                        System.out.println("Craps, You lose.");
                        playing = promptToPlayAgain(sc);
                    } else if (sum == 7 || sum == 11) {
                        System.out.println("Natural, You win.");
                        playing = promptToPlayAgain(sc);
                    } else {
                        int point = sum;
                        System.out.println("Point is " + point);
                        while (true) {
                            die1 = rnd.nextInt(6) + 1;
                            die2 = rnd.nextInt(6) + 1;
                            sum = die1 + die2;
                            System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

                            if (sum == point) {
                                System.out.println("Made point, You win.");
                                playing = promptToPlayAgain(sc);
                                break;
                            } else if (sum == 7) {
                                System.out.println("Seven, You lose.");
                                playing = promptToPlayAgain(sc);
                                break;
                            } else {
                                System.out.println("Trying for point again.");
                            }
                        }
                    }
                }
            }

            private static boolean promptToPlayAgain(Scanner sc) {
                System.out.println("Do you want to play again? (y/n)");
                String answer = sc.next().toLowerCase();
                return answer.equals("y") || answer.equals("yes");
    }
}
