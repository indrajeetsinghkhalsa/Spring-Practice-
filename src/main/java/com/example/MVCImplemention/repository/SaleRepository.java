package com.example.MVCImplemention.repository;

import java.util.List;

import com.example.MVCImplemention.model.Sale;

public interface SaleRepository {
	public List<Sale> getSaleList();
	
	public void save(Sale sale);
	
	public void update(Sale sale);
	
	public void delete(int id);
	
	public Sale get(int id);

}
