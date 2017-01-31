package decorator_dev_media;

public class Fieldset extends ContainerDecorator {
	Component comp;

	public Fieldset(Component comp) {
		this.comp = comp;
	}

	@Override
	public String getName() {
		return this.comp.getName() + " + FIELDSET";
	}

	@Override
	public String getHtml() {
		String temp = "<fieldset>";
		temp += "<legend> Título </legend>";
		temp += this.comp.getHtml();
		return temp + "</fieldset>";
	}
}
