package iam.rizel.prism;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Testbundle start");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Testbundle stop");
    }
}
