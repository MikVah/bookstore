package fi.hh.swd20.theBookstore.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.hh.swd20.theBookstore.domain.Category;
import fi.hh.swd20.theBookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository cateRepository;
	
	@RequestMapping(value="/categorylist")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", cateRepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value="/create")
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory";
	}
	
	@RequestMapping(value="/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		cateRepository.save(category);
		return "redirect:/categorylist";
	}
}
