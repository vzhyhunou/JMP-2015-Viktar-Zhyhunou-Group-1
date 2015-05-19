import interfaces.WeatherAdvisor;

/**
 * @author Natallia_Rakitskaya
 */
public class StormyWeatherAdvisor implements WeatherAdvisor {
    public StormyWeatherAdvisor(){};

    public String getWeatherConditions(){return "It is stormy";}

    public void advice(){
        System.out.println("Stay home, take care!!");
    }
}
