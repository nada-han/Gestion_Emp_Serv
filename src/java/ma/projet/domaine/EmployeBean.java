/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import ma.projet.beans.Employe;
import ma.projet.beans.Service1;
import ma.projet.service.EmployeService;
import ma.projet.service.Service1Service;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.RowEditEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Lenovo
 */
//@SessionScoped
@ManagedBean(name = "employeBean")
@ViewScoped
public class EmployeBean implements Serializable {

    private TreeNode root;

    private Employe employe;
    private Service1 service1;
    private List<Employe> employes;
    private EmployeService employeService;
    private Service1Service service1Service;

    public EmployeBean() {
        employe = new Employe();
        employeService = new EmployeService();
        service1Service = new Service1Service();
        root = new DefaultTreeNode("root", null);
        loadTree();
        loadEmployes();

    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Service1 getService1() {
        return service1;
    }

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public EmployeService getEmployeService() {
        return employeService;
    }

    public void setEmployeService(EmployeService employeService) {
        this.employeService = employeService;
    }

    public Service1Service getService1Service() {
        return service1Service;
    }

    public void setService1Service(Service1Service service1Service) {
        this.service1Service = service1Service;
    }

    public String onCreateAction() {
        employeService.create(employe);
        employe = new Employe();
        return null;
    }
    
     public void onEdit(RowEditEvent event) {
        employe = (Employe) event.getObject();
        Service1 service = service1Service.getById(this.employe.getService1().getId());
        employe.setService1(service);
        employe.getService1().setNom(service.getNom());
        employeService.update(employe);
    }
     
    public String onDeleteAction() {
        employeService.delete(employeService.getById(employe.getId()));
        return null;
    }

    public void onCancel(RowEditEvent event) {
    }

    public void loadEmployes() {
        employes = employeService.getAll();
    }

    public void loadTree() {
        root.getChildren().clear(); // Clear old nodes
        List<Service1> services = service1Service.getAll();

        for (Service1 service : services) {
            // Create a node for the service
            TreeNode serviceNode = new DefaultTreeNode(service, root);

            // Display chief under service
            Employe chief = service.getChef();
            if (chief != null) {
                // Create a node for the chief under the service node
                TreeNode chiefNode = new DefaultTreeNode(chief, serviceNode);

                // Display employees under chief
                for (Employe employe : service.getEmployes()) {
                    // Exclude the chef from the list of employees under the chief
                    if (!employe.equals(chief)) {
                        // Create a node for each employee under the chief node
                        TreeNode employeNode = new DefaultTreeNode(employe, chiefNode);
                    }
                }
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

//    public void onNodeExpand(NodeExpandEvent event) {
//        // Obtenez le nœud qui a été étendu
//        TreeNode expandedNode = event.getTreeNode();
//
//        // Assurez-vous que le nœud est de type 'lazy' et n'a pas été déjà chargé
//        if (expandedNode.getType().equals("lazy") && !expandedNode.isExpanded()) {
//            // Chargez les employés pour le chef associé à ce nœud
//            Employe chef = (Employe) expandedNode.getData();
//            List<Employe> employes = employeService.getEmployesByChef(chef);
//
//            // Ajoutez les employés comme sous-nœuds du nœud étendu
//            for (Employe employe : employes) {
//                TreeNode employeNode = new DefaultTreeNode(employe, expandedNode);
//            }
//
//            // Marquez le nœud comme étant déjà chargé
//            expandedNode.setExpanded(true);
//        }
//    }
//
//    public List<Employe> getEmployesByChef(Employe chef) {
//        // Implémentez la logique pour récupérer les employés du chef spécifié depuis la base de données
//        // Vous pouvez utiliser votre service pour cela
//        return employeService.getEmployesByChef(chef);
//    }
}
