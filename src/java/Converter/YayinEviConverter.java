/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.YayinEviDAO;
import Entity.YayinEvi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author KursadArslan
 */
@FacesConverter(value = "yayinEviConverter")
public class YayinEviConverter implements Converter{

    private YayinEviDAO yayinEviDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getYayinEviDao().get(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        YayinEvi yayinEvi = (YayinEvi) value;
        return Integer.toString(yayinEvi.getId());
    }

    public YayinEviDAO getYayinEviDao() {
        if(yayinEviDao==null)
            yayinEviDao =new YayinEviDAO();
        return yayinEviDao;
    }
    
    
}
