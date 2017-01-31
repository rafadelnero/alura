package decorator_dev_media;

public abstract class Component {
	protected String name;

	public String getName() {
		return name;
	}

	public abstract String getHtml();
}
