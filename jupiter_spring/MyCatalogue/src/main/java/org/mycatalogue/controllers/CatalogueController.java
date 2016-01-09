package org.mycatalogue.controllers;

import java.util.List;

import org.mycatalogue.entities.Produit;
import org.mycatalogue.repository.ProduitReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogueController {
	
	@Autowired
	private ProduitReository produitRepository;
	
	@RequestMapping("/save")
	public Produit saveProduit(Produit p){
		return produitRepository.save(p);
	}

	@RequestMapping("all")
	public List<Produit> getProduits(){
		return produitRepository.findAll();
	}
	
	@RequestMapping("/produits")
	public Page<Produit> getProduits(int page){
		return produitRepository.findAll(new PageRequest(page,5));
	}
	

	@RequestMapping("/produitsParMC")
	public Page<Produit> getProduits(String mc, int page){
		return produitRepository.produitParMC("%"+mc+"%", new PageRequest(page, 5));
	}
}
