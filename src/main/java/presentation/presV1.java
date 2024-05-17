package presentation;

import Dao.DaoImpl;
import metier.MetierImpl;

public class presV1 {
    public static void main(String[] args) {
        /**
         *injection des dependances par instanciation statique
         */
        DaoImpl d=new DaoImpl();
        MetierImpl metier = new MetierImpl();

        metier.setDao(d);//injection par setter
        System.out.println(metier.calcul());

        MetierImpl metier2= new MetierImpl(d);// injection des dependances via constructeur
        metier2.calcul();

        /**
         * le prob ici c'est que notre classe n'est pas fermer a la modification
         */

    }
}
