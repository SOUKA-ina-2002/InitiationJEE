package presentation;

import metier.MetierImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class VersionSpringAnn {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("Dao","metier");
        MetierImpl metier = context.getBean(MetierImpl.class);
        System.out.println("Version Spring Anno");
        System.out.println(metier.calcul());
    }
}
