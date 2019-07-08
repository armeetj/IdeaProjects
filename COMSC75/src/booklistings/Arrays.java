//Armeet Singh Jatyani
//LockerPuzzle
public class Arrays
{
  public static void main(String[] args)
  {
    final int NUM_OF_LOCKERS = 100;
    final int NUM_OF_STUDENTS = 100;
    boolean[] lockers = new boolean[NUM_OF_LOCKERS];

    for (int student = 1; student <= NUM_OF_STUDENTS; student++)
    {
      for (int j = student - 1; j < NUM_OF_LOCKERS; j += student)
      {
        lockers[j] = lockers[j] == false;
      }
    }

    for(int i = 0; i < NUM_OF_LOCKERS; i++)
    {
      if (lockers[i])
      {
        System.out.print(i + 1);
        System.out.print(" ");
      }
    }

  }
}
