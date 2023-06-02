import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyFrameworkTest {

    public static void main(String[] args) {
        String classFilePath = MyFrameworkTest.class.getPackage().getName() + ".deTestat";

        try {
            Class<?> clasaMea = Class.forName(classFilePath);

            Package classPackage = clasaMea.getPackage();
            if (classPackage != null) {
                System.out.println("Package: " + classPackage.getName());
            }

            Method[] methods = clasaMea.getDeclaredMethods();
            int passed = 0, failed = 0;
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
                int modifiers = method.getModifiers();
                System.out.println("Modifiers: " + Modifier.toString(modifiers));
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        method.invoke(null);
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n",
                                method, ex.getCause());
                        failed++;
                    }
                }
            }
            System.out.printf("Passed: %d, Failed %d%n", passed, failed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}