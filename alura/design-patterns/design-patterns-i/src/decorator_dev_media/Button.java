package decorator_dev_media;

public class Button extends Component {

	public Button() {
		this.name = "Button";
	}

	@Override
	public String getHtml() {
		return "<input type='button' value='Click aqui'>";
	}

}
