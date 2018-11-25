/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.GestionEquipe.controler;

import Com.GestionEquipe.Metier.Membre;
import Com.GestionEquipe.Metier.Tache;
import Com.GestionEquipe.Metier.Tachemembre;
import java.util.List;

/**
 *
 * @author delus-jean-nelka
 */
public interface ServiceIlocal {
    public String Ajoutermembre(Membre mb);
    public String Modifiermembre(Membre mb);
    public Membre RechercherMembre(int id);
    public List<Membre> ListerMembre();
    public String SupprimerMembre (int id) ;
    
    
     public String AjouterTache(Tache ta);
    public String ModifierTache(Tache ta);
    public Tache RechercherTache(int id);
    public List<Tache> ListerTache();
    public String SupprimerTache (int id) ;
    
    public String AjouterTachemembre(Tachemembre tachm);
    public List<Tache> ListerTachemembre(int id);
}
