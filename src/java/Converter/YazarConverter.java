/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.YazarDAO;
import Entity.Yazar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author KursadArslan
 */
@FacesConverter(value="yazarConverter")

public class YazarConverter implements Converter {
private YazarDAO yazarDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getYazarDao().get(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Yazar yazar = (Yazar) value;
        return Integer.toString(yazar.getId());
    }

    public YazarDAO getYazarDao() {
        if(yazarDao==null)
            yazarDao =new YazarDAO();
        return yazarDao;
    }
    
    
    
}
