package br.com.meetup.livraria.bean;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.component.fieldset.Fieldset;

@Named
@ViewScoped
public class FasesJsfBean implements Serializable {

	private static final long serialVersionUID = 4432365549527738382L;
	
	private String valor;
	private int numero;
	
	private HtmlInputText txtBinding;
	
	public void exibe() {
		System.out.println("Passamos pelo m�todo: " + valor);
	}
	
	public void mudaValorDoCampoComBinding() {
		System.out.println(txtBinding.getSubmittedValue());
		
		txtBinding.setValue("Valor alterado!");
	}
	
	public void exibeArvoreJSF() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		
		UIComponent frmFasesJsf = viewRoot.findComponent("frmFasesJsf"); 
		
		for (UIComponent componentesDoForm : frmFasesJsf.getChildren()) {
			if (componentesDoForm instanceof Fieldset) {
				
				for (UIComponent componenteDoFieldset : componentesDoForm.getChildren()) {
					
					if (componenteDoFieldset instanceof HtmlPanelGrid) {
						
						for (UIComponent componentesDoPanelGrid   : componenteDoFieldset.getChildren()) {
							System.out.println(componentesDoPanelGrid.getClientId());
						}
						
					}
					
				};
			}
			
		}
	}
	
	public void processaValorManualmente() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		
	    String valorDoComponente = ec.getRequestParameterMap().get("frmFasesJsf:txtPegarValorComponente");
		
		System.out.println(valorDoComponente);
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public final String getValor() {
		return valor;
	}

	public final void setValor(String valor) {
		this.valor = valor;
	}

	public final HtmlInputText getTxtBinding() {
		return txtBinding;
	}

	public final void setTxtBinding(HtmlInputText txtBinding) {
		this.txtBinding = txtBinding;
	}
}
