import java.util.Scanner;
import java.util.Vector;

public class trainmain {
    
    public static void main(String[] args) {
        int t_no, s_no, b_no;
        Vector<Railwaymanagment> t = new Vector<>();
        int s;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.Add Train    2.Show all trains \n 3.Show ava tickits for 1 train  ");
            System.out.println("Enter Choice");
            s = sc.nextInt();
            switch (s) {
                case 1:
                    System.out.println("Enter Train no:");
                    t_no = sc.nextInt();
                    System.out.println("Enter No of seats:");
                    s_no = sc.nextInt();
                    System.out.println("Enter no of booked tickets:");
                    b_no = sc.nextInt();
                    System.out.println("==========================");
                    t.add(new Railwaymanagment(t_no, s_no, b_no));
                    System.out.println("Train Added");
                    break;
                case 2:
                    System.out.println("All Trains are below:");
                    for (Train trains : t) {
                        System.out.println(
                                trains.givetick());
                        System.out.println("==========================");
                    }
                    break;
                case 3:
                    System.out.println("Enter Train Id");
                    int id;
                    id = sc.nextInt();
                    for (Train trains : t) {
                            
                            if (trains.train_no==id) {
                               System.out.println( trains.getavatick());
                            }
                        System.out.println("==========================");
                    }
                    

                default:
                    break;
            }
        } while (s < 4);

    }

  

}
    

