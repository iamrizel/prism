package iam.rizel.prism.bundle.test;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
	
    @Override
    public void start(BundleContext bundleContext) throws Exception {
    	System.out.println("Start Testbundle");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
    }
}
