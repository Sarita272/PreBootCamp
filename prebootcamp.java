import java.util.*;
import java.util.Map.Entry;

public class prebootcamp {
	public static double calculateAndPrintTax(double Qty, double Price)
	{
		return Qty*Price*0.1;
	}
    
	public static double calculateAndPrintTaxImported(double Qty, double Price)
	{
		return Qty*Price*0.15;
	}
	
	public static double onlyImported(double Qty, double Price)
	{
		return Qty*Price*0.05;
	}
	
    public static void main(String[] args) {
       Map<String, List<String>> map1 = new HashMap<String, List<String>>();//This is one instance of the  map you want to store in the above list.
       Scanner scan = new Scanner(System.in);
       System.out.println("Number of differnt purchases: ");
       int input = scan.nextInt();
       scan.nextLine();
       
       for (int i = 1; i <= input; i++) {
       List<String> arraylist1 = new ArrayList<String>();	   
       System.out.println("Your purchase no. " + i + " Qty: ");	
       int qty = scan.nextInt();
       arraylist1.add(String.valueOf(qty));
       scan.nextLine();
       
       System.out.println("Your purchase no. " + i + " product name: ");	
       String productname = scan.nextLine();
       arraylist1.add(productname);
       
       System.out.println("Your purchase no. " + i + " Price: ");	
       double price = scan.nextDouble();
       arraylist1.add(String.valueOf(price));
       scan.nextLine();
       
       System.out.println("If your purchase no. " + i + " is books - type B, food - type F, and medical products - type M, else type - N : ");	
       String producttype = scan.nextLine();
       arraylist1.add(producttype);
       
       System.out.println("If your purchase no. " + i + " is imported - type Y, else - type N : ");
       String isimported = scan.nextLine();
       arraylist1.add(isimported);
       
 
       map1.put(arraylist1.get(1),arraylist1);
     
          
       }
       double Tax = 0.00;
       double Total = 0.00;
       double Total1 = 0.00;
       for (Entry<String, List<String>> entry : map1.entrySet()) {        
         if(entry.getValue().get(3).equals("N")) {
         if(entry.getValue().get(4).equals("Y")) {
        	 Total = Double.parseDouble(entry.getValue().get(2)) +calculateAndPrintTaxImported(Double.parseDouble(entry.getValue().get(0)), Double.parseDouble(entry.getValue().get(2)));
        	 Tax = Tax+ calculateAndPrintTaxImported(Double.parseDouble(entry.getValue().get(0)), Double.parseDouble(entry.getValue().get(2)));
        	 Total1 = Total1+Total;
        	 System.out.println(entry.getValue().get(0)+" "+entry.getValue().get(1)+": "+ Total);
          }
         if(entry.getValue().get(4).equals("N")) {
        	 Tax = Tax+calculateAndPrintTax(Double.parseDouble(entry.getValue().get(0)), Double.parseDouble(entry.getValue().get(2)));
             Total = Double.parseDouble(entry.getValue().get(2)) +calculateAndPrintTax(Double.parseDouble(entry.getValue().get(0)), Double.parseDouble(entry.getValue().get(2)));
        	 Total1 = Total1+Total;
             System.out.println(entry.getValue().get(0)+" "+entry.getValue().get(1)+": "+Total);
             
         }
    }
    else if(entry.getValue().get(3).equals("B") || entry.getValue().get(3).equals("F") || entry.getValue().get(3).equals("M") ) {
 	   if(entry.getValue().get(4).equals("Y")) {
 		  Tax = Tax+onlyImported(Double.parseDouble(entry.getValue().get(0)), Double.parseDouble(entry.getValue().get(2)));
          Total = Double.parseDouble(entry.getValue().get(2)) + onlyImported(Double.parseDouble(entry.getValue().get(0)), Double.parseDouble(entry.getValue().get(2)));
     	  Total1 = Total1+Total;
          System.out.println(entry.getValue().get(0)+" "+entry.getValue().get(1)+": "+ Total);
            
        }
        if(entry.getValue().get(4).equals("N")) {
        	 Tax = Tax; 
             Total = Double.parseDouble(entry.getValue().get(2));
        	 Total1 = Total1+Total;
            System.out.println(entry.getValue().get(0)+" "+entry.getValue().get(1)+": "+Total);
           
        }
    }
   
    } 
 
       System.out.println("Tax: "+ Math.round(Tax));
       System.out.println("Total: "+ Math.round(Total1));
        
}
}

 
 
