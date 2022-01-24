package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import gr.hua.dit.DistributedSystemsAssignment.FileUploadUtil;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;

public class AppRegistrationController {
	//try to merge this in the rest api
	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/application/registration/save")
	public RedirectView saveUser(Application application, @RequestParam("image") MultipartFile multipartFile)
			throws IOException {

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		application.setPhoto(fileName);

		Application savedApp = applicationService.saveApplication(application);

		String uploadDir = "user-photos/" + savedApp.getId();

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		return new RedirectView("/freefare", true);
	}
}
