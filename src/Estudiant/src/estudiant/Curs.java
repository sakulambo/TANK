/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiant;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class Curs {
    //atributs
    private String nom;//nom del curs
    private ArrayList<Estudiant> llistat;//llistat d'estudiants del curs

    //constructrs
    public Curs(String nom)
    {
        this.nom=nom;
        this.llistat=new ArrayList<Estudiant>();

    }

    //getters i setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    //mètodes
    
    /* mètode que et retorna la posició de l'estudiant a l'array
     * donat el seu nom.
     * Si no existeix l'estudiant es retorna -1
     */
    public int cercar(String nom)
    {
        int posicio=-1;
        boolean trobat=false;
        int i=0;
        
        while((trobat==false)&&(i<llistat.size()))
        {
            if(llistat.get(i).getNom().equals(nom))
            {
                trobat=true;
                posicio=i;
            }
            i++;
      
        }        
        return posicio;
        
    }
    //afegir un estudiant al llistat passant un objecte estudiant
    public void afegir(Estudiant al)
    {
        this.llistat.add(al);
    }
    
    //afegir un estudiant al llistat passant els atributs d'un estudiant
    public void afegir(String nom, String curs)
    {
        Estudiant est=new Estudiant(nom, curs);
        this.llistat.add(est);
    }

    //eliminar un estudiant al llistat passant un objecte estudiant
    public void eliminar(Estudiant al)
    {
        this.llistat.remove(al);
    }
    
     //eliminar un estudiant al llistat passant el seu nom
    public void eliminar(String nom)
    {
        
        int pos=this.cercar(nom);
        if(pos!=-1) this.llistat.remove(pos);
    }

    //mètode que mostra el llistat d'estudiants del curs utilitzant un "for each"
    public void mostrarLlistat()
    {
        for (Estudiant al: llistat)
        {
            System.out.println(al.dades());
        }
    }

    //mètode que mostra el llistat d'estudiants del curs utilitzant un "for size"
    public void mostrarLlistat2()
    {
        for(int i=0;i<llistat.size();i++)
        {
            System.out.println(llistat.get(i).dades());
        }
    }    
    
}
