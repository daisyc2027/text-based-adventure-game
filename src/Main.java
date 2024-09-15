import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome, please input your name: ");
        String username = sc.nextLine();
        Role hero = new Role(username, 80, 15, true);
        Role opponent = new Role("Opponent", 100, 10, false);

        while (hero.alive && opponent.alive){
            hero.currentPlayerAttack(opponent);
            opponent.currentPlayerAttack(hero);
        }
        if(!opponent.alive) {
            System.out.println("You beat " + opponent.name + ".");
        }
        else{
            System.out.println("Oh no, you died...");
        }
    }
}