package loaders;

import interfaces.WeatherAdvisor;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Natallia_Rakitskaya
 */
public class AdvisorsLoader {

    private static Logger LOGGER = Logger.getLogger(AdvisorsLoader.class);

    private List<WeatherAdvisor> advisors = new ArrayList();

    public AdvisorsLoader(){
        try {
            JarFile jarFile = new JarFile("dynaclasses/advisors_functionality-1.0-SNAPSHOT.jar");
            Enumeration en = jarFile.entries();

            URL[] urls = {new URL("jar:file:" + "dynaclasses" + "!/")};
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            while (en.hasMoreElements()) {
                JarEntry je = (JarEntry) en.nextElement();
                if(je.isDirectory() || !je.getName().endsWith(".class")){
                    continue;
                }

                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                try {
                    Class c = cl.loadClass(className);
                    WeatherAdvisor advisor = (WeatherAdvisor) c.newInstance();
                    advisors.add(advisor);
                } catch (Exception e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
        catch(IOException e){
            LOGGER.warn(String.format("Directory \"dynaclasses\" with specified jar does not exist!"));
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
