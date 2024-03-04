package com.mtit.prj.service;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.mtit.prj.service.ConvertCurrencyService;
import com.mtit.prj.service.ConvertCurrencyServiceImpl;

public class ServiceActivator implements BundleActivator {

	private ServiceRegistration<?> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("-------Online currency producer activated---------");

		ConvertCurrencyService service = new ConvertCurrencyServiceImpl();
		registration = context.registerService(ConvertCurrencyService.class.getName(), service, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("-------Online currency Deactivated--------");
		registration.unregister();
	}
}
