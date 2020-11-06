package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Book;
import dmacc.repository.BookRepository;

@Controller
public class WebController {
	@Autowired
	BookRepository bookRepo;
	/**
	 * viewAllBooks
	 * @param model
	 * @return result.html
	 * @return addNewBook(model)
	 */
	@GetMapping({"viewBooks"})
	public String viewAllBooks(Model model) {
		if(bookRepo.findAll().isEmpty()) {
			return addNewBook(model);
		}
		model.addAttribute("books", bookRepo.findAll());
		return "results";
	}
	
	@GetMapping("/inputBook")
	public String addNewBook(Model model) {
		Book b = new Book();
		model.addAttribute("newBook", b);
		return "input";
	}
	
	@PostMapping("/inputBook")
	public String addNewBook(@ModelAttribute Book b, Model model) {
		bookRepo.save(b);
		return viewAllBooks(model);	
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateBook(@PathVariable("id") long id, Model model) {
		Book b = bookRepo.findById(id).orElse(null);
		model.addAttribute("newBook", b);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseBook(Book b, Model model) {
		bookRepo.save(b);
		return viewAllBooks(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long id, Model model) {
		Book b = bookRepo.findById(id).orElse(null);
		bookRepo.delete(b);
		return viewAllBooks(model);
	}
	
	@PostMapping("/searchGenre")
	public String listByGenre(@RequestParam(name="genre", required=false) String selection, Model model) {
		if(bookRepo.findBygenre(selection).isEmpty()) {
			return "index";
		}
		model.addAttribute("books", bookRepo.findBygenre(selection));
		return "results";
	}
	
	@GetMapping("/home")
	public String indexReturn(){
		return "index";
		
	}
}
