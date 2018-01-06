//Kelly Catbagan
//CSIS 1400
//Koziatek

//ASSUMPTIONS
//1.User enters lowercase letter


import java.lang.*;
import java.util.*;

public class Hangman
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean win = false;
        boolean lose = false;
        int count = 1;

        //displays available letter guesses
        char [] letters = alphabet().toCharArray();
        System.out.print("	");
        for(char i: letters)
            System.out.print(i + " ");

        //displays gallows and body
        gallowsAndBody(count);

        //selects random word for game
        String guessWord = randomWordFromArray();

        //displays underscores of random word
        char [] guessArray = randomWordToUnderScore(guessWord);

        //prompts user for guess entry until win or loss
        while(!win && !lose)
        {
            boolean goodGuess = false;
            char[] oldGuessArray = guessArray;
            char [] oldAlphabetArray = letters;

            // prints out word to be guessed
            System.out.print("\n    ");
            for(int i=0; i<guessArray.length; i++)
                System.out.print(guessArray[i] + " ");

            // prompts user for guess
            System.out.print("\n\n 	Guess a letter: ");
            char guess = scan.next(".").charAt(0);	

            // updates guess array and alphabet array
            guessArray = updateGuess(guessWord, guessArray, guess);
            letters = updateAlphabet(oldAlphabetArray, guess);

            // checks guess
            if (!(checkGuess(guessWord, guessArray, guess)))
                count++;

            // prints out current game
            System.out.println("\n\n\n");
            System.out.print("	");
            for (char i: letters)
                System.out.print(i + " ");

            System.out.println("\n");
            gallowsAndBody(count);

            //checks for win or lose
            win = checkWin(guessArray, guessWord); 
            lose = (count >= 8); 
        }

        // resolve win/loss 
        if(win)
        {
            System.out.println("YOU WIN!");
        }    
        else if (lose)
        {
        explode(guessWord);
        } 
    }

    public static String alphabet()
    {
        //creates alphabet string for game display
	String alphabet = "abcdefghijklmnopqrstuvwxyz";

	return alphabet;
    }

    public static String randomWordFromArray()
    {
        String [] words = new String[5];

	words[0] = "javascript";
	words[1] = "declaration";
	words[2] = "object";
	words[3] = "class";
	words[4] = "failing";

	Random random = new Random();

	//selects random element from array of words
	String randomWord = words[(int)(Math.random() * words.length)];

	return randomWord;
    }
	
    public static char [] randomWordToUnderScore(String word)
    {
	//splits random word into array of letter elements
	char [] underScoreWord = word.toCharArray();

	//replaces array value at i to underscores
	for (int i = 0; i < underScoreWord.length; i++)
            underScoreWord[i] = ('_');	

	return underScoreWord;
    }

    public static char [] updateAlphabet(char [] oldArray, char guess)
    {
        char [] newAlphabetArray = oldArray;

	for (int i = 0; i < oldArray.length; i++)
	{
            if (oldArray[i] == guess)
		newAlphabetArray[i] = '_';
	}

	return newAlphabetArray;
    }
	
    public static char [] updateGuess(String word, char [] guessList, char guess)
    { 	
        //updated guess list starts off as previous guess list

	char [] newGuessList = guessList;
	char [] charWord = word.toCharArray();

	for(int i = 0; i < guessList.length; i++)
	{
            if (charWord[i] == guess)
                newGuessList[i] = guess;
	}

	return newGuessList;
    }

    public static boolean checkGuess(String word, char [] guessList, char guess)
    { 
        char [] newGuessList = guessList;
	char [] charWord = word.toCharArray();

	for(int i = 0; i < guessList.length; i++)
	{
            if (charWord[i] == guess)
            {
		return true;
            }
	}
	return false;
    }

    public static boolean checkWin(char[] newGuessList, String word)
    {	
	//compares items to check if equal
	char[] charWord = word.toCharArray();
	for(int i = 0; i < charWord.length; i++) 
	{
            if (charWord[i] != newGuessList[i])
		return false;
	}
	return true;
    }
	
    public static void explode(String word)
    {
        //prints letters of random word is user loses
	char [] explodeWord = word.toCharArray();

	System.out.print("You Lose! The correct letters are: ");

	for(char i: explodeWord)
            System.out.print("'" + i + "'" + " ");

	System.out.println("");
    }
	

    public static void gallowsAndBody(int number) //number == count
    {
        String body;
	switch(number)
	{
            case 1: body = "\n" +
                           "	--------------" + "\n" +
                           "	|            |" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n\n";
                           break;

            case 2: body = "\n" +
                           "	--------------" + "\n" +
                           "	|            |" + "\n" +
                           "	|            O" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n\n";
                           break;

            case 3: body = "\n" +
                           "	--------------" + "\n" +
                           "	|            |" + "\n" +
                           "	|            O" + "\n" +
                           "	|            |" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n\n";
                           break;

            case 4: body = "\n" +
                           "	--------------" + "\n" +
                           "	|            |" + "\n" +
                           "	|            O" + "\n" +
                           "	|            |" + "\n" +
                           "	|            |" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n\n";
                           break;

            case 5: body = "\n" +
                           "	--------------" + "\n" +
                           "	|            |" + "\n" +
                           "	|            O" + "\n" +
                           "	|           /|" + "\n" +
                           "	|            |" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n\n";
                            break;

            case 6: body = "\n" +
                           "	--------------" + "\n" +
                           "	|            |" + "\n" +
                           "	|            O" + "\n" +
                           "	|           /|\\" + "\n" +
                           "	|            |" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n\n";
                           break;

            case 7: body = "\n" +
			"	--------------" + "\n" +
			"	|            |" + "\n" +
			"	|            O" + "\n" +
			"	|           /|\\" + "\n" +
			"	|            |" + "\n" +
			"	|           /" + "\n" +
			"	|" + "\n" +
			"	|" + "\n" +
			"	|" + "\n" +
			"	|" + "\n\n";
						  break;

            case 8: body = "\n" +
                           "	--------------" + "\n" +
                           "	|            |" + "\n" +
                           "	|            O" + "\n" +
                           "	|           /|\\" + "\n" +
                           "	|            |" + "\n" +
                           "	|           / \\" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n" +
                           "	|" + "\n\n";
                           break;
			
            default: body = "Invalid";
                           break;
	}
	System.out.print(body);
    }

    
}
