package coreJava;
import java.lang.reflect.*;

public class ClassReader {
    public static void main(String[] args) {
        try {
            int count = 0;
            Class<?> c = Class.forName(args[0]);
            Method[] m = c.getDeclaredMethods();
            for (Method method : m) {
                count++;
                System.out.println(method + " " +count);
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
