package com.example.MVCImplemention.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.MVCImplemention.model.Sale;
import com.example.MVCImplemention.repository.SaleRepository;

@Controller
public class SaleController {
	
	@Autowired
	private SaleRepository saleRepository;
	
	//====== For Display list =========
	@GetMapping("/dashboard")
	public String dashBoard(Model model) {
		List<Sale> listSale = saleRepository.getSaleList();
		model.addAttribute("listSale",listSale);
		return "dashBoard";
		
	}
	
	//=== END ===
	
	
	//====== For Adding new record ======
	
		//====== for show html form========
	@RequestMapping("/new")
	public String showNewForm(Model model)
	{
		Sale sale = new Sale();
		model.addAttribute("sale",sale);
		return "newForm";
	}
	
		//====== for adding new record =====
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("sale") Sale sale) {
	    saleRepository.save(sale);
	      
	    return "redirect:/dashboard";
	}
	//==== END=====
	
	
	// ========= call for upadte ==== 
	
		// === showing html page ======
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit");
	    Sale sale = saleRepository.get(id);
	    mav.addObject("sale", sale);
	    
	    return mav;
	}
	
	//==== call for update ====
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("sale") Sale sale) {
		System.out.println(sale.getId());
	    saleRepository.update(sale);
	      
	    return "redirect:/dashboard";
	}
	
	//===== END ======
	
	//====== Delete ======
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    saleRepository.delete(id);
	    return "redirect:/dashboard";     
	}
	//===== END ========

}
