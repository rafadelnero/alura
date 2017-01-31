package br.com.caelum.estoque.ws;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@Remote
public interface WebServiceComEJB  {
    
    @WebMethod
    public String getPerson(@WebParam(name = "userId") String userId);
    
}
