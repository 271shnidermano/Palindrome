/*A palindrome is a sentence that reads the same forward and backward. For example, "Are we not drawn onward, we few, drawn onward to 
new era?" is a palindrome. Stacks and queues are useful way to check for palindromes. Write a Palindrome class that has a static 
method boolean isPalindrome(String s)that uses stacks and/or queues to determine if the given string is a palindrome. 

Note that punctuation (commas, question marks, etc.) and white spaces between words are ignored, and it should not matter
 if the letters are uppercase or lowercase.

A helpful tool will be to use a StringTokenizer, which breaks strings up into words (tokens) using standard punctuation to
 delimit each word. Here is an example of a StringTokenizer that processes a String named input into tokens:

StringTokenizer t = new StringTokenizer(input, ".,;:'? \t\n\r");

//work with one token (word) at a time
//punctuation marks or spaces not included
while (t.hasMoreTokens())
{
   String str = t.nextToken();
   for(int i = 0; i < str.length(); i++)
   {
      String c = Character.toString(str.charAt(i));

 

            .... then process each character from here


Note that you will have to import java.util.StringTokenizer; in order to use one in your code. */
import java.util.Scanner;
import java.util.StringTokenizer;
public class Palindrome
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your phrase you would like to check as a palindrome? ");
        System.out.print(isPalindrome(input.nextLine()));
        input.close();
    }
    public static boolean isPalindrome(String input)
    {
        StringTokenizer t = new StringTokenizer(input, ".,;:'? \t\n\r");
        ArrayQueue<String> checkQ = new ArrayQueue<>();
        ArrayStack<String> checkS = new ArrayStack<>();
        //work with one token (word) at a time
        //punctuation marks or spaces not included
        while (t.hasMoreTokens())
        {
        String str = t.nextToken();
        for(int i = 0; i < str.length(); i++)
        {
            String c = Character.toString(str.charAt(i));
            checkQ.add(c);
            checkS.push(c);
        }
        }
        while (!checkQ.empty())
        {
            String Qresult = checkQ.remove();

            String Sresult = checkS.pop();

            if(!(Qresult.equalsIgnoreCase(Sresult)))
            {
                return false;
            }
        }
        return true;
    }
}
