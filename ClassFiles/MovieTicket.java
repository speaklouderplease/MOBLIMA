import

public class MovieTicket{
  //members
  private int ticketID;
  private int seatNumber;
  private int ticketPrice;
  private int date; //ddmmyy
  private String showTime; 

    
  
  //const  
    public MovieTicket(int ticketID,int seatNumber,int date, String showTime){
      this.ticketID = ticketID;
      this.seatNumber = seatNumber;
      this.date = date;
      this.showTime = showTime;
    }
  
  //get
  
    public int getticketID(){
      return this.ticketID;
    }
  
    public int getseatNumber()
      return this.seatNumber;
    }
      
    public int getticketPrice(){
      return this.ticketPrice;
    }

    public int getdate(){
      return this.date
    }
  
}
  
