package br.com.caelum.estoque.ws.impl;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.caelum.estoque.ws.WebServiceComEJB;

@Stateless
@WebService
public class WebServiceComEJBImpl implements WebServiceComEJB {
 
    public WebServiceComEJBImpl() {
    }
    
    @WebMethod
    public String getPerson(@WebParam(name = "userId") 
            String userId) { 
        return "Teste";    
    }
}
