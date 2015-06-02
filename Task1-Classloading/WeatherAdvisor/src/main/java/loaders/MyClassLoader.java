package loaders;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Natallia_Rakitskaya
 */
public class MyClassLoader extends ClassLoader{
    private static Logger LOGGER = Logger.getLogger(MyClassLoader.class);
    private Map<String, JarEntry> fileMap;
    private JarFile jarFile;

    public MyClassLoader(JarFile jarFile, Map<String, JarEntry> fileMap) {
        this.jarFile = jarFile;
        this.fileMap = fileMap;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        JarEntry entry = fileMap.get(name);
        try {
            long size = entry.getSize();
            byte[] bytes = new byte[(int) size];
            InputStream inputStream = jarFile.getInputStream(entry);
            inputStream.read(bytes);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            LOGGER.error(String.format("Class %s was not found: %s", name, e.getMessage()));
        }
            throw new ClassNotFoundException(name);
        }
}
