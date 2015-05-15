import interfaces.WeatherAdvisor;
import loaders.AdvisorsLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Natallia_Rakitskaya
 */
public class WeatherAdvisorConsoleApp {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private AdvisorsLoader loader;

    public WeatherAdvisorConsoleApp() {
        loader = new AdvisorsLoader();
        start();
    }

    private void start() {
        try {
            System.out.println("Welcome to weather advisor :)");
            while (true) {
                System.out.println("Please, specify what type of weather conditions you have outside:");
                System.out.println("0. Exit");
                showMenu();
                int choice = getInputValue();
                if (choice == 0) {
                    break;
                }
                getAdvice(choice);
                System.out.println("Press enter to try once again...");
                System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMenu() {
        List<WeatherAdvisor> allAdvisors = loader.getAllAdvisors();
        for (int i=0; i < allAdvisors.size(); i++) {
            System.out.println(String.format("%d. %s", i+1, allAdvisors.get(i).getWeatherConditions()));
        }
    }

    private int getInputValue() throws IOException {
        while (true) {
            System.out.println("Your are choosing: ");
            String inputValue = reader.readLine();
            try {
                return Integer.valueOf(inputValue.trim()).intValue();
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input value! Please, try again...");
            }
        }
    }

    private void getAdvice(int inputNumber) {
        WeatherAdvisor advisor = loader.getAdvisorByNumber(inputNumber - 1);
        if (advisor != null) {
            advisor.advice();
        }
    }
}
