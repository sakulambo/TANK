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
public class Professor {
    
    //atributs
    private String nom; //nom del professor
    private String carrec;//carrec del professor
    private float sou; //sou del professor
    
    //constructors
    public Professor(String nom, String carrec, float sou) {
        this.nom = nom;
        this.carrec = carrec;
        this.sou = sou;
    }
    
    //getters i setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCarrec() {
        return carrec;
    }

    public void setCarrec(String carrec) {
        this.carrec = carrec;
    }

    public float getSou() {
        return sou;
    }

    public void setSou(int sou) {
        this.sou = sou;
    }
    
    //mètodes
    //mostra les dades del professor
    
    public String dades() {
        return "Les dades: nom=" + nom + ", carrec=" + carrec + ", sou=" + sou + "€";
    }
    
    
    //mètode per assignar una nota a un alumne    
    public void assignarNota(Estudiant est, int nota)
    {
           est.setNota(nota);
    }
    
}
