import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PlannerImplementation {

	public static void main(String[] args) throws IOException{
		
		String filename="E:\\Wave_12_eclipse\\CollectionProject\\src\\routes.csv"; //taking a file
		Planner planner =new Planner(); //created obj of implementation class which is named as planner.
		System.out.println("------------ Task !-------------");
        List<Route> pList=planner.readFromFile(filename); //printing all the content of the file
        System.out.format("%-20s  %-20s %-20s %-20s %-20s \n","From", "TO","Distance in Km","Travel Time","Typical Airfare");
        pList.forEach(c->System.out.format("%-20s  %-20s %-20s %-20s %-20s \n",c.getFromCity(),c.getToCity(),c.getDistance(),c.getTravelTime(),c.getAirFare()));
        
        System.out.println("\n------------ Task 2-------------");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter From City -");
        String fromCity=scanner.nextLine();
        List<Route> routeList1=planner.showDirectFlights(pList,fromCity); //both are passing through the method
        System.out.format("%-20s  %-20s %-20s %-20s %-20s \n","From", "TO","Distance in Km","Travel Time","Typical Airfare");  //(routelist1- directflightlis)
        routeList1.forEach(c->System.out.format("%-20s  %-20s %-20s %-20s %-20s \n",c.getFromCity(),c.getToCity(),c.getDistance(),c.getTravelTime(),c.getAirFare()));
        
        System.out.println("\n------------ Task 3-------------");
        System.out.println("------------ Flight after Sorting-------------");
        System.out.format("%-20s  %-20s %-20s %-20s %-20s \n","From", "TO","Distance in Km","Travel Time","Typical Airfare");
        List<Route> listobj1=planner.sortDirectFlights(routeList1);
        listobj1.forEach(c->System.out.format("%-20s  %-20s %-20s %-20s %-20s \n",c.getFromCity(),c.getToCity(),c.getDistance(),c.getTravelTime(),c.getAirFare()));
        
        
        planner.sortDirectFlights(routeList1);
//        System.out.println("Enter source city");
//		String sourceCity=scanner.next();
        System.out.println("\nEnter Destination City -");
        String toCity=scanner.nextLine();
        System.out.format("%-20s %-20s %-20s %-20s %-20s\n","From", "To","Distance in Km","Travel Time","Ticket cost");
		planner.showAllConnection(pList, fromCity, toCity);	}

}
