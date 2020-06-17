package org.fourstack.infomanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.fourstack.infomanagement.codetype.MethodType;
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

	/**
	 * Provides Information related to Application. Informations includes Name of
	 * application, Version, Description and endpoints exposed to the clients.
	 * 
	 * @return
	 */
	public AppInfo getApplicationDetails() {
		AppInfo appInfo = new AppInfo();
		appInfo.set_appName(applicationName);
		appInfo.set_appVersion(applicationVersion);
		appInfo.set_appDescription(applicationDescription);

		appInfo.set_endPoints(getEndPointsDetails());

		return appInfo;
	}

	/**
	 * Provides information about list of API Endpoints exposed to the client.
	 * Should include only the endpoints that are exposed to the Client only.
	 * 
	 * @return List of Api Endpoints exposed to the Client.
	 */
	private List<EndpointsDescription> getEndPointsDetails() {
		List<EndpointsDescription> endPoints = new ArrayList<>();

		endPoints.add(new EndpointsDescription(MethodType.GET, "/info-management/api", "Base path of the application"));

		return endPoints;
	}
}
