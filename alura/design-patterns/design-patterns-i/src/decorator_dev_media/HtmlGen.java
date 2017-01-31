package decorator_dev_media;

public class HtmlGen {
	public static void main(String[] args) {
		Component checkbox = new Checkbox();
		ContainerDecorator div = new Fieldset(new Div(checkbox));
		System.out.println(div.getHtml());
	}
}
