/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.KolonDAO;
import Entity.Kolon;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author KursadArslan
 */
@FacesConverter(value = "kolonConverter")
public class KolonConverter implements Converter{

    private KolonDAO kolonDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Kolon kolon = this.getKolonDao().get(Integer.valueOf(value));
        
        return kolon;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Kolon kolon = (Kolon) value;
        return Integer.toString(kolon.getId());
    }

    public KolonDAO getKolonDao() {
        if(kolonDao==null)
            kolonDao =new KolonDAO();
        return kolonDao;
    }
    
    
}
