package com.example.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;
@Service
public class ProduitMetierImpl implements ProduitMetier{

	@Autowired
	private ProduitRepository produitRepository; 
	@Override
	public Produit saveProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public Page<Produit> listProduits(int page , int size) {
		// TODO Auto-generated method stub
		return produitRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findOne(id);
	}

	@Override
	public Produit updateProduit(Produit p, Long id) {
		// TODO Auto-generated method stub
		return produitRepository.saveAndFlush(p);
	}

	@Override
	public void deleteProduit(Long id) {
		produitRepository.delete(id);
		
	}

	@Override
	public Page<Produit> chercher(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return produitRepository.chercherProduits("%"+mc+"%", new PageRequest(page, size));
	}

}
