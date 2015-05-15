package loaders;

import interfaces.WeatherAdvisor;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Natallia_Rakitskaya
 */
public class AdvisorsLoader {

    private static Logger LOGGER = Logger.getLogger(AdvisorsLoader.class);

    private List<WeatherAdvisor> advisors = new ArrayList();

    public AdvisorsLoader() {
        File folder = new File("dynaclasses");
        if (folder.exists() && folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();
            Map<String, File> fileMap = new HashMap();
            for (File file : listOfFiles) {
                StringBuilder builder = new StringBuilder(file.getName());
                builder.delete(builder.lastIndexOf(".class"), builder.length());
                fileMap.put(builder.toString(), file);
            }
            initAdvisors(new MyClassLoader(fileMap), fileMap.keySet());
        } else {
            LOGGER.warn(String.format("Directory \"dynaclasses\" does not exist!"));
        }
    }

    private void initAdvisors(ClassLoader loader, Set<String> classSet) {
        for (String className: classSet) {
            try {
                Class<?> clazz = loader.loadClass(className);
                WeatherAdvisor advisor = (WeatherAdvisor) clazz.newInstance();
                advisors.add(advisor);
            } catch (Exception e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    public List<WeatherAdvisor> getAllAdvisors() {
        return advisors;
    }

    public WeatherAdvisor getAdvisorByNumber(int index) {
        WeatherAdvisor specificAdvisor = null;
        try {
            specificAdvisor = advisors.get(index);
        }
        catch(Exception e){
            System.out.println("Advisor, corresponding to input value, was not found!");
        }
        return specificAdvisor;
    }
}
