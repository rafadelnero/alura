package state_dev_media;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private static Integer ID_GENERATION = 1;

	enum State {
		OPEN, CLOSED, CANCELED, INVOICED
	}

	private Integer id;
	private State state;
	private List<Service> services;

	public Order() {
		id = ID_GENERATION++;
		state = State.OPEN;
		services = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void insertService(Service service) {
		switch (state) {
		case OPEN:
			services.add(service);
			break;
		case CLOSED:
			state = State.OPEN;
			services.add(service);
			break;
		case CANCELED:
			System.out.println("Impossible");
			break;
		case INVOICED:
			System.out.println("Impossible");
			break;
		}
	}

	public void removeService(Service service) {
		switch (state) {
		case OPEN:
			services.remove(service);
			break;
		case CLOSED:
			state = State.OPEN;
			services.remove(service);
			break;
		case CANCELED:
			System.out.println("Impossible");
			break;
		case INVOICED:
			System.out.println("Impossible");
			break;
		}
	}

	public void cancelOS(Service service) {
		switch (state) {
		case OPEN:
			state = State.CANCELED;
			break;
		case CLOSED:
			System.out.println("First reopen the order");
			break;
		case CANCELED:
			System.out.println("Already canceled");
			break;
		case INVOICED:
			System.out.println("Impossible");
			break;
		}
	}

	public void requestPayment() {
		switch (state) {
		case OPEN:
			state = State.CLOSED;
			break;
		case CLOSED:
			System.out.println("Already closed");
			break;
		case CANCELED:
			System.out.println("Impossible");
			break;
		case INVOICED:
			System.out.println("Impossible");
			break;
		}
	}

	public void printInvoice() {
		switch (state) {
		case OPEN:
			System.out.println("First request for payment.");
			break;
		case CLOSED:
			state = State.INVOICED;
			break;
		case CANCELED:
			System.out.println("Impossible");
			break;
		case INVOICED:
			System.out.println("Impossible");
			break;
		}
	}

	@Override
	public String toString() {
		return "State: " + state + "\nServices: " + services;
	}
}
