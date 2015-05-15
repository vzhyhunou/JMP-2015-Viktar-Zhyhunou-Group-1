/**
 * @author Natallia_Rakitskaya
 */
public class SunnyWeatherAdvisor implements WeatherAdvisor{
    public SunnyWeatherAdvisor(){};

    public String getWeatherConditions(){return "It is sunny";}

    public void advice(){
        System.out.println("Take your sunglasses!!");
    }
}
