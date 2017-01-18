package ec.gob.educacion.acceso.utils;


import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;

import ec.gob.educacion.acceso.controller.BaseController;
import ec.gob.educacion.acceso.resources.Utils;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
 
/**
* @author 
* Clase de Conexion Servidor LDAP
*/
 
public class ConexionLdap extends BaseController {
 
     private DirContext ctx;
    
 
     public ConexionLdap() {
     }
 
     
 
     public void CerrarConLDAP(LDAPConnection lc) {
          try {
               lc.disconnect();
               System.out.println("Conexion Cerrada Correctamente...");
          } catch (LDAPException ex) {
               Logger.getLogger(ConexionLdap.class.getName()).log(Level.SEVERE,null, ex);
          } 
     }
     
     
     public void updatePassword(String userDn, String passwordValue, String mailValue) { 
    	 String host = Utils.obtenerPropiedad("ldap.host");
    	 String user = Utils.obtenerPropiedad("ldap.user.admin");
    	 String password = Utils.obtenerPropiedad("ldap.user.password");
    	 try { 
    		 DirContext context = connectToLDAP(host, user, password);
    		 String quotedValue = "\"" + passwordValue + "\""; 
    		 char unicodePwd[] = quotedValue.toCharArray(); 
    		 byte pwdArray[] = new byte[unicodePwd.length * 2]; 
    		 for (int i=0; i<unicodePwd.length; i++) { 
    			 pwdArray[i*2 + 1] = (byte) (unicodePwd[i] >>> 8); 
    			 pwdArray[i*2 + 0] = (byte) (unicodePwd[i] & 0xff); 
    		 } 		 
    		 
    		 ModificationItem[] mods = new ModificationItem[3]; 
    		 mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("description", "Desarrollador de sotfware"));
    		 mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("otherTelephone", mailValue));//otherTelephone
    		 mods[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("unicodePwd", passwordValue));//otherTelephone
    		
    		 context.modifyAttributes(userDn, mods);
    		 agregarMensajeInformacion("Su clave ha sido enviada a su correo electrónico proporcionado", "");
    	 } 
    	 catch (Exception e) { 
    		 System.out.println("update password error: " + e); 
    		 //System.exit(-1); 
    	 } 

     }
          



     public static DirContext connectToLDAP(String url, String user, String password) throws NamingException{
    	 Hashtable<String, String> env = new Hashtable<String, String>();
    	 env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    	 env.put(Context.PROVIDER_URL, url);
    	 env.put(Context.SECURITY_AUTHENTICATION,"simple");
    	 env.put(Context.SECURITY_PRINCIPAL, user);
    	 env.put(Context.SECURITY_CREDENTIALS,password);
    	 env.put(Context.REFERRAL, "follow");
    	 //Conseguimos contexto de conexion
    	 try {	
    		 DirContext dctx = new InitialDirContext(env);	 
    		 System.out.println("Conectado correctamente a "+user);
    		 return dctx;

    	 } catch (Exception ex) {
    		 System.out.println(ex);    		 
    		 return null;
    	 }  	
    	 
     }

     
     

     @SuppressWarnings("rawtypes")
	public NamingEnumeration search (String search, String filter, String[] returningAtts) throws NamingException{ 
    	 DirContext context = connectToLDAP("ldap://10.2.30.81:389", "recuperacionad@educacion.local", "Rad123123");
    	 SearchControls ctls = new SearchControls();
    	 ctls. setReturningObjFlag (true); // Para que devuelva los elementos que buscamos
    	 //Asignamos los atributos a devolver
    	 ctls.setReturningAttributes(returningAtts);
    	 ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    	 NamingEnumeration answer = context.search(search,filter, ctls);  
    	 context.close();
    	 return answer;
     }
     
     

    
     
     /**
      * Getters and setters
      * @return
      */
     

	public DirContext getCtx() {
		return ctx;
	}

	public void setCtx(DirContext ctx) {
		this.ctx = ctx;
	}

     
     
     
     
}
