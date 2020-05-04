package org.fourstack.infomanagement.controllers;

import org.fourstack.infomanagement.config.BasePath;
import org.fourstack.infomanagement.models.AppInfo;
import org.fourstack.infomanagement.services.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class <b><i>AppInfoController</i></b> is a Rest Controller used to provide
 * the Application related details. <br>
 * The endpoint "/info" provides the details about the application.
 * 
 * @author Manjunath_HM
 *
 */
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
