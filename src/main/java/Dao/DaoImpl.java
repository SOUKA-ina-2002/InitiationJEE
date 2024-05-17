package Dao;

import org.springframework.stereotype.Component;

@Component("d") // c'est pour creer un composant d au demarrage
@Component("dao")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("version base de donnees");
        double tem = 23;
        return tem;
    }
}
