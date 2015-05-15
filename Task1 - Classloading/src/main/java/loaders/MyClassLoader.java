package loaders;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
/**
 * @author Natallia_Rakitskaya
 */
public class MyClassLoader extends ClassLoader {
    private static Logger LOGGER = Logger.getLogger(MyClassLoader.class);

    private Map<String, File> fileMap;

    public MyClassLoader(Map<String, File> fileMap) {
        this.fileMap = fileMap;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            Class<?> clazz = getParent().loadClass(name);
            return clazz;
        } catch (ClassNotFoundException e) {
            LOGGER.debug(String.format("Parent classloader can't load [%s]", name));
        }
        File file = fileMap.get(name);
        if (file != null) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] bytes = IOUtils.toByteArray(inputStream);
                return defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                new ClassNotFoundException(name);
            }
        }
        throw new ClassNotFoundException(name);
    }
}
