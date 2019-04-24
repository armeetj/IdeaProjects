import java.util.HashMap;
import java.util.Scanner;

public class majority_element1
{
    public static void main(String[] args) throws Exception
    {
        //find the majority element in an array
        //the majority element will be in both halfs of the array if it is majority
        Scanner in = new Scanner(System.in);
        //now read in the input into an array
        int n = in.nextInt();
        Integer max = -1;
        HashMap <Integer,Integer> list = new <Integer, Integer>HashMap();
        list.put(-1,0);
        for(int i = 0; i< n; i++)
        {
            Integer temp = in.nextInt();
//            System.out.println(temp);

            if (list.containsKey(temp))
            {
                list.put(temp, list.get(temp)+1);
                if (list.get(temp) > list.get(max))
                {
                    max=temp;
                }
            }else
             {
                list.put(temp, 1);
                if (list.get(temp) > list.get(max))
                {
                    max = temp;
                }
            }

        }
//        System.out.println(list);
        int temp = list.get(max);
        list.remove(max, temp);
        if (list.containsValue(temp)||temp<=n/2)
        {
            max = -1;
        }

        if (max == -1)
        {
            System.out.println(0);
        }else
        {
            System.out.println(1);
        }
    }
}
