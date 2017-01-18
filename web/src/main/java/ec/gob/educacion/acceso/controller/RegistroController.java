package ec.gob.educacion.acceso.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import ec.gob.educacion.acceso.dto.PersonaCedulado;
import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.acceso.utils.ConexionLdap;
//import ec.gob.educacion.acceso.utils.MailUtils;
import ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivil;
import ec.gob.educacion.servicios.registro_civil_sw.ServicioWebRegistroCivil.ServicioWebRegistroCivilProxy;
//import ec.gob.educacion.seguridades.dao.ClaveUsuarioDAO;



/**
 * 
 * @author 
 *
 */
@Named
@ViewScoped
public class RegistroController extends BaseController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String ROWSET_OPEN_TAG = "<ROWSET>";
    public static final String ROWSET_CLOSE_TAG = "</ROWSET>";
    public static final String ROW_TEXT = "ROW";
    public static final String ROW_OPEN_CLOSE_TAG = "<ROW/>";
	
	 
	
	
	

	private String mensajeRegistroExitoso;
	private String picoPLacaMensaje;
	
	private String mensajeValidacion;
	private Boolean activarValidacion;
	private boolean link = false;
	
	private String usuarioLdap;	
	private String mailMineduc;
	private String usuarioMineduc;
	private String nombreUsuarioMineducLDAP;
	private String mailAlternativo;
	private String validadorDigital;
	private String confirmMailAlternativo;
	private String fechaNacimiento;
	private String userDistinguishedNameLDAP;
	private PersonaCedulado persona; 
	private String cedulaUsuario;
	private String postalCodeLDAP;
	private String mailPersonalDAP;
	private Date fechaNac;
	private String destinatario;
	private String asunto;
	private String texto;
	
	private String nuevoPassword;
	
	
	

	@PostConstruct
    private void init() {
		activarValidacion=false;
		persona = new PersonaCedulado();
	
    }
	
	
    public boolean isPasswordsEquals() {
        return mailAlternativo.equals(confirmMailAlternativo);
    }
	    
	
	/**
	 * Metodo que permite buscar el usuario en el active directory
	 */
	public void obtenerDatosPersonales() {
		ConexionLdap conexionLdap = new ConexionLdap();
		
		String[] criterios = {"postalCode", "mail", "cn", "unicodePwd", "otherMailbox", "title", "distinguishedName", "otherTelephone"};

		try {
			NamingEnumeration answer = conexionLdap.search("DC=educacion,DC=local", "sAMAccountName="+usuarioLdap, criterios);//sAMAccountName=
			if (answer.hasMore()) {
	              Attributes attrs = ((SearchResult) answer.next()).getAttributes();    
	              
	              Attribute cn = attrs.get("cn"); 
	              Attribute dn = attrs.get("distinguishedName"); 
	              Attribute postalCode = attrs.get("postalCode");
	              Attribute mailPersonal = attrs.get("otherMailbox");
	              Attribute mail = attrs.get("mail");
	               
	              nombreUsuarioMineducLDAP =  asignVlaue(cn);
	              userDistinguishedNameLDAP = asignVlaue(dn);	
	              postalCodeLDAP = asignVlaue(postalCode);
	              mailPersonalDAP = asignVlaue(mailPersonal);
	              
	              	     		  
	     		  System.out.println(userDistinguishedNameLDAP);
	          }else{
	        	  agregarMensajeError("El usuario no pertenece al Ministerio de Educación.", "");
	          }
			
		} catch (Exception e) {
			agregarMensajeError("El usuario no pertenece al Ministerio de Educación.", "");
			e.printStackTrace();
		}
		
	}
	
	public String asignVlaue(Attribute value){
		if(value != null && value.size() > 0){
			try {
				return (String)value.get(0);
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}else{
			return null;
		}
	}
	
	
	public PersonaCedulado cambiarXMLPersonaAPersona(String xml) {
        XStream stream = new XStream(new DomDriver());
        stream.autodetectAnnotations(Boolean.TRUE);
        stream.alias(ROW_TEXT, PersonaCedulado.class);
        stream.processAnnotations(PersonaCedulado.class);
        xml = xml.replace(ROWSET_OPEN_TAG, "");
        xml = xml.replace(ROWSET_CLOSE_TAG, "");
        return (PersonaCedulado) stream.fromXML(xml);
  }
	
	/**
	 * Metodo que permite iniciar los mensajes q se presentan en pantalla.
	 */
	public void iniciarMensajes(){
		activarValidacion=false;
		
	}

	/**
	 * Metodo que permite registrar un usuario en el sistema.
	 */
	public void registro(){
		ConexionLdap conexionLdap = new ConexionLdap();
		persona = new PersonaCedulado();
		ServicioWebRegistroCivil servicioRegistroCivil = null;
		ServicioWebRegistroCivilProxy proxy = new ServicioWebRegistroCivilProxy();
		servicioRegistroCivil = proxy.getServicioWebRegistroCivil();
		
		
		String xmlPersona;
		try {
			xmlPersona = servicioRegistroCivil.buscarPersona(cedulaUsuario);
			persona = cambiarXMLPersonaAPersona(xmlPersona);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		if(isPasswordsEquals()){
			if(persona.getCEDULA() != null){
				if(persona.getFECHA_NACIMIENTO().equals(fechaNacimiento)){
					conexionLdap.updatePassword(userDistinguishedNameLDAP, "JG0609ter" , mailAlternativo);
					generarPassword(nombreUsuarioMineducLDAP);
					try {
						destinatario = mailAlternativo;
						//enviarMail();
					} catch (Exception e) {
						agregarMensajeError("Error al enviar el correo electrónico.", "");
						e.printStackTrace();
					}
					
				}else{
					agregarMensajeError("La fecha de nacimiento en incorrecta.", "");
				}				
			}else{
				agregarMensajeError("El número de cédula es incorrecto.", "");
			}			
		}else{
			agregarMensajeError("El correo alternativo es diferente.", "");
		}
		
				
	}
	
	public String generarPassword(String nombres){
		String password = null;
		int numeroAleatorio = (int) (Math.random()*99999+1);
		String strNumero = String.valueOf(numeroAleatorio);
		
		StringBuilder numero = new StringBuilder();
		StringBuilder nombre = new StringBuilder();
		numero.append(strNumero);
		for ( int i=0;i < 5;i++) {
			if(numero.length() < 5){
				numero.append( "0");
			}		  
		}
		
		String nombresArray[]  = nombres.split(" ");
		nombre.append(nombresArray[0].substring(0,1));
		nombre.append(nombresArray[1].substring(0,1));
		
		nombre.append(numero);
		System.out.println("numero aleatori:::::"+nombre);
		nuevoPassword = nombre.toString();
		return nuevoPassword;
	}
	
	public void recuperarClave() {
		
		
	}
	
		
	public void ingresarSistema(){
		redireccionarPagina("/logout");
	}
	
	
	

//	public void enviarMail() throws Exception {
//		{
//			//setearPropiedades();
//			try {
//				MailUtils mailUtils = new MailUtils(destinatario, "Recuperacion de clave", construirMensaje());
//				mailUtils.start();
//				
//			}
//			catch (Exception e){
//				
//				e.printStackTrace();
//			}
//		}
//	}

	
	
	public String construirMensaje() {
        String texto="";        
        // texto = Utils.obtenerPropiedad("parametro.texto.mail.clave");//10.200.8.25
        texto = "Estimado/a "+ nombreUsuarioMineducLDAP +", <br/><br/> Su nueva clave de acceso es la siguiente: "+nuevoPassword+"  <br/><br/> Ministerio de Educaci&oacute;n.";
        return texto;
    }
	
	

	

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
		
	public String getPicoPLacaMensaje() {
		return picoPLacaMensaje;
	}

	public void setPicoPLacaMensaje(String picoPLacaMensaje) {
		this.picoPLacaMensaje = picoPLacaMensaje;
	}

	public String getMensajeValidacion() {
		return mensajeValidacion;
	}

	public void setMensajeValidacion(String mensajeValidacion) {
		this.mensajeValidacion = mensajeValidacion;
	}

	public String getMensajeRegistroExitoso() {
		return mensajeRegistroExitoso;
	}

	public void setMensajeRegistroExitoso(String mensajeRegistroExitoso) {
		this.mensajeRegistroExitoso = mensajeRegistroExitoso;
	}

	public Boolean getActivarValidacion() {
		return activarValidacion;
	}

	public void setActivarValidacion(Boolean activarValidacion) {
		this.activarValidacion = activarValidacion;
	}	

	
	public boolean getLink() {
		return link;
	}

	public void setLink(boolean link) {
		this.link = link;
	}

	public String getUsuarioLdap() {
		return usuarioLdap;
	}

	public void setUsuarioLdap(String usuarioLdap) {
		this.usuarioLdap = usuarioLdap;
	}

	public String getMailMineduc() {
		return mailMineduc;
	}

	public void setMailMineduc(String mailMineduc) {
		this.mailMineduc = mailMineduc;
	}

	public String getUsuarioMineduc() {
		return usuarioMineduc;
	}

	public void setUsuarioMineduc(String usuarioMineduc) {
		this.usuarioMineduc = usuarioMineduc;
	}

	
	public String getMailAlternativo() {
		return mailAlternativo;
	}

	public void setMailAlternativo(String mailAlternativo) {
		this.mailAlternativo = mailAlternativo;
	}

	public String getValidadorDigital() {
		return validadorDigital;
	}

	public void setValidadorDigital(String validadorDigital) {
		this.validadorDigital = validadorDigital;
	}

	public String getConfirmMailAlternativo() {
		return confirmMailAlternativo;
	}

	public void setConfirmMailAlternativo(String confirmMailAlternativo) {
		this.confirmMailAlternativo = confirmMailAlternativo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	public PersonaCedulado getPersona() {
		return persona;
	}

	public void setPersona(PersonaCedulado persona) {
		this.persona = persona;
	}

	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getNombreUsuarioMineducLDAP() {
		return nombreUsuarioMineducLDAP;
	}

	public void setNombreUsuarioMineducLDAP(String nombreUsuarioMineducLDAP) {
		this.nombreUsuarioMineducLDAP = nombreUsuarioMineducLDAP;
	}

	public String getUserDistinguishedNameLDAP() {
		return userDistinguishedNameLDAP;
	}

	public void setUserDistinguishedNameLDAP(String userDistinguishedNameLDAP) {
		this.userDistinguishedNameLDAP = userDistinguishedNameLDAP;
	}

	public String getPostalCodeLDAP() {
		return postalCodeLDAP;
	}

	public void setPostalCodeLDAP(String postalCodeLDAP) {
		this.postalCodeLDAP = postalCodeLDAP;
	}

	public String getMailPersonalDAP() {
		return mailPersonalDAP;
	}

	public void setMailPersonalDAP(String mailPersonalDAP) {
		this.mailPersonalDAP = mailPersonalDAP;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNuevoPassword() {
		return nuevoPassword;
	}

	public void setNuevoPassword(String nuevoPassword) {
		this.nuevoPassword = nuevoPassword;
	}
	
	
	
}
