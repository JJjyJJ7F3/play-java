package self.jjjyjj.clean.code.naming.example;

public class Guess {

    public void printGuessStatistics(String candidate, int count) {
        String guessStatistics = new GuessStatisticsMessage().make(candidate, count);
        System.out.println(guessStatistics);
    }
}
