import interfaces.WeatherAdvisor;

/**
 * @author Natallia_Rakitskaya
 */
public class SunnyWeatherAdvisor implements WeatherAdvisor {

    public String getWeatherConditions(){return "It is sunny";}

    public void advice(){
        System.out.println("Take your sunglasses!!");
    }
}
