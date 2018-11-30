import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) {
        Entity entity;
        Class cl;
        try {
            cl = Class.forName("Entity");////Entity.class.getName());//
            entity = (Entity) cl.newInstance();
            Method publicMethod = entity.getClass().getMethod("publicSOUT");
            publicMethod.invoke(entity);
            Entity.Secured publicMethodAnnotation = publicMethod.getAnnotation(Entity.Secured.class);
            System.out.println("Параметры аннотации publicSOUT: " + publicMethodAnnotation.id() + " " + publicMethodAnnotation.name());

            Method privateMethod = entity.getClass().getDeclaredMethod("privateSOUT");
            privateMethod.setAccessible(true);
            privateMethod.invoke(entity);
            Entity.Secured privateMethodAnnotation = privateMethod.getDeclaredAnnotation(Entity.Secured.class);
            System.out.println("Параметры аннотации privateSOUT: " + privateMethodAnnotation.toString());

            Method protectedMethod = entity.getClass().getDeclaredMethod("protectedSOUT");
            protectedMethod.setAccessible(true);
            protectedMethod.invoke(entity);
            Entity.Secured protectedMethodAnnotation = protectedMethod.getDeclaredAnnotation(Entity.Secured.class);
            System.out.println("Параметры аннотации protectedSOUT: " + protectedMethodAnnotation.toString());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
