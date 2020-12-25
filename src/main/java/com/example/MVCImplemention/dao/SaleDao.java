package com.example.MVCImplemention.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.MVCImplemention.model.Sale;
import com.example.MVCImplemention.repository.SaleRepository;


@Repository
public class SaleDao implements SaleRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Sale> getSaleList() {
		// TODO Auto-generated method stub
		
		String sql = "Select * from sales";
		List<Sale> listSale = jdbcTemplate.query(
								sql, 
								BeanPropertyRowMapper.newInstance(Sale.class));
		return listSale;
	}

	@Override
	public void save(Sale sale) {
		// TODO Auto-generated method stub
		String sql = "insert into sales (item,quantity,amount) values(?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] {
					sale.getItem(),
					sale.getQuantity(),
					sale.getAmount()
					},
				new int[] {
					Types.VARCHAR,
					Types.INTEGER,
					Types.FLOAT
					}
				);
	}
	
	public Sale get(int id) {
	    String sql = "SELECT * FROM SALES WHERE id = ?";
	    Object[] args = {id};
	    Sale sale = jdbcTemplate.queryForObject(sql, 
	    			args,
	    			new int[] {Types.INTEGER},
	                BeanPropertyRowMapper.newInstance(Sale.class));
	    return sale;
	}

	@Override
	public void update(Sale sale) {
		// TODO Auto-generated method stub
		
		String sql = "Update sales set item=?,quantity=?,amount=? where id=? ";
		jdbcTemplate.update(
				sql,
				new Object[] {
					sale.getItem(),
					sale.getQuantity(),
					sale.getAmount(),
					sale.getId()
					},
				new int[] {
					Types.VARCHAR,
					Types.INTEGER,
					Types.FLOAT,
					Types.INTEGER
					}
				);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from sales where id = ?";
		jdbcTemplate.update(sql,id);
		
	}

}
