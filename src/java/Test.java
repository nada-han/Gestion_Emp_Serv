
import ma.projet.beans.Salle;
import ma.projet.beans.Service1;
import ma.projet.service.MachineService;
import ma.projet.service.SalleService;
import ma.projet.service.Service1Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LACHGAR
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SalleService ss = new SalleService();
        //création des Salles
        ss.create(new Salle("I", "Informatique"));
        ss.create(new Salle("A", "Arabe"));
        ss.create(new Salle("C", "Comptailité"));
        //La liste des salles
        for (Salle s : ss.getAll()) {
            System.out.println("" + s.getCode());
        }
        
        
//        Service1Service s1s = new Service1Service();
//        //création des Salles
//        s1s.create(new Service1(1L, "service1"));
//        s1s.create(new Service1(2L, "service2"));
//        s1s.create(new Service1(3L, "service3"));
//        //La liste des salles
//        for (Service1 s : s1s.getAll()) {
//            System.out.println("" + s.getNom());
//        }
    }
}
