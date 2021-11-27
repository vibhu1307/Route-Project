//pojo class

public class Route {
    private String fromCity;
    private String toCity;
    private String distance;
    private String travelTime;
    private String airFare;
    
    //Default Constructor
	public Route()
	{
     
	}

    //Parameterized Constructors
    public Route(String fromCity, String toCity, String distance, String travelTime, String airFare) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
        this.travelTime = travelTime;
        this.airFare = airFare;
    }

  //  public Route(String datum, String s, String i, String datum1, String s1, String datum2){}
    
    //Getter And Setter
    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
    
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getAirFare() {
        return airFare;
    }

    public void setAirFare(String airFare) {
        this.airFare = airFare;
    }

    //to string method
    @Override
    public String toString() {
        return fromCity + "\t\t" + toCity + "\t\t" +distance+ "\t\t" + travelTime +"\t\t" + airFare  ;
    }
}

