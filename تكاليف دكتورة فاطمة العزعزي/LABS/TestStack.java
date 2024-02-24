import java.util.Scanner;
public class TestStack {
    public static void main(String[] args) {
        LinkedStack<String> s= new LinkedStack<>();
        Scanner in= new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.println("1 push name 2 pop name" +
                    " 3 show top" +
                    "4 stack size 5 is the stack empty 6 view all  ");
            choice= in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("input a name to push it");
                    s.push(in.next());
                    System.out.println(s.top()+ " is added");
                    break;
                case 2:
                    System.out.println(s.pop()+ " is removed");
                    break;
                case 3 :
                    System.out.println(s.top()+" is the top name");
                    break;
                case 4:
                    System.out.println(s.size()+ " is the size of the stack");
                    break;
                case 5 :
                    System.out.println("is the stack empty? "+s.isEmpty());
                    break;
                case 6:
                    System.out.print("all stack names are : ");
                    while (!s.isEmpty())
                        System.out.print(s.pop()+ "  ");
                    System.out.println();
                    break;
                case 0: System.exit(0);
            }
        }
    }
}
