/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Lenovo
 */
@Entity
public class Service1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    
    @OneToMany(mappedBy = "service1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employe> employes;

    public Service1() {

    }

    public Service1(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
    public Employe getChef() {
        if (employes != null && !employes.isEmpty()) {
            // Retourne le premier employé de la liste comme chef
            return employes.get(0);
        } else {
            return null;
        }
    }
    
    

}
