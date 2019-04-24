package Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KursadArslan
 */
    
import Entity.Kullanici;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

        public static void setUserId(Kullanici kullanici){
            HttpSession session = getSession();
            if(kullanici!=null)
                session.setAttribute("userid", kullanici.getAdi());
                session.setAttribute("isAdmin", kullanici.getType());
        }

	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("userid");
		else
			return null;
	}
            public static Boolean isAdmin() {
		HttpSession session = getSession();
                    if(session.getAttribute("isAdmin")!=null)
			if((int)session.getAttribute("isAdmin")==1)
                            return true;
            
                return false;
}
            public static Boolean isLoggedin() {
		HttpSession session = getSession();
                    if(session.getAttribute("userid")!=null)
                            return true;
            
                return false;
}

}
 