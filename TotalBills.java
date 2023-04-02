import java.util.*;
import java.util.ArrayList;
public class TotalBills {
    public static void main(String[] args) {
        List<Cost>  bills=new ArrayList<>();
        Map<String ,Integer> balance=new HashMap<>();
        bills.add(new Cost("lunch",2000,"balaji",Arrays.asList("balaji","anand","chaitanya","divya")));
        bills.add(new Cost("movie",1000,"anand",Arrays.asList("balaji","anand","chaitanya","divya")));
        bills.add(new Cost("snacks",750,"chaitanya",Arrays.asList("balaji","anand","chaitanya")));
        
   //calculate cost spends by each person
    for(Cost bill:bills){
          String paidBy=bill.getPaidBy();
          int Amount=bill.getPaidAmount();
          List<String> sharedBy=bill.getSharedFriends();
        int sharedPerEach=Amount/bill.getSharedFriends().size();
       //add amount paid by each person
        if(!balance.containsKey(paidBy))
            balance.put(paidBy,Amount);
            else
            balance.put(paidBy,balance.get(paidBy)+Amount);

        //subtract amount from sharedpersons

           for(String person:sharedBy){
          
              if(!balance.containsKey(person))
              balance.put(person, -sharedPerEach);
            else {
                balance.put(person, balance.get(person) - sharedPerEach);
            }
           }
    }
   
    for (Map.Entry<String, Integer> entry : balance.entrySet()) {
      String person = entry.getKey();
     int  balances = entry.getValue();
      
      System.out.println(person + " owes " + (-balances) + " to others.");
  }  
    }

  
}

class Cost{
    private String description;
    private int paidAmount;
    private String paidBy;
    private List<String> sharedFriends;
     Cost(String description,int paidAmount,String paidBy,List<String>sharedFriends){
      this.description=description;
      this.paidAmount=paidAmount;
      this.paidBy=paidBy;
      this.sharedFriends=sharedFriends;
     }
    public String getDescription(){
        return description;
        }
    public int getPaidAmount(){
        return paidAmount;
      }
      public String getPaidBy(){
        return paidBy;
      }
      public List<String> getSharedFriends(){
        return sharedFriends;
      }

}  
