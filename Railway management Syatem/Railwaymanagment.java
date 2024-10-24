
//a program to demonstrate runtime polymorphism using method overriding and
// dynamic method dispatch, 
// applied to railway reservation system.

class Railwaymanagment extends Train {
    
    Railwaymanagment(int t_no, int t_seat, int b_seats) {
        train_no=t_no;
        total_seats=t_seat;
        booked_seats=b_seats;
        avl_seats=total_seats-booked_seats;
    }

    @Override
    String givetick(){
        return "Train No:"+train_no +" \n Total Seats: "+ total_seats +" \n Booked Seates: "+booked_seats+ "\n Avalabile Seats:"+avl_seats; 
    }
    @Override
    public int getavatick(){
        return avl_seats;
       
    }
    
}