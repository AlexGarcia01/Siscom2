/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author siscom
 */
@ManagedBean
@RequestScoped
public final class MbSessiones {

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String usuario;
    private final HttpServletRequest httpServlerRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    
    
    public MbSessiones() {
        faceContext=FacesContext.getCurrentInstance();
        httpServlerRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(!httpServlerRequest.getSession().getAttribute("sessionUsuario").toString().isEmpty())
            usuario= httpServlerRequest.getSession().getAttribute("sessionUsuario").toString();  
        else
            cerrarSession();
            
    }
    
     /*public String compruebaSession() {
      if(httpServlerRequest.getSession().getAttribute("sessionUsuario").toString().isEmpty())
        {
        return "salir";
        
        }    
        else {
            usuario= httpServlerRequest.getSession().getAttribute("sessionUsuario").toString();  
        }
        return null;
        
    }*/
    
    public String cerrarSession(){
        httpServlerRequest.getSession().invalidate();
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Session cerrada correctamente",null);
        faceContext.addMessage(null, facesMessage);
        return "index?faces-redirect=true";
    }
    
    
    
    
}
