/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.GestionEquipe.Metier;

/**
 *
 * @author delus-jean-nelka
 */
public class Tachemembre {
    int idtachmembre;
    int membreid;
    int tacheid;

    public Tachemembre() {
    }

    public Tachemembre(int idtachmembre, int membreid, int tacheid) {
        this.idtachmembre = idtachmembre;
        this.membreid = membreid;
        this.tacheid = tacheid;
    }

    public int getIdtachmembre() {
        return idtachmembre;
    }

    public void setIdtachmembre(int idtachmembre) {
        this.idtachmembre = idtachmembre;
    }

    public int getMembreid() {
        return membreid;
    }

    public void setMembreid(int membreid) {
        this.membreid = membreid;
    }

    public int getTacheid() {
        return tacheid;
    }

    public void setTacheid(int tacheid) {
        this.tacheid = tacheid;
    }
    
}
