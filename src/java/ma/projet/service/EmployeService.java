/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.beans.Employe;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Lenovo
 */
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Employe o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Employe getById(int id) {
        Employe employe = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employe = (Employe) session.get(Employe.class, id);
        session.getTransaction().commit();
        return employe;
    }

    public Employe getById(Long id) {
        Employe employe = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employe = (Employe) session.get(Employe.class, id);
        session.getTransaction().commit();
        return employe;
    }

    @Override
    public List<Employe> getAll() {
        List<Employe> employes = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes = session.createQuery("from Employe").list();
        session.getTransaction().commit();
        return employes;
    }

    public List<Employe> getEmployesByChef(Employe chef) {
        List<Employe> employes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
        // Utilisez la relation entre chef et employés dans votre modèle de données
            // Par exemple, si vous avez une propriété 'chef' dans la classe Employe, vous pouvez utiliser une requête HQL
            employes = session.createQuery("from Employe where chef = :chef_id")
                    .setParameter("chef", chef)
                    .list();

            session.getTransaction().commit();
        } catch (Exception e) {
            // Gérer les exceptions ici
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return employes;
    }

}
