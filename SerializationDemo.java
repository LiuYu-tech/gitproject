package lab_03;

import java.io.*;
import java.util.*;

enum MovieType implements Serializable{   
	    Comedy("ϲ��Ƭ"),
	    Action("����Ƭ"),
	    Romatic("����Ƭ"),
	    ScienceFiction("�ƻ�Ƭ");
	    private final String name;
	    MovieType(String name){
	        this.name = name;
	    }
	    public String get(){
	        return name;
	    }
	     
}

class Movie implements Serializable{    //��Ӱ
	  String name;
	    MovieType type;
	    String where;
	    Movie(String where,String name,MovieType a){
	        this.name = name;
	        this.where = where;
	        this.type = a;
	    }
	    void printinfo(){
	        System.out.print(this.name+"\n"+"���ͣ�"+this.type.get()+"\n"+"��ӳ����"+this.where+"\n");
	    }
}

class MovieSchedule implements Serializable{  //��Ӱ��ӳʱ���
	 String time;
	    String date;
	    MovieSchedule(String date,String time){
	        this.time = time;
	        this.date = date;
	    }
	    void printinfo(){
	        System.out.print("ʱ�䣺"+this.date+" "+this.time+"\n");
	    }
}

class Seat implements Serializable{   //��λ
	int row;
    int col;
    Seat(int a,int b){
        this.row = a;
        this.col = b;
    }
    void printinfo(){
        System.out.print("��λ��"+this.row+"��"+this.col+"��\n");
    }
}

class Ticket implements Serializable{ //��ӰƱ
	    Movie a;
	    MovieSchedule b;
	    Seat c;
	    Ticket(Movie get,MovieSchedule time,Seat seat){
	        this.a = get;
	        this.b = time;
	        this.c = seat;
	    }

	public void printTicket(){//��ӡƱ����ϸ��Ϣ 
		    a.printinfo();
	        b.printinfo();
	        c.printinfo();
	}
}

public class SerializationDemo {
	
	public static void main (String[] args) {
		Seat seat1 = new Seat(10,12);
        MovieSchedule time1 = new MovieSchedule("2010��7��12��","20ʱ20��");
        Movie get1 = new Movie("��ӳ��1","����ʯͷ",MovieType.Comedy);
        Ticket one = new Ticket(get1,time1,seat1);
        one.printTicket();
        System.out.println("****************************");
        Seat seat2 = new Seat(10,13);
        MovieSchedule time2 = new MovieSchedule("2010��7��12��","20ʱ20��");
        Movie get2 = new Movie("��ӳ��1","����ʯͷ",MovieType.Comedy);
        Ticket two = new Ticket(get2,time2,seat2);
        one.printTicket();
        System.out.println("****************************");
        Seat seat3 = new Seat(8,8);
        MovieSchedule time3 = new MovieSchedule("2010��7��14��","19ʱ40��");
        Movie get3 = new Movie("��ӳ��2","2012",MovieType.ScienceFiction);
        Ticket three = new Ticket(get3,time3,seat3);
        one.printTicket();
        System.out.println("****************************");
        Seat seat4 = new Seat(8,9);
        MovieSchedule time4 = new MovieSchedule("2010��7��14��","11ʱ20��");
        Movie get4 = new Movie("��ӳ��2","2012",MovieType.Comedy);
        Ticket four = new Ticket(get4,time4,seat4);
        one.printTicket();
        
        try{
              FileOutputStream fs = new FileOutputStream("foo.ser");  
        	  ObjectOutputStream os = new ObjectOutputStream(fs);  
        	  os.writeObject(one);
        	  os.close();
         }catch(Exception ex){
               ex.printStackTrace();
         }
        try{
        	  ObjectInputStream in = new ObjectInputStream(new FileInputStream("foo.ser"));
        	  Ticket getit = (Ticket) in.readObject();
        	  getit.printTicket();
        	  in.close();
        }catch(Exception ex){
        	   ex.printStackTrace();
        	         }
    }
	
	
	

}
//git text



