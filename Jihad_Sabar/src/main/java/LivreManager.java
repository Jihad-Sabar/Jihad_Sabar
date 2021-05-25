
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreManager {
	
	public int addLivre(int idLivre, String titre, String auteur,String catégorie) {
		DBInteraction.connect();
		String sql="insert into livre (idLivre,titre,auteur,catégorie) values ("+idLivre+",'"+titre+"','"+auteur+"','"+catégorie+"')";
		int nb= DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;}

    public int deleteLivre(int id)
    {DBInteraction.connect();
    int nb= DBInteraction.Maj("delete from livre where id="+id);
    DBInteraction.disconnect();
    return nb;
    }
    public livre findLivreByCatégorie(String catégorie) 
    {DBInteraction.connect();
    livre l=null ;
      ResultSet rs=DBInteraction.select("select * from livre where catégorie="+catégorie);
    
    try {
		if(rs.next())
		{
		   l = new livre();
		   l.setIdLivre(rs.getInt(1));
		   l.setTitre(rs.getString(2));
		   l.setAuteur(rs.getString(3));
		   l.setCatégorie(rs.getString(4));
		   DBInteraction.disconnect();
 
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	  return l ;
   
	 
    }
    public List<livre> all_livres(){
    List<livre> tabl=new ArrayList<livre>();
    DBInteraction.connect();
    ResultSet rs=DBInteraction.select("select * from livre");
 
		try {
			while(rs.next())
			{livre l=new livre();
			l.setIdLivre(rs.getInt(1));
			l.setTitre(rs.getString(2));
			l.setAuteur(rs.getString(3));
			l.setCatégorie(rs.getString(4));
			tabl.add(l);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
    return tabl;
    
    }



}