package org.fourstack.infomanagement.utils;

import java.util.Arrays;
import java.util.List;

import org.fourstack.infomanagement.codetype.FluencyType;
import org.fourstack.infomanagement.codetype.Proficiency;
import org.fourstack.infomanagement.models.Address;
import org.fourstack.infomanagement.models.Language;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityGenerator {
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}

	public static Language getLanguageForId(Long id) {
		Language language = getLanguage();
		language.setId(id);
		return language;
	}

	public static Language getLanguage() {
		Language language = new Language("Kannada", Proficiency.EXPERT,
				Arrays.asList(FluencyType.SPEAK, FluencyType.READ, FluencyType.WRITE));
		return language;
	}

	public static List<Language> getLanguageList() {
		Language[] languages = {};
		try {
			languages = mapper.readValue(CommonUtils.getFileContent("language-list.json"), Language[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return Arrays.asList(languages);
	}

	public static Address getAddress() {
		Address address = new Address();
		address.setDoorNo("#154");
		address.setAddressLine1("3rd cross, 15th main");
		address.setAddressLine2("Malleswaram");
		address.setTaluk("Bengaluru North");
		address.setDistrict("Bengaluru");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPincode("560003");
		return address;
	}

	public static Address getAddressForId(Long id) {
		Address address = getAddress();
		address.setId(id);
		return address;
	}

	public static List<Address> getAddressList() {
		Address[] addresses = {};
		try {
			addresses = mapper.readValue(CommonUtils.getFileContent("address-list.json"), Address[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Arrays.asList(addresses);
	}
}
