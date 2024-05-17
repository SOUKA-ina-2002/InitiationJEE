package presentation;

import Dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presV2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName= scanner.nextLine();

            //instanciation dynamique

            Class cdao =Class.forName(daoClassName);
            /**
             * au moment de l'execution forNam cherche la classe s'elle existe ,elle la charge au memoire
             * sinon il genere une exception :ClassNotFoundException
             */

            //Object obj = cdao.getConstructor().newInstance();
            //dans notre cas object est de type IDao
            IDao obj = (IDao) cdao.getConstructor().newInstance();



            String metierClassName= scanner.nextLine();
            Class cmetier =Class.forName(metierClassName);
            //injection par constructeur
            IMetier metier = (IMetier) cmetier.getConstructor(IDao.class).newInstance(obj);

            System.out.println("injection par constructeur");
            System.out.println("**************************");
            System.out.println(metier.calcul());
            System.out.println("-----------------------------------------------------");

            //injection par setter
            IMetier metier2 = (IMetier) cmetier.getConstructor().newInstance();
            Method setDao =cmetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier2,obj);

            System.out.println("injection par setter");
            System.out.println("*********************");
            System.out.println(metier2.calcul());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
