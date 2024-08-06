package ec.gob.turismo.convenios.util;


import ec.gob.turismo.convenios.model.User;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LDAP {
	
	String connectionString = "ldap://192.168.20.102:389";
	String baseDN = "ou=people,dc=turismo,dc=gob,dc=ec";
	String findString = "uid=zimbra,cn=admins,cn=zimbra";
	String password = "g5KKKzA5i";

	/*public int autenticarLdap(String username, String password){
		int valido = 0;
		Hashtable<String,String> ldapEnv = new Hashtable<String,String>();
		String findString = "uid=zimbra,cn=admins,cn=zimbra";
		String findPassword = "g5KKKzA5i";
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		ldapEnv.put(Context.SECURITY_PRINCIPAL, findString);
		ldapEnv.put(Context.SECURITY_CREDENTIALS, findPassword);
		ldapEnv.put(Context.PROVIDER_URL, connectionString);
		try {
			//CONEXION CON EL LDAP
			DirContext ctx;
			ctx = new InitialLdapContext(ldapEnv, null);
			SearchControls searchCtls = new SearchControls();
			//ITEMS A TRAER EN EL CASO QUE LO NECESITEMOS
			String returnedAtts[] = { "uid","sn","givenName","mail"};
			searchCtls.setReturningAttributes(returnedAtts);
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String searchFilter = "(uid="+username.toLowerCase()+")";
			NamingEnumeration<SearchResult> results = ctx.search(baseDN, searchFilter, searchCtls);
			while (results.hasMoreElements()){
				SearchResult searchResult = (SearchResult) results.next();
				Attributes attrs = searchResult.getAttributes();
				//OPTENEMOS LA UNIDAD ORGANIZATIVA DEL UID BUSCADO CON SU UID Y LO COMPLETAMOS CON LA BASE
				String dn = searchResult.getName()+","+baseDN;
				if (attrs != null){
					//EL UID EXISTE AHORA VALIDAR PASSWORD
					valido = validarAuth(dn,password);
					//SI VALIDO ES "0" PASSWORD INCORRECTO, SI ES "1" PASSWORD CORRECTO
				}
			}
			ctx.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		//RETORNAMOS EL VALOR A QUIEN LO LLAMO SIENDO POR DEFECTO "0" EN EL CASO DE QUE EL UID NO EXISTA O PASSWORD INVALIDO
		return valido;
	}

	private int validarAuth(String dn,String password){
		int valido = 0;
		Hashtable<String,String> env = new Hashtable<String,String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, dn);
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.PROVIDER_URL, connectionString);
		DirContext ctx1;
		try {
			ctx1 = new InitialLdapContext(env, null);
			valido = 1;
			ctx1.close();
		} catch (NamingException e) {
			//e.printStackTrace();
			valido = 0;
		}
		return valido;
	}*/

	public List<User> buscarUsuariosLdap() throws  Exception{

		String accountName = "*";
		String searchFilter = "(userid="+accountName+")";
		List<User> listaUserLdap = new ArrayList<User>();
		String[] usernameSalida = new String[2];
		String[] estado = new String[2];
		String[] mailSalida = new String[2];
		String[] NombreSalida = new String[2];
		String[] ApellidoSalida = new String[2];

		SearchControls ldapCtls = new SearchControls();
		ldapCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		Hashtable<String, String> ldapEnv = new Hashtable<String,String>();
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		ldapEnv.put(Context.PROVIDER_URL, connectionString);
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		ldapEnv.put(Context.SECURITY_PRINCIPAL, findString);
		ldapEnv.put(Context.SECURITY_CREDENTIALS, password);
		ldapEnv.put(LdapContext.CONTROL_FACTORIES, "com.sun.jndi.ControlFactory");
		ldapEnv.put("java.naming.ldap.attributes.binary", "objectSID");
		InitialDirContext ldapCtx = new InitialDirContext(ldapEnv);
		NamingEnumeration<SearchResult> results = ldapCtx.search(baseDN, searchFilter, ldapCtls);

		int i=0;
		if(results.hasMoreElements()) {
			SearchResult searchResult = null;
			Attributes attributes = null;
				while (results.hasMore()) {
					User usuario = new User();
					searchResult = (SearchResult) results.nextElement();
					attributes = searchResult.getAttributes();
					if(attributes.get("zimbramailstatus") != null){
						estado = attributes.get("zimbramailstatus").toString().split(":");
					}else {
						estado[0]="zimbramailstatus";
						estado[1]="disabled";
					}
					if(!estado[1].isEmpty() && estado[1].trim().equalsIgnoreCase("enabled")){
						if(attributes.get("givenName") != null){
							  NombreSalida = attributes.get("givenName").toString().split(":");
						}else {
							  NombreSalida [0]="givenName";
							  NombreSalida [1]="";
						}
						if(attributes.get("uid") != null){
							  usernameSalida = attributes.get("uid").toString().split(":");
						}else {
							  usernameSalida [0]="uid";
							  usernameSalida [1]="";
						}
						if(attributes.get("mail") != null){
							  mailSalida = attributes.get("mail").toString().split(":");
							  mailSalida = mailSalida[1].split(",");
						}else {
							  mailSalida [0]="";
							  mailSalida [1]="";
						}
						if(attributes.get("sn") != null){
							  ApellidoSalida = attributes.get("sn").toString().split(":");
						}else {
							  ApellidoSalida [0]="sn";
							  ApellidoSalida [1]="";
						}

						if(!NombreSalida[1].isEmpty()){
							usuario.setUserName(usernameSalida[1].trim());
							usuario.setEmail(mailSalida[0].trim());
							usuario.setName(NombreSalida[1].trim());
							usuario.setLastName(ApellidoSalida[1].trim());
							listaUserLdap.add(usuario);
						}
						i++;
					}
				}
		}

		ldapCtx.close();

		return listaUserLdap;
	}

}
