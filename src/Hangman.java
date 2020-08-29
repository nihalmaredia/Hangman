import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
    String secretWord;
    StringBuilder Guess;
    ArrayList<Character> lastGuess = new ArrayList<>();

    int maximumTries = 6;
    int yourTry = 0;

    ArrayList<String> words = new ArrayList<>();

    public Hangman() throws IOException {
        initializeStream();
        secretWord = selectWord();
        Guess = loadCurrentGuess();
    }

    public void initializeStream() throws IOException {
        File inFile = new File("words.txt");
        FileReader fileReader = new FileReader(inFile);
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);
        String currentLine = bufferedFileReader.readLine();
        while (currentLine != null) {
            words.add(currentLine);
            currentLine = bufferedFileReader.readLine();
        }
        bufferedFileReader.close();
        fileReader.close();
    }

    public String selectWord() {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt())%words.size();
        return words.get(wordIndex);
    }

    public StringBuilder loadCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i=0;i<secretWord.length()*2;i++) {
            if (i%2 == 0) {
                current.append("_");
            }
            else {
                current.append(" ");
            }
        }
        return current;
    }

    public String getFormalCurrentGuess() {
        return "Current guess: " + Guess.toString();
    }

    public boolean gameover() {
        if (didWeWin()) {
            System.out.println();
            System.out.println("Congratulation. You won the game");
        }
        else if (didWeLose()) {
            System.out.println();
            System.out.println("Sorry. You lost the game." +
                              " The secret word was: " + secretWord + ".");
        }
        return didWeWin() || didWeLose();
    }

    public boolean didWeWin() {
        String guess = getCondensedCurrentGuess();
        return guess.equals(secretWord);
    }

    public String getCondensedCurrentGuess() {
        String guess = Guess.toString();
        return guess.replace(" ", "");
    }

    public boolean didWeLose() {
        return yourTry >= maximumTries;
    }

    public boolean isGuessedAlready(char guess) {
        return lastGuess.contains(guess);
    }

    public boolean playGuess(char guess) {
        boolean isItAGoodGuess = false;
        lastGuess.add(guess);
        for (int i=0;i<secretWord.length();i++) {
            if (secretWord.charAt(i) == guess) {
                Guess.setCharAt(i*2, guess);
                isItAGoodGuess = true;
            }
        }
        if (!isItAGoodGuess) {
            yourTry++;
        }
        return isItAGoodGuess;
    }



    }

