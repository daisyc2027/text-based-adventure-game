import java.util.Scanner;

public class Role {
Scanner sc = new Scanner(System.in);
    String name;
    int health;
    int attackDamage;
    int criticalHit;
    boolean alive;
    boolean playerType;

    Role(String roleName, int roleHealth, int roleAttack, boolean isHuman) {
        name = roleName;
        health = roleHealth;
        attackDamage = roleAttack;
        criticalHit = attackDamage * 2;
        alive = true;
        playerType = isHuman;
    }

    void currentPlayerAttack(Role target) {
        if (alive && target.alive) {
            System.out.print(name + " is attacking " + target.name + "...");
            sc.nextLine();
            if (playerType) {
                int gameType = (int) (Math.random() * 2);

                if (gameType == 0) {
                    Games rps = new Games();
                    String gameResult = rps.playRockPaperScissorsGame();
                    if (gameResult.equals("tie")) {
                        System.out.print("Normal hit");
                        sc.nextLine();
                        attackSuccess(target, attackDamage);
                    } else if (gameResult.equals("player one wins")) {
                        System.out.print("Critical hit!");
                        sc.nextLine();
                        attackSuccess(target, criticalHit);
                    } else {
                        System.out.print("You missed!");
                        sc.nextLine();
                    }
                } else {
                    Games numGuessGame = new Games();
                    boolean winOrLose = numGuessGame.playNumberGuessingGame();
                    if (winOrLose) {
                        System.out.println("K.O!");
                        attackSuccess(target, target.health);
                    } else {
                        System.out.println("You missed!");
                    }
                }
            }
            else{
                computerAttack(target);
            }
        }
    }
    void attackSuccess(Role target, int attack){
        target.health -= attack;
        if(target.health > 0) {
            System.out.print("The attack caused " + attack + " damage on " + target.name + ", "
                    + target.name + " has " + target.health + " health left.");
            sc.nextLine();
        }
        else{
            alive = false;
        }
    }
    void computerAttack(Role target){
        int randomNumber = (int) (Math.random()*5);
        if(randomNumber>= 0 && randomNumber <=2){
            System.out.print("Normal hit ");
            attackSuccess(target, attackDamage);
        }
        else if(randomNumber == 4){
            System.out.print("Critical hit! ");
            attackSuccess(target, criticalHit);
        }
        else{
            System.out.print(name + " missed! ");
        }


    }

}
