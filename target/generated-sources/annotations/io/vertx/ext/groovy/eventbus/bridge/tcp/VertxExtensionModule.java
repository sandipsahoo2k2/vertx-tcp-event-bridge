package io.vertx.ext.groovy.eventbus.bridge.tcp;
import groovy.lang.MetaMethod;
import org.codehaus.groovy.runtime.m12n.ExtensionModule;
import org.codehaus.groovy.runtime.m12n.MetaInfExtensionModule;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
public class VertxExtensionModule extends ExtensionModule {
  private static final String extensionClasses = "io.vertx.ext.groovy.eventbus.bridge.tcp.BridgeEvent_GroovyExtension";
  private static final String staticExtensionClasses = "io.vertx.ext.groovy.eventbus.bridge.tcp.TcpEventBusBridge_GroovyStaticExtension";
  private final ExtensionModule delegate;  public VertxExtensionModule() {
    super("io.vertx.ext.eventbus.bridge.tcp", "3.5.0");
    Properties props = new Properties();
    props.put("moduleName", "io.vertx.ext.eventbus.bridge.tcp");
    props.put("moduleVersion", "3.5.0");
    props.put("extensionClasses", extensionClasses);
    props.put("staticExtensionClasses", staticExtensionClasses);
    delegate = MetaInfExtensionModule.newModule(props, getClass().getClassLoader());
  }
  public List<MetaMethod> getMetaMethods() {
    return delegate.getMetaMethods();
  }
}