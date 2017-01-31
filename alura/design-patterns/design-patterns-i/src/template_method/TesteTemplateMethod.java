package template_method;

public class TesteTemplateMethod {
	public static void main(String[] args) {
		ImpostoICPP impostoICPP = new ImpostoICPP();
		Orcamento orcamento = new Orcamento(200);

		System.out.println(impostoICPP.calcula(orcamento));

		Item item = new Item("Sapato", 200);

		orcamento.adicionaItem(item);

		ImpostoIKCV impostoIKCV = new ImpostoIKCV();
		System.out.println(impostoIKCV.calcula(orcamento));
	}
}
