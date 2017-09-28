//Andrzej Blomberg
//Assignment 4
//2016-04-05
import java.util.*;
public class AndrzejBlombergWordgame
{
    public static void main(String[]args)
    {
      boolean play = true; //gameover = false
      while (play == true) 
      {
        //array of 10 string elements 
        String [] words = {"appendix","boneless","chainsaw","clearance","freelance","oversimplifying","registration","refrigeration", "scrambled", "retaliation"};
        int pickWord = (int)(Math.random()* words.length); //pick a random index in string array
        char[]letterArr = new char[words[pickWord].length()];//array container for letters in the random chosen string with the size of the picked word
        int count = 10; //10 tries 
        boolean flag = false;
        System.out.println("You have " + count + " incorrect guesses left.");
        while(!flag)
        {
          //loop until puzzle is solved
          //if letterInput method returns false you win
          switch(letterInput(words[pickWord],letterArr,count))
          {
            case 0:
              count--;
              System.out.println("You have " + count + " incorrect guesses left.");
              break;
            case 1:
              System.out.println("You have " + count + " incorrect guesses left.");
              break;
            case 2:
              count--;
              System.out.println("You have " + count + " incorrect guesses left.");
              break;
            case 3:
              System.out.print("\n\nYou guessed the word " + words[pickWord] + "!");
              flag = true;
              break;
            case 4:
              System.out.print("\n\nYour have " + count + " guesses the word was " +words[pickWord]+ "! ");
              flag = true;
              break;
          }
        }
        System.out.print("\nDo you want to play again?(Y/N)");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.equalsIgnoreCase("n"))
          play = false;
      }
    }
    //method for guesses
    public static int letterInput(String word, char[] letterArr, int count)
    {
      System.out.print("Guess a letter in the word: " );
      if (count < 1) //if you run out of guesses
      {
        return 4; 
      }
      else if (!printWord(word,letterArr))  //if no stars were printed the word is guessed
      {
        return 3;
      }
      Scanner in = new Scanner(System.in);
      //call findEmptySpot method 
      int foundSpot = findEmptySpot(letterArr);
      char guess = in.next().toLowerCase().charAt(0);
      if(checkForLetter(guess,letterArr))
      {
        return 2;
      }
      else if (word.contains(String.valueOf(guess)))//if you guessed right
      {
        letterArr[foundSpot] = guess;
        return 1; 
      }  
      else //if letter is not in word
      {
        return 0; 
      }
    }
    //print map of word, returns true if stars were printed, otherwise returns false
    public static boolean printWord(String word, char[]letterArr)
    {
      //go through all letter in the word
      boolean star = false;
      for (int i=0;i<word.length();i++)
      {
        char letter = word.charAt(i);
        if(checkForLetter(letter,letterArr))
        {
          System.out.print(letter);
        }
        else
        {
          System.out.print('*');
          star = true;
        }
      }
      return star;
    }
    //method for checking if letter is in array
    public static boolean checkForLetter(char letter, char[]letterArr)
    {
      return new String(letterArr).contains(String.valueOf(letter));
    }
    //method to find first empty spot in array of entered letters 
    public static int findEmptySpot(char[]letterArr)
    {
      int i = 0;
      while (letterArr[i]!='\0') i++;
      return i;
    }
}                             
