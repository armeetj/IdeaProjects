import java.util.*;
public class Creditcard
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);

    while(true)
    {
      System.out.print("Enter in a credit card number: ");
      long input = scanner.nextLong();
      System.out.println(sumOfOddPlace(input));
      System.out.println(getPrefix(input, 3));
    }

  }

  /** Return the sum of the odd-place digits */
  public static int sumOfOddPlace(long number)
  {
    String numberString = Long.toString(number);
    int sum = 0;
    for(int i = numberString.length()-2; i >= 0; i = i)
    {
      int digit = getDigit(2 * Integer.parseInt((Character.toString(numberString.charAt(i)))));
      sum += digit;
      System.out.println(digit);

      if (i - 2 >= 0)
      {
        i-=2;
      }
    }
    return sum;
  }

  /** Return the given number if it is a single digit,
   *  otherwise return the sum of the two digits */
  public static int getDigit(int n)
  {
    if(n < 10)
    {
      return n;
    }

    int digit1 = Integer.parseInt(Character.toString(
            Integer.toString(n).charAt(0)));
    int digit2 = Integer.parseInt(Character.toString(
            Integer.toString(n).charAt(1)));

    return digit1 + digit2;
  }

  /** Return the number of digits in the given number */
  public static int getSize(long number)
  {
    return Long.toString(number).length();
  }

  /** Return the first k number of digits from number. If the
   *  number of digits in number is less than k, return number. */
  public static long getPrefix(long number, int k)
  {
    String numberString = Long.toString(number);
    if(numberString.length() < k)
    {
      return Long.parseLong(numberString);
    }

    return Long.parseLong(numberString.substring(0, k));
  }



  /** Return true if d is a prefix for number */
  public static boolean prefixMatched(long number, int d)
  {
    String dString = Integer.toString(d);
    return (getPrefix(number, dString.length()) == d);
  }

  //given a long, return the nth digit from the left
  public static int getNthDigit(long number, int n)
  {
    return Integer.parseInt(Character.toString(Long.toString(number).charAt(n)));
  }
}
