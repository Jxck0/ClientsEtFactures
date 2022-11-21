package metier;

import java.time.LocalDate;

public class Facture
{
	/**
	 * Retourne le client à qui est adressée la facture..
	 * @return le client.
	 */
	private Client client;
	private int montant;
	private boolean reglee;
	private LocalDate date;
	
	public Facture(int montant, Client client)throws IllegalArgumentException
	{
		if(montant>=0)
		{
			montantFacture  = montant;
			this.client = client;
			date = LocalDate.now();
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	public Facture(int montant, boolean reglement, Client client) throws IllegalArgumentException
	{
		if(montant>=0)
		{
			montantFacture  = montant;
			reglementFacture = reglement;
			this.client = client;
			date = LocalDate.now();
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	public Facture(int montant, boolean reglement, Client client, LocalDate date )throws IllegalArgumentException
	{
		if(montant>=0)
		{
			montantFacture  = montant;
			reglementFacture = reglement;
			this.client = client;
			this.date = date;
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}
	public Facture(Facture f )throws IllegalArgumentException
	{
		if(f.montantFacture>=0)
		{
			montantFacture  = f.montantFacture;
			reglementFacture = f.reglementFacture;
			this.client = f.client;
			this.date = f.date;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}


	public Client getClient()
	{
		return client;
	}

	/**
	 * Retourne le montant de la facture.
	 * @return le montant de la facture.
	 */
	
	public int getMontant()
	{
		return this.montant;
	}

	/**
	 * Retourne vrai si la facture est reglée.
	 * @return vrai ssi la facture est reglée.
	 */
	
	public boolean estReglee()
	{
		return this.reglee;
	}

	/**
	 * Retourne la date de la facture.
	 * @return la date de la facture.
	 */
	
	public LocalDate getDate()
	{
		return this.date;
	}

	/**
	 * Supprime la facture
	 */
	
	public void delete()
	{
		client.remove(this);
	}
	
	/**
	 * Duplique la facture.
	 * @return une copie de la facture.
	 */
	
	public Facture copie()
	{
		return client.createFacture(this.montant);
	}
}