package decorator_dev_media;

public class Div extends ContainerDecorator {

	Component comp;

	public Div(Component comp) {
		this.comp = comp;
	}

	@Override
	public String getName() {
		return this.comp.getName() + " + DIV";
	}

	@Override
	public String getHtml() {
		String temp = "<div>";
		temp += this.comp.getHtml();
		return temp + "</div>";
	}

}
