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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //instanciar objectes
        Estudiant est1 = new Estudiant("Pere", "2n DAW");
        Estudiant est2 = new Estudiant("Anna");
        Curs c1=new Curs("2n DAW");
        
        c1.afegir(est1);
        c1.afegir(est2);
        
        c1.mostrarLlistat();
        System.out.println("----------------------");
        c1.afegir("Joan", "2n DAW");
        
        c1.mostrarLlistat();
        System.out.println("----------------------");
       c1.eliminar(est1);
        c1.mostrarLlistat();
        System.out.println("----------------------");
        
        c1.eliminar("Anna");
        
         c1.mostrarLlistat();
        System.out.println("----------------------");

        Professor prof1 = new Professor("Antoni", "tutor 2n DAW", 1500);

        //utilitzar mètode
        //mostrar dades de l'estudinat
        System.out.println("Estudiant 1 " + est1.dades());
//        
        if(est1.getNota()==-1)
        {
            System.out.println("Aquest alumne encara no té nota");
        }
        else{
           System.out.println("Estudiant 1 " + est1.getNom());
        }
        

        //assignar nota a alumne
        prof1.assignarNota(est1, 8);
        System.out.println("Estudiant 1 " + est1.dades());
    
    }
    
}
