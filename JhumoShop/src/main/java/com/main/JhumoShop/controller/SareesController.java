package com.main.JhumoShop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.JhumoShop.midelData.Sarees;
import com.main.JhumoShop.repo.SareesRepo;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="sarees")
public class SareesController {
	private byte[] bytes;
	@Autowired
	private SareesRepo sareeRepo;
	
	@GetMapping("/get")
	public List<Sarees>getSarees(){
		return sareeRepo.findAll();
		
	}
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException{
		this.bytes=file.getBytes();
	}
	@PostMapping("/add")
	public void createSaree(@RequestBody Sarees saree)throws IOException{
		saree.setPicByte(this.bytes);
		sareeRepo.save(saree);
		this.bytes=null;
	}
	@PutMapping("/update")
	public void updateSaree(@RequestBody Sarees saree){
		sareeRepo.save(saree);
	}
	@DeleteMapping(path={"{id}"})
	public Sarees deleteSaree(@PathVariable("id")long id){
		Sarees saree= sareeRepo.getOne(id);
		return saree;
	}
}
