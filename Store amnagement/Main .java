import java.util.*;


class Main {

	public static void main(String[] args) {
		int noofitem = 0,c,id,price,total=0;
		ArrayList<MenuItem> m=new ArrayList<>();
		ArrayList<Integer> cart = new ArrayList<>();
		boolean ava;
		String Name;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1.Add Item    2.Display all Items \n 3.Add to cart 4.Total Price of cart ");
			System.out.println("Choose Option:");
			c=sc.nextInt();
			switch(c) {
			case 1:
				System.out.println("Enter no of item u wish to add:");
				noofitem=sc.nextInt();
				for(int i=0;i<noofitem;i++) {
					System.out.println("Enter Id:");
					id=sc.nextInt();
					System.out.println("Enter Item Name:");
					Name=sc.next();
					System.out.println("Enter Price:");
					price=sc.nextInt();
					System.out.println("Is it available:");
					ava=sc.nextBoolean();
					System.out.println("_______________________________________________________________");
		
					m.add(new MenuItem(id,Name,price,ava));
					
				}
				break;
			
			case 2:
				for(int i=0;i<noofitem;i++) {
					System.out.println("_______________________________________________________________");
					m.get(i).getdetails();
					System.out.println("_______________________________________________________________");
				}
				break;
			
			case 3:
				System.out.println("Enter The id id item u want to add:");
				id=sc.nextInt();
				cart.add(id);
				break;
			case 4:
				for(int i=0;i<cart.size();i++)
				{
					for(int j=0;j<m.size();j++) {
					
						if(cart.get(j).equals(m.get(i).getid())){
							total+=m.get(i).getprice();
						}
					}
				}
				System.out.println("Total price:"+total);
			
			}
			
			
		}while(c<5);
		sc.close();
	}

}
