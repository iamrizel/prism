package iam.rizel.prism;

import org.apache.felix.framework.FrameworkFactory;
import org.apache.felix.main.AutoProcessor;
import org.osgi.framework.launch.Framework;

import java.util.HashMap;
import java.util.Map;

public class Core {

    public static void main(String[] args) throws Exception {

        Map<String, String> frameworkConfig = new HashMap<String, String>();
        frameworkConfig.put("org.osgi.framework.storage.clean", "onFirstInit");

        frameworkConfig.put("felix.fileinstall.dir", "testbundle");
        FrameworkFactory factory = new FrameworkFactory();
        Framework fw = factory.newFramework(frameworkConfig);
        fw.start();
                
        Map<String, String> autoProcessorConfig = new HashMap<String, String>();
        autoProcessorConfig.put("felix.auto.deploy.action", "install,start");
        autoProcessorConfig.put("felix.auto.deploy.dir", "bundles");
        AutoProcessor.process(autoProcessorConfig, fw.getBundleContext());
    }
}
