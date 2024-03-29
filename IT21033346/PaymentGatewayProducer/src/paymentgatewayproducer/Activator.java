package paymentgatewayproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration publishPaymentRegistration;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Payment Started");
		PaymentPublish publishPayment= new PaymentMethodsImpl();
		publishPaymentRegistration=bundleContext.registerService(PaymentPublish.class.getName(),publishPayment, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Payment Stopped");
		publishPaymentRegistration.unregister();
		
		
	}

}
