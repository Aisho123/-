import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {
        LinkedQueue<String> s= new LinkedQueue<>();
        Scanner in= new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.println("1 enqueue name 2 dequeue name" +
                    " 3 show first" +
                    "4 queue size 5 is the queue empty 6 view all  ");
            choice= in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("input a name to insert it");
                    s.enqueue(in.next());
                   // System.out.println(s.first()+ " is added");
                    break;
                case 2:
                    System.out.println(s.dequeue()+ " is removed");
                    break;
                case 3 :
                    System.out.println(s.first()+" is the first name");
                    break;
                case 4:
                    System.out.println(s.size()+ " is the size of the stack");
                    break;
                case 5 :
                    System.out.println("is the queue empty? "+s.isEmpty());
                    break;
                case 6:
                    System.out.print("all queue names are : ");
                    while (!s.isEmpty())
                        System.out.print(s.dequeue()+ "  ");
                    System.out.println();
                    break;
                case 0: System.exit(0);
            }
        }
    }
}
