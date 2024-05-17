package presentation;

import metier.MetierImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VersionSpringXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        /**
         * injection de depen par setter
         */
        MetierImpl metier = (MetierImpl) context.getBean("metier");
        System.out.println(metier.calcul());

        /**
         * injection de depen par constructeur
         */
        MetierImpl metier2 = (MetierImpl) context.getBean("metier2");
        System.out.println(metier2.calcul());
    }
}
