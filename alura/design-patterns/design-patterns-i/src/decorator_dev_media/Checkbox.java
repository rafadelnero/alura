package decorator_dev_media;

public class Checkbox extends Component {

	public Checkbox() {
		this.name = "Checkbox";
	}

	@Override
	public String getHtml() {
		return "<input type='checkbox' name='chk'>";
	}

}
