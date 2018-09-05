package ru.stqa.pft.rest.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.rest.mantis.models.AccountData;
import ru.stqa.pft.rest.mantis.models.Accounts;

import java.util.List;

public class DbHalper {
    private final SessionFactory sessionFactory;

    public DbHalper() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() 
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    public Accounts accounts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<AccountData> result = session.createQuery("from AccountData").list();
        session.getTransaction().commit();
        session.close();
        return new Accounts(result);
    }
}
