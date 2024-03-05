package forexproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ForexActivator implements BundleActivator {
	
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("----- Forex Publisher Activated -----");
        context.registerService(ForexService.class.getName(), new ForexServiceImpl(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("----- Forex Publisher Deactivated -----");
    }
}
