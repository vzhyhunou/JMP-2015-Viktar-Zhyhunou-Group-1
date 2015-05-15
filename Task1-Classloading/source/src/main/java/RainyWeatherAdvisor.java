/**
 * @author Natallia_Rakitskaya
 */
public class RainyWeatherAdvisor implements WeatherAdvisor {
    public RainyWeatherAdvisor(){};

    public String getWeatherConditions(){return "It is rainy";}

    public void advice(){
        System.out.println("Take your umbrella!!");
    }
}
