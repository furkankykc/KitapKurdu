/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.DepoDAO;
import Entity.Depo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author KursadArslan
 */
@FacesConverter(value = "depoConverter")




public class DepoConverter implements Converter{

    private DepoDAO depoDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Depo depo = this.getDepoDao().get(Integer.valueOf(value));
        
        return depo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Depo depo = (Depo) value;
        return Integer.toString(depo.getId());
    }

    public DepoDAO getDepoDao() {
        if(depoDao==null)
            depoDao =new DepoDAO();
        return depoDao;
    }
    
    
}
