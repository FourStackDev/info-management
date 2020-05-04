package org.fourstack.infomanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.fourstack.infomanagement.models.AppInfo;
import org.fourstack.infomanagement.models.EndpointsDescription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {
	
	@Value("${app.name}")
	private String applicationName;
	
	@Value("${app.version}")
	private String applicationVersion;
	
	@Value("${app.description}")
	private String applicationDescription;
	
	public AppInfo getApplicationDetails() {
		AppInfo appInfo = new AppInfo();
		appInfo.set_appName(applicationName);
		appInfo.set_appVersion(applicationVersion);
		appInfo.set_appDescription(applicationDescription);
		
		appInfo.set_endPoints(getEndPointsDetails());
		
		return appInfo;
	}
	
	public List<EndpointsDescription> getEndPointsDetails() {
		List<EndpointsDescription> endPoints = new ArrayList<>();
		
		endPoints.add(new EndpointsDescription("@GET", "/info-management/api", "Base path of the application"));
		
		return endPoints;
	}
}
