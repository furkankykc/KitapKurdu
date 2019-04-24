/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author KursadArslan
 */
public class Raf {
    private int id;
    private int numara;
    private Depo depo;

    public Raf(int id, int numara, Depo depo) {
        this.id = id;
        this.numara = numara;
        this.depo = depo;
    }

    public Raf(int numara, Depo depo) {
        this.numara = numara;
        this.depo = depo;
    }

    public Raf() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
       
    public int getNumara() {
        return numara;
    }
    
    public void setNumara(int numara) {
        this.numara = numara;
    }

    public Depo getDepo() {
        return depo;
    }

    public void setDepo(Depo depo) {
        this.depo = depo;
    }
    

    @Override
    public String toString() {
        return "Raf{" + "id=" + id + ", numara=" + numara + ", depoId=" + depo.getId() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Raf other = (Raf) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
