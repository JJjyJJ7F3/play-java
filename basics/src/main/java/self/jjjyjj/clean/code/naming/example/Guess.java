package self.jjjyjj.clean.code.naming.example;

public class Guess {

    public void printGuessStatistics(String candidate, int count) {
        String number;
        String verb;
        String pluralModifier;

        if (count == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if (count == 1) {
            number = "one";
            verb = "is";
            pluralModifier = "";
        } else {
            number = String.valueOf(count);
            verb = "are";
            pluralModifier = "s";
        }

        String guessMessage = String.format("There %s %s %s%s.", verb, number, candidate, pluralModifier );
        System.out.println(guessMessage);
    }
}
