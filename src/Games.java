import java.util.Scanner;
public class Games {
    Scanner sc = new Scanner(System.in);

    String playRockPaperScissorsGame(){
        System.out.println("Lets play rock paper scissors. Rock paper scissors shoot!");
        String userChoice = sc.nextLine();

        while (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
            System.out.println("Please enter a valid argument");
            userChoice = sc.nextLine();
        }

        int computerChoiceIndex = (int) (Math.random()*3);
        int userChoiceIndex = convertingUserChoice(userChoice);

        if(userChoiceIndex == computerChoiceIndex){
            return "tie";

        }
        else if(userChoiceIndex == 0 && computerChoiceIndex == 2
                || userChoiceIndex == 1 && computerChoiceIndex == 0
                || userChoiceIndex == 2 &&  computerChoiceIndex == 1){
            return "player one wins";
        }
        else{
            return "player two wins";
        }

    }
    int convertingUserChoice (String userChoice){
        if (userChoice.equals("rock")) {
            return 0;
        } else if (userChoice.equals("paper")) {
            return 1;
        } else {
            return 2;
        }
    }
    boolean playNumberGuessingGame(){
        int min = 1;
        int max = 10;
        int randomNumber = (int) (Math.random() * ((max + 1) - min) + min);
        System.out.println("Guess a number between 1 and 10.");
        int userGuess = sc.nextInt();
        while(userGuess <= min || userGuess >= max){
            System.out.println("Input a valid guess.");
            userGuess = sc.nextInt();
        }
        return userGuess == randomNumber;
    }
    boolean riddles(){
        String[] riddles =
                {"The More That Is Here, The Less You Will See.",
                        "If Given One, You'll Have Many Or None.",
                        "I Cross The River Without Moving. What Am I?",
                        "I Possess A Father And Mother, But Am No One's Son. Even With Siblings, I Am Brother To None.",
                        "Time Existed Before Me, But History Can Only Begin After My Creation.",
                        "Some Are Cherished, Some Are Hated, And Even If Lost, They Remain With You",};

        String[] riddleAnswers = {
                "darkness",
                "a choice",
                "a bridge",
                "a daughter",
                "writing book",
                "memories"};

        int i = (int)(Math.random()*riddles.length);
        String randomRiddle  = riddles[i];
        String randomRiddleAnswer = riddleAnswers[i];
        String answer = sc.nextLine();
        return randomRiddleAnswer.contains(answer);
    }
}
