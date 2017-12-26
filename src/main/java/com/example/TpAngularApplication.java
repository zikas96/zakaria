package com.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;

@SpringBootApplication
public class TpAngularApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(TpAngularApplication.class, args);
		ProduitRepository produitRepository=ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("HX 564", 900,23));
		produitRepository.save(new Produit("LX 5", 500,3));
		produitRepository.save(new Produit("Ls 52", 588,700));
		
	}
}
