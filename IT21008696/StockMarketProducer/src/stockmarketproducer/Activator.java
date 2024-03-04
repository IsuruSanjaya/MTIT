package stockmarketproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;

	ServiceRegistration servReg;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
//		Activator.context = bundleContext;
		System.out.println("Stocks Publisher Start");
		Stock ss = new StocksImpl();
		servReg = bundleContext.registerService(Stock.class.getName(), ss, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		System.out.println("Closing Stock Publisher");
		servReg.unregister();
	}

}
