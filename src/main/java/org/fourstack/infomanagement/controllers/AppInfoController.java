package org.fourstack.infomanagement.controllers;

import org.fourstack.infomanagement.config.BasePath;
import org.fourstack.infomanagement.models.AppInfo;
import org.fourstack.infomanagement.services.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePath
public class AppInfoController {
	
	@Autowired
	private AppInfoService service;
	
	@GetMapping("/info")
	public AppInfo getAppInfo() {
		return service.getApplicationDetails();
	}
}
