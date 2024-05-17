package metier;

import Dao.DaoImpl;
import Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier3")
public class MetierImpl implements IMetier {

    //couplage faible
    @Autowired // annotation pour l'injection de depen par setter
    private IDao dao;//=null  //= new DaoImpl(); polymorphise

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tem = dao.getData();
        System.out.println("succes");
        return tem;
    }


    /**
     * pour injecter dans l'attribut dao un objet d'une classe qui iplemente IDao
     * c'est la 1ere solution pour faire l'injection des dependances (par les setters)
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
