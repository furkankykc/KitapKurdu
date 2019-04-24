/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.RafDAO;
import Entity.Raf;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author KursadArslan
 */
@FacesConverter(value = "rafConverter")
public class RafConverter implements Converter{

    private RafDAO rafDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Raf raf = this.getRafDao().get(Integer.valueOf(value));
        
        return raf;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Raf raf = (Raf) value;
        return Integer.toString(raf.getId());
    }

    public RafDAO getRafDao() {
        if(rafDao==null)
            rafDao =new RafDAO();
        return rafDao;
    }
    
    
}
