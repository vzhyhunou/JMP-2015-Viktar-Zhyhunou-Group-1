import interfaces.WeatherAdvisor;

/**
 * @author Natallia_Rakitskaya
 */
public class RainyWeatherAdvisor implements WeatherAdvisor {

    public String getWeatherConditions(){return "It is rainy";}

    public void advice(){
        System.out.println("Take your umbrella!!");
    }
}
