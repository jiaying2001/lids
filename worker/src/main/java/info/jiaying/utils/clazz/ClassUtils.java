package info.jiaying.utils.clazz;

public class ClassUtils {
    public static Class<?>[] resolve(Object[] objects) {
        Class<?>[] classes = new Class<?>[objects.length];
        for (int i = 0; i < objects.length; i++) {
            classes[i] = objects[i].getClass();
        }
        return classes;
    }
}
