package com.csis3275.config_mku_03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletInitializer_mku_03 implements WebApplicationInitializer {
	public void onStartup(ServletContext container) throws ServletException {
		 // pulls the config class for the application
		 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		 ctx.register(SpringMVCConfig_mku_03.class);
		 ctx.setServletContext(container);
		 
		 // deals with http requests
		 ServletRegistration.Dynamic servlet = container.addServlet(
		 "dispatcher", new DispatcherServlet(ctx));
		 
		 servlet.setLoadOnStartup(1);
		 servlet.addMapping("/");
	 }	
}
