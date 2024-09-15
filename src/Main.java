import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome, please input your name: ");
        String username = sc.nextLine();
        Role hero = new Role(username, 80, 15, true);
        Role opponent = new Role("Opponent", 100, 10, false);

        Combat combat = new Combat();
        combat.whoWon(hero, opponent);
    }

}
