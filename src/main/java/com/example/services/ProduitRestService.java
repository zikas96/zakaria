package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;
import com.example.metier.ProduitMetier;
@RestController
public class ProduitRestService {
	@Autowired
	private ProduitMetier prduitMetier;
	@RequestMapping(value="produits",method=RequestMethod.POST)

	public Produit saveProduit(@RequestBody Produit p) {
		return prduitMetier.saveProduit(p);
	}
	@RequestMapping(value="produits",method=RequestMethod.GET)
	public Page<Produit> listProduits(int page , int size) {
		return prduitMetier.listProduits(page , size);
	}
	@RequestMapping(value="/chercherProduits",method=RequestMethod.GET)
	public Page<Produit> chercher(
			String mc, 
			@RequestParam(name="page", defaultValue="0")int page ,
			@RequestParam(name="size", defaultValue="5")int size) {
		return prduitMetier.chercher(mc, page, size);
	}
	@RequestMapping(value="produits/{id}",method=RequestMethod.GET)
	public Produit getProduit(@PathVariable("id") Long id) {
		return prduitMetier.getProduit(id);
	}
	@RequestMapping(value="produits/{id}",method=RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit p, @PathVariable("id") Long id) {
		p.setId(id);
		return prduitMetier.updateProduit(p, id);
	}
	@RequestMapping(value="produits/{id}",method=RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id) {
		
		prduitMetier.deleteProduit(id);
	}
	

	
}
