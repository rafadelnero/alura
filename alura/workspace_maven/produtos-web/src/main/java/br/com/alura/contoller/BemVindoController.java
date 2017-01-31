package br.com.alura.contoller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class BemVindoController {
	private Result result;
	
	public BemVindoController(Result result) {
		this.result = result;
	}
	
	@Path("/") 
	public void bemVindo() {
		System.out.println("estou invocando o vraptor");
		result.use(Results.http()).body("<html>Bem vindo!</html>");
	}
}
