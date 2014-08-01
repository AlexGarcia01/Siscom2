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
import javax.faces.model.DataModel;
import javax.servlet.http.HttpServletRequest;
import jpa.ent.Password;
import jpa.ent.Usuarios;
import org.jboss.weld.bean.builtin.ee.HttpServletRequestBean;
import org.jboss.weld.context.http.HttpRequestContext;

/**
 *
 * @author siscom
 */
@ManagedBean
@RequestScoped
public class MbLogin {
     
    private String user;
    private String pass;
    private final HttpServletRequest httpServlerRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    
    public MbLogin() {
        faceContext=FacesContext.getCurrentInstance();
        httpServlerRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
    }
    
    public String login(){
      
        // hacer una consulta
        
        
        if(user.equals("admin")&&pass.equals("root") )
        {
        httpServlerRequest.getSession().setAttribute("sessionUsuario", user);
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario: "+user,null);
        faceContext.addMessage(null, facesMessage);
        
        return "MenuAdmin";
        }else{
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o Password incorrectos",null);
        faceContext.addMessage(null, facesMessage);
        return "index";
        }
       
    
    
    }
    
  

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    
}
