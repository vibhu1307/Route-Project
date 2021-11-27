import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Planner 
{
	 
	public List<Route> readFromFile(String filename) throws FileNotFoundException, IOException
	{
		List<Route> routeList=new ArrayList<>(); 
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String line;
		String [] routeinfo;
		
		while((line = br.readLine())!=null)
		{
			routeinfo=line.split(",");
			Route obj=new Route();
			obj.setFromCity(routeinfo[0]);
			obj.setToCity(routeinfo[1]);
			obj.setDistance(routeinfo[2]);
			obj.setTravelTime(routeinfo[3]);
			obj.setAirFare(routeinfo[4]);
			routeList.add(obj);
		}
		return routeList;
	}
	
	public List<Route> showDirectFlights(List<Route> routeData,String city)
	{
		return routeData.stream().filter(obj->obj.getFromCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		
	}
	
	public List<Route> sortDirectFlights(List<Route> directFlight)
	{
		return directFlight.stream().sorted((obj1,obj2)-> obj1.getToCity().compareToIgnoreCase(obj2.getToCity())).collect(Collectors.toList());	
	}
	
	//function to show all indirect flights
		public void showAllConnection(List<Route> rlistObj3, String sourceCity, String destinationCity)
		{
			List<Route> listObj4 = showDirectFlights(rlistObj3,sourceCity);
			listObj4.stream().filter(c->c.getToCity().trim().equalsIgnoreCase(destinationCity)).collect(Collectors.toList()).forEach(c->System.out.format("%-20s %-20s %-20s %-20s %-20s\n",c.getFromCity(),c.getToCity(),c.getDistance(),c.getTravelTime(),c.getAirFare()));
			
			Predicate<Route> pre=p->p.getFromCity().trim().equalsIgnoreCase(sourceCity);
			Predicate<Route> pre1=p->p.getToCity().trim().equalsIgnoreCase(destinationCity);
			
			for(Route r:rlistObj3)
			{
				String tempCity=r.getToCity().trim();
				if(pre.test(r)&&!tempCity.equalsIgnoreCase(destinationCity))
				{
					for(Route r1:rlistObj3)
					{
						if(pre1.test(r1)&&r1.getFromCity().trim().equalsIgnoreCase(tempCity))
						{
							System.out.format("%-20s %-20s %-20s %-20s %-20s\n",r.getFromCity(),r.getToCity(),r.getDistance(),r.getTravelTime(),r.getAirFare());
							showAllConnection(rlistObj3,tempCity,destinationCity);
						}
					}
				}
			}
			
			
		}
}
	
	

