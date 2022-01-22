package gr.hua.dit.DistributedSystemsAssignment.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/freefare").setViewName("fareinfo");
		registry.addViewController("/freefare/info").setViewName("fareinfo");
		registry.addViewController("/freefare/application").setViewName("appregistration");
		registry.addViewController("/freefare/application/registration").setViewName("appregistration");
		registry.addViewController("/OAEDemp").setViewName("OAEDemp");
		registry.addViewController("/OASAemp").setViewName("OASAemp");
		registry.addViewController("/OASAemp/showapps").setViewName("showapps");
		registry.addViewController("/root").setViewName("admin");
		//registry.addViewController("/login").setViewName("login");
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("user-photos", registry);
    }
     
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
         
        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
         
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
    }
}
