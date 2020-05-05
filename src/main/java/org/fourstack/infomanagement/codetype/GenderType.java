package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

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
