package com.example.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletException;

public class AppInitializer implements WebApplicationInitializer {

	//@Override
	//public void onStartup(ServletContext servletContext) {

		
	//}

	@Override
	public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		// Load Spring web application configuration
				AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
				context.register(Config.class);

				// Create and register the DispatcherServlet
				DispatcherServlet servlet = new DispatcherServlet(context);
				ServletRegistration.Dynamic registration = (Dynamic) servletContext.addServlet("app", servlet);
				registration.setLoadOnStartup(1);
				registration.addMapping("/app/*");
	}
}