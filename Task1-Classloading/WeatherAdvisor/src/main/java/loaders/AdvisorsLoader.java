package loaders;

import interfaces.WeatherAdvisor;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Natallia_Rakitskaya
 */
public class AdvisorsLoader{

    private static Logger LOGGER = Logger.getLogger(AdvisorsLoader.class);

    private List<WeatherAdvisor> advisors = new ArrayList();

    public AdvisorsLoader(){
        JarFile jarFile = null;
        try {
            jarFile = new JarFile("dynaclasses/advisors_functionality-1.0-SNAPSHOT.jar");
            Enumeration en = jarFile.entries();

            Map<String, JarEntry> fileMap = new HashMap();
            while (en.hasMoreElements()) {
                JarEntry je = (JarEntry) en.nextElement();
                if(je.isDirectory() || !je.getName().endsWith(".class")){
                    continue;
                }

                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                fileMap.put(className, je);
            }
            initAdvisors(new MyClassLoader(jarFile, fileMap), fileMap.keySet());
        } catch (IOException e) {
            LOGGER.warn(String.format("Directory \"dynaclasses\" with specified jar does not exist!"));
        }
    }

    private void initAdvisors(ClassLoader loader, Set<String> classSet) {
        for (String className: classSet) {
            try {
                Class<?> clazz = loader.loadClass(className);
                WeatherAdvisor advisor = (WeatherAdvisor)clazz.newInstance();
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
