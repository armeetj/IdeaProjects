//Armeet Singh Jatyani
//LockerPuzzle
/*
  In this problem we have 100 lockers that start out closed.
  There are 100 students and 100 lockers. The Nth student starts at the
  Nth locker and toggles the state of every Nth locker. This means, that
  if he sees an open locker he will close it, and if he sees a closed
  locker, he opens it.
*/

public class LockerPuzzle
{
  public static void main(String[] args)
  {
    //declare constants
    final int NUM_OF_LOCKERS = 100;
    final int NUM_OF_STUDENTS = 100;

    //define the lockers array
    boolean[] lockers = new boolean[NUM_OF_LOCKERS];

    //go through each student
    for (int student = 1; student <= NUM_OF_STUDENTS; student++)
    {
      //start at the jth locker and increment by the name of the student
      for (int j = student - 1; j < NUM_OF_LOCKERS; j += student)
      {
        //if the locker is open, close it
        //if the locker is closed, open it
        lockers[j] = !lockers[j];
      }
    }

    //now print out all the open lockers
    for(int i = 0; i < NUM_OF_LOCKERS; i++)
    {
      //if true print the locker with a space
      if (lockers[i])
      {
        System.out.print(i + 1);
        System.out.print(" ");
      }
    }
  }
}
