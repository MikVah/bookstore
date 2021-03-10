package fi.hh.swd20.theBookstore.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import fi.hh.swd20.theBookstore.domain.Category;
import fi.hh.swd20.theBookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository cateRepository;
	
	//RESTFUL all categories
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategoriesRest() {
		return (List<Category>) cateRepository.findAll();
	}
	
	//RESTFul category by ID
		@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
			return cateRepository.findById(categoryId);
		}
	
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
