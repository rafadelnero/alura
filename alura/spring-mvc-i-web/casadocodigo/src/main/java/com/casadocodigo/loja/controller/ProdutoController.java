package com.casadocodigo.loja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casadocodigo.loja.dao.ProdutoDao;
import com.casadocodigo.loja.infra.FileSaver;
import com.casadocodigo.loja.model.Produto;
import com.casadocodigo.loja.model.TipoPreco;
import com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoDao produtoDao;
	
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produto/form");

		modelAndView.addObject("tipos", TipoPreco.values());

		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView grava(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return form(produto);
		}
		
		fileSaver.write("arquivos-sumario", sumario);
		
		produtoDao.grava(produto);

		redirectAttributes.addFlashAttribute("sucesso", "Produto gravado com sucesso!");
		
		return new ModelAndView("redirect:produto");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista() {
		List<Produto> produtos = produtoDao.buscaTodos();
		
		ModelAndView modelAndView = new ModelAndView("produto/lista");
		modelAndView.addObject("produtos", produtos);

		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView detalhe(long idProduto) {
		Produto produto = produtoDao.busca(idProduto);
		
		ModelAndView modelAndView = new ModelAndView("produto/detalhe");
		modelAndView.addObject("produto", produto);
		
		return modelAndView;
	}
}
