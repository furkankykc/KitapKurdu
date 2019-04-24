/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.TurDAO;
import Entity.Tur;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author KursadArslan
 */
@FacesConverter(value ="turConverter")

public class TurConverter implements Converter {
private TurDAO turDao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getTurDao().get(Integer.valueOf(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Tur tur = (Tur) value; 
    return Integer.toString(tur.getId());
    }
    public TurDAO getTurDao() {
        if(turDao==null)
            turDao =new TurDAO();
        return turDao;
    }
    }
    

