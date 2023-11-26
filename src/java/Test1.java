
import java.util.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Service1;
import ma.projet.beans.Machine;
import ma.projet.beans.Salle;
import ma.projet.service.EmployeService;
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
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MachineService ms = new MachineService();
        SalleService ss = new SalleService();
        //Création des machines
        ms.create(new Machine("HP", "HZ23", 5000, new Date(), ss.getById(1)));
        ms.create(new Machine("HP", "HZ77", 4500, new Date(), ss.getById(1)));
        ms.create(new Machine("TOSHIBA", "AZ34", 6000, new Date(), ss.getById(2)));
        //Afficher les machines par salle
        for(Salle s : ss.getAll()){
            System.out.println("Salle  : "+s.getCode()+" : ");
            for(Machine m : s.getMachines())
                System.out.println("\t"+m.getReference());
        }
    }
//        EmployeService es = new EmployeService();
//        Service1Service s1s = new Service1Service();
//        //Création des machines
//        es.create(new Employe(1L, "HANSAL", "Nada", new Date(), s1s.getById(1L), es.getById(1L)));
//        es.create(new Employe(2L, "Merjane", "Wiam", new Date(), s1s.getById(1L), es.getById(1L)));
//        es.create(new Employe(3L, "Khabbachi", "Nouha", new Date(), s1s.getById(1L), es.getById(1L)));
//        es.create(new Employe(3L, "JALAOUI", "Salma", new Date(), s1s.getById(2L), es.getById(2L)));
//        //Afficher les machines par salle
//        for(Service1 s1 : s1s.getAll()){
//            System.out.println("Service  : "+s1.getNom()+" : ");
//            for(Employe e : s1.getEmployes())
//                System.out.println("\t"+e.getNom());
//        }
//    }
}
