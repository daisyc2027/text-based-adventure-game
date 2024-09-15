public class Combat {
    void whoWon(Role hero, Role opponent) {
        while (hero.alive && opponent.alive) {
            hero.currentPlayerAttack(opponent);
            opponent.currentPlayerAttack(hero);
        }
        if (!opponent.alive) {
            System.out.println("You beat " + opponent.name + ".");
        } else {
            System.out.println("Oh no, you died...");
        }
    }
}