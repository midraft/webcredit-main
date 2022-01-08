package controllers;

import com.example.application.model.Clients;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class dataSource {

    public static void main(String[] args) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Clients contactEntity = new Clients();
        contactEntity.setCLIENTID("b1a5af90-b687-4663-8ab4-337c2ceb53f1");
        contactEntity.setNAME("Nick");
        contactEntity.setPATRONYMIC("VN");
        contactEntity.setSURNAME("Вав");
        contactEntity.setPHONE("89643464298");
        contactEntity.setEmail("vdfhgeawge@ewr2314252");
        contactEntity.setPASSPORTID(4653);
        contactEntity.setPASSPORTSERIES(235634);
        contactEntity.setCreditAmount(546000.0);
        contactEntity.setCreditTerm(34534.6);
        contactEntity.setEntryInterestRate(4.5);
        contactEntity.setPaymentSchedules(List.of());

        session.save(contactEntity);
        session.getTransaction().commit();

        session.close();


    }

}