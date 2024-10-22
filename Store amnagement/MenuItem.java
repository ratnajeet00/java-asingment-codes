import java.util.*;
public class MenuItem {
	Scanner sc =new Scanner(System.in);
	String Name;
	int Price,Id;
	boolean Ava;
	public MenuItem(int id,String name,int price,boolean ava) {
		Id=id;
		Name=name;
		Price=price;
		Ava=ava;
	}
	
	void getdetails() {
		System.out.println("Id"+Id);
		System.out.println("Item Name:"+Name);
		System.out.println("Price:"+Price);
		System.out.println("Available:"+Ava);
	}
	int getid() {
		return Id;
	}
	int getprice() {
		return Price;
	}
}
