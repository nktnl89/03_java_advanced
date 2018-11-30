import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Entity {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @interface Secured {
        int id();

        String name() default "strict";

    }

    @Secured(id = 1)
    public void publicSOUT() {
        System.out.println("это публичный метод");
    }

    @Secured(id = 2, name = "private")
    private void privateSOUT() {
        System.out.println("это приватный метод");
    }

    @Secured(id = 3, name = "protected")
    protected void protectedSOUT() {
        System.out.println("это защищенный метод");
    }
}
