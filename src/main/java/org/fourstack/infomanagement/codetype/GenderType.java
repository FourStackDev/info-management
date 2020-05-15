package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum {@code GenderType} represents the type of Genders used. It mainly
 * defines 3 types of gender values
 * <ul>
 * <li>MALE</li>
 * <li>FEMALE</li>
 * <li>OTHER</li>
 * </ul>
 * 
 * @author Manjunath HM
 *
 */
public enum GenderType {
	@JsonProperty(value = "Male")
	MALE {
		@Override
		public String toString() {
			return "MALE";
		}
	},
	
	@JsonProperty(value = "Female")
	FEMALE {
		@Override
		public String toString() {
			return "FEMALE";
		}
	},
	
	@JsonProperty(value = "Other")
	OTHER {
		@Override
		public String toString() {
			return "OTHER";
		}
	}
}
