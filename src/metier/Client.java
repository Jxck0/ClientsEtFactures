package metier;

import java.util.ArrayList;
import java.util.List;

public class Client
{
	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */
	private String nom;
	private ArrayList<Facture> f = new ArrayList<>();
	private List<Facture> list = new ArrayList<>();
	
	public Client(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant)
	{
		Facture f = new Facture(montant, this);
		add(f);
		return f;
	}
	
	/**
	 * Retourne une copie de la liste des factures du client. 
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		List<Facture> list = new ArrayList<>();
		return list;
	}
	
	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */
	
	public int sommeMontants()
	{
		int montant = 0;
		for(int i = 0 ; i<list.size(); i++)	
		{
			montant = montant + (list.get(i)).getMontant();
		}
		return montant;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * @param montant Le montant de la facture.
	 * @param reglée Vrai si la facture est reglée.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant, boolean reglee)
	{
		Facture f = new Facture(montant,reglee, this);
		add(f);
		return f;
	}	
	
	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */

	public List<Facture> facturesReglees()
	{
		List<Facture> list = new ArrayList<>();
		Facture f;
		for(int i = 0; i<list.size(); i++)
		{
			f = f + (list.get(i));
			if(f.estReglee())
			{
				list.add(f);
			}
		}
		return list;
	}
	

	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */
	private static List<Client> listClient = new ArrayList<>();
	public static List<Client> tous()
	{
		return listClient;
	}
	
	/**
	 * Supprime le client.
	 */
	
	public void delete()
	{
		listClient.remove(this);
	}
}
