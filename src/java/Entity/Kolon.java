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
public class Kolon {
    private int id;
    private int numara;
    private Raf raf;


    
    public Kolon(int numara, Raf raf) {
        this.numara = numara;
        this.raf  = raf;
    }
    public Kolon(int id, int numara, Raf raf) {
        this.id = id;
        this.numara = numara;
        this.raf = raf;
    }


    public Kolon() {
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

    public void setNumara(int numara){
        this.numara = numara;
    }

  
    public Raf getRaf() {
        return raf;
    }

    public void setRaf(Raf raf) {
        this.raf = raf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
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
        final Kolon other = (Kolon) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Kolon{" + "id=" + id + ", numara=" + numara + ", raf_id=" + raf.getId() + '}';
    }
    
    
}
