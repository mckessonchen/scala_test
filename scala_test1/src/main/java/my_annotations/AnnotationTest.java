package my_annotations;

import java.lang.reflect.Method;

/**
 * Created by chenteng on 2017/3/23.
 */

public class AnnotationTest {
    @UseCase(id = 1)
    public static boolean validate(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 2, description = "encryptPassword")
    private String encryptPassword(String password) {
        return new StringBuffer(password).reverse().toString();
    }

    public static void main(String[] args) {
        trackUseCase(AnnotationTest.class);
    }

    public static void trackUseCase(Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null)
                System.out.println("found annotation UseCase id:" + uc.id() + " description:" + uc.description());
            else
                System.out.println("no annotation method " + m.getName());
        }
    }

}

