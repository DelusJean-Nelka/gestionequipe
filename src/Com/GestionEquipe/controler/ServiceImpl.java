/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.GestionEquipe.controler;

 
import Com.GestionEquipe.Dao.Mysqlconnect;
import Com.GestionEquipe.Metier.Membre;
import Com.GestionEquipe.Metier.Tache;
import Com.GestionEquipe.Metier.Tachemembre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delus-jean-nelka
 */
public class ServiceImpl implements  ServiceIlocal{
public static Connection conn= Mysqlconnect.connectDB();
//		Ajouter un Membre
	    public static java.sql.Statement st;
           
    @Override
    public String Ajoutermembre(Membre ta) {
        //Requete d'insertion
		String req = "insert into membre values('"+ta.getId()+"','"+ta.getNom()+"','"+ta.getPrenom()+"','"+ta.getAdress()+"','"+ta.getTelephone()+"','"+ta.getEmail()+"')";  
		  
	  	  int verif = 0;
	  	   String rep="";
	  	       try {
	  	          st =conn.createStatement();
	  	           verif=st.executeUpdate(req);
	  	           if(verif!=0)
	  	           {
	  	           rep="valider";
	  	           }
		} catch (SQLException e) {
			rep="Erreur de " +e.getMessage();
			// TODO: handle exception
			 
		}
	  	       return rep;
     
    }

    @Override
    public String Modifiermembre(Membre ta) {
        				String req="Update membre set nom='"+ta.getNom()+"',prenom='"+ta.getPrenom()+"',adress='"+ta.getAdress()+"',telephone='"+ta.getTelephone()+"',email='"+ta.getEmail()+"' where IDmembre='"+ta.getId()+"'";
				        int verif = 0;
				        String  repons="";
				        try
				        {  
				        st=conn.createStatement();
				        verif = st.executeUpdate(req);
				        repons="valider";
				        }  
				        catch(SQLException e)
				        {
				        repons="Erreur de:"+e.getMessage(); 
				        System.err.println("Erreur de! "+e.getMessage());
				        }
				        return repons;
    }
    @Override
	public Membre RechercherMembre(int id) {
		// TODO Auto-generated method stub
		Membre membre=new Membre();;
		String repons="";
		 try {
	            ResultSet rs;
	            st=conn.createStatement();
	            rs = st.executeQuery("select * from membre where IDmembre='"+id+"'");
	            if(rs.next()) {
	            	
	                membre.setId(rs.getInt("IDmembre"));
	                membre.setNom(rs.getString("Nom"));
	                membre.setPrenom(rs.getString("Prenom"));
	                membre.setAdress(rs.getString("Adress"));
	                membre.setTelephone(rs.getString("Telephone"));
	                membre.setEmail(rs.getString("Email"));
	                /*meta=new Metare(rs.getInt("metareID"), rs.getString("metareNom"), rs.getString("metarePrenom"),
	                		rs.getString("metareAdress"), rs.getString("metareTel"), rs.getString("metareEmail"));*/
	                repons="valider";
	               
	            }
	        } catch (SQLException e) {
	        	System.err.println("Erreur de! "+e.getMessage());
	        }
		 
		 return membre;
	}

	@Override
	public List<Membre> ListerMembre() {
		// TODO Auto-generated method stub
		          List<Membre> listemembre=new ArrayList<>();
		 Membre membre;
		 try {
	                    ResultSet rs;
	            st=conn.createStatement();
	            rs = st.executeQuery("select * from membre");
	            while (rs.next() ) {
	             	 
	                membre=new Membre(rs.getInt("IDmembre"), rs.getString("Nom"), rs.getString("Prenom"),
	                		rs.getString("Adress"), rs.getString("Telephone"), rs.getString("Email"));
	                
	                listemembre.add(membre);
	            }
	        } catch (SQLException e) {
	            System.err.println("Erreur de! "+e.getMessage());
	        }
		 
		 return listemembre;
	}
	@Override
	public String SupprimerMembre (int id) 
	{
		String rep="";
		try {
		String req ="delete from membre where IDmembre='"+id+"'";
		st=conn.createStatement();
        st.executeUpdate(req);
        
        rep="valider";
        } catch (SQLException e) {
        	System.err.println("Erreur de! "+e.getMessage());
        }
		return rep;
	}

    @Override
    public String AjouterTache(Tache ta) {
       String req = "insert into tache values('"+ta.getId()+"','"+ta.getNom()+"','"+ta.getDescription()+"','"+ta.getDatedebut()+"','"+ta.getDatefin()+"','"+ta.getEtat()+"')";  
		  
	  	  int verif = 0;
	  	   String rep="";
	  	       try {
	  	          st =conn.createStatement();
	  	           verif=st.executeUpdate(req);
	  	           if(verif!=0)
	  	           {
	  	           rep="valider";
	  	           }
		} catch (SQLException e) {
			rep="Erreur de " +e.getMessage();
			// TODO: handle exception
			 
		}
	  	       return rep;
    }

    @Override
    public String ModifierTache(Tache ta) {
        String req="Update Tache set Nom='"+ta.getNom()+"',description='"+ta.getDescription()+"',datedebut='"+ta.getDatedebut()+"',datefin='"+ta.getDatefin()+"',etat='"+ta.getEtat()+"' where IDtache='"+ta.getId()+"'";
				        int verif = 0;
				        String  repons="";
				        try
				        {  
				        st=conn.createStatement();
				        verif = st.executeUpdate(req);
				        repons="valider";
				        }  
				        catch(SQLException e)
				        {
				        repons="Erreur de:"+e.getMessage(); 
				        System.err.println("Erreur de! "+e.getMessage());
				        }
				        return repons;
    }

    @Override
    public Tache RechercherTache(int id) {
       Tache tache=new Tache();
		String repons="";
		 try {
	            ResultSet rs;
	            st=conn.createStatement();
	            rs = st.executeQuery("select * from tache where IDtache='"+id+"'");
	            if(rs.next()) {
	            	
	                tache.setId(rs.getInt("IDtache"));
	                tache.setNom(rs.getString("nom"));
	                tache.setDescription(rs.getString("description"));
	                tache.setDatedebut(rs.getString("datedebut"));
	                tache.setDatefin(rs.getString("datefin"));
	                tache.setEtat(rs.getString("etat"));
	              
	                repons="valider";
	               
	            }
	        } catch (SQLException e) {
	        	System.err.println("Erreur de! "+e.getMessage());
	        }
		 
		 return tache;
    }

    @Override
    public List<Tache> ListerTache() {
       // TODO Auto-generated method stub
		          List<Tache> listetache=new ArrayList<>();
		 Tache tache;
		 try {
	                    ResultSet rs;
	            st=conn.createStatement();
	            rs = st.executeQuery("select * from tache");
	            while (rs.next() ) {
	             	 
	                tache=new Tache(rs.getInt("IDtache"), rs.getString("nom"), rs.getString("description"),
	                		rs.getString("datedebut"), rs.getString("datefin"), rs.getString("etat"));
	                
	                listetache.add(tache);
	            }
	        } catch (SQLException e) {
	            System.err.println("Erreur de! "+e.getMessage());
	        }
		 
		 return listetache;
    }

    @Override
    public String SupprimerTache(int id) {
       String reponse="";
		try {
		String req ="delete from tache where IDtache='"+id+"'";
		st=conn.createStatement();
        st.executeUpdate(req);
        
        reponse="Supprimer";
        } catch (SQLException e) {
        	System.err.println("Erreur de! "+e.getMessage());
        }
		return reponse;
    }
@Override
     public String AjouterTachemembre(Tachemembre tachm)
     {
        String req = "insert into tachemembre values('"+tachm.getIdtachmembre()+"','"+tachm.getMembreid()+"','"+tachm.getTacheid()+"')";  
		  
	  	  int verif = 0;
	  	   String rep="";
	  	       try {
	  	          st =conn.createStatement();
	  	           verif=st.executeUpdate(req);
	  	           if(verif!=0)
	  	           {
	  	           rep="valider";
	  	           }
		} catch (SQLException e) {
			rep="Erreur de " +e.getMessage();
			// TODO: handle exception
			 
		}
	  	       return rep;  
         
     }
     @Override
    public List<Tache> ListerTachemembre(int id) {
       // TODO Auto-generated method stub
		          List<Tache> listetache=new ArrayList<>();
		 Tache tache;
		 try {
	                    ResultSet rs;
	            st=conn.createStatement();
	            rs = st.executeQuery("select * from tachemembre inner join tache on tacheid=IDtache where membreid='"+id+"' ");
	            while (rs.next() ) {
	             	 
	                tache=new Tache(rs.getInt("IDtache"), rs.getString("nom"), rs.getString("description"),
	                		rs.getString("datedebut"), rs.getString("datefin"), rs.getString("etat"));
	                
	                listetache.add(tache);
	            }
	        } catch (SQLException e) {
	            System.err.println("Erreur de! "+e.getMessage());
	        }
		 
		 return listetache;
    }
}
