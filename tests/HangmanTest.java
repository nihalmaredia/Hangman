import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;


public class HangmanTest {

    public HangmanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of initializeStream method, of class Hangman.
     */
    @Test
    public void testInitializeStream() throws IOException {
        System.out.println("initializeStream");
        Hangman instance = new Hangman();
        instance.initializeStream();
    }



    @Test
    public void testGameover() throws IOException {
        System.out.println("gameover");
        Hangman instance = new Hangman();
        boolean expResult =true;
        boolean result = instance.gameover();
    }
    @Test
    public void testDidWeWin() throws IOException {
        System.out.println("didWeWin");
        Hangman instance = new Hangman();
        boolean expResult = false;
        boolean result = instance.didWeWin();
        assertEquals(expResult, false);
    }


    @Test
    public void testGetCondensedCurrentGuess() throws IOException {
        System.out.println("getCondensedCurrentGuess");
        Hangman instance = new Hangman();
        String expResult = "correct";
        String result = instance.getCondensedCurrentGuess();

    }


    @Test
    public void testDidWeLose() throws IOException {
        System.out.println("didWeLose");
        Hangman instance = new Hangman();
        boolean expResult = instance.didWeWin();
        boolean result = instance.didWeLose();
    }


    @Test
    public void testIsGuessedAlready() throws IOException {
        System.out.println("isGuessedAlready");
        char guess = ' ';
        Hangman instance = new Hangman();
        boolean expResult = true;
        boolean result = instance.isGuessedAlready(guess);
        assertEquals(expResult, true);
    }


    @Test
    public void testPlayGuess() throws IOException {
            System.out.println("playGuess");
            char guess = ' ';
            Hangman instance = new Hangman();
            boolean expResult = false;
            boolean result = instance.playGuess(guess);
            assertEquals(expResult, result);
        }




        }