package com.example.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Produit;

public interface ProduitMetier {
	public Produit saveProduit(Produit p);
	public Page<Produit> listProduits(int page , int size);
	public Produit getProduit(Long id);
	public Produit updateProduit(Produit p, Long id);
	public void deleteProduit(Long id);
	public Page<Produit> chercher(String mc, int page ,int size);

}
