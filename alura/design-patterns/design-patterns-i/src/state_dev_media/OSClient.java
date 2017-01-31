package state_dev_media;

public class OSClient {
	public static void main(String[] args) {
		Order os = new Order();

		System.out.println(os);

		Service service1 = new Service("Install Linux", 0.001);
		Service service2 = new Service("Format computer", 49.001);

		os.insertService(service1);
		os.insertService(service2);

		System.out.println(os);

		os.printInvoice();
		System.out.println(os);

		os.removeService(service2);

		System.out.println(os);

		os.requestPayment();

		System.out.println(os);

		os.printInvoice();
		System.out.println(os);
	}
}
