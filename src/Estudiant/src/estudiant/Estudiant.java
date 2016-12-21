/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiant;

/**
 *
 * @author Kevin
 */
public class Estudiant {
     private String nom; //nom de l'estudiant
    private String curs; //curs que cursa l'estudiant
    private int nota;//nota que ha tret d'estudiant del curs
    
    //constructors
    public Estudiant(String nom, String curs) {
        this.nom = nom;
        this.curs = curs;
        this.nota=-1; // dada per assignar
    }
    
    public Estudiant(String nom) {
        this.nom = nom;
        this.curs = null; // dada per assignar
        this.nota=-1; // dada per assignar
    }

    //getters i setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    //mètodes
    /* mètode que ens mostra 
    els atributs de la classe */
  
    public String dades(){
        return "Les dades són: nom=" + nom + ", curs=" + curs + ", nota=" + nota;
    }  
  
    
}
