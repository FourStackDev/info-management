package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FluencyType {
	
	@JsonProperty("Read")
	READ {
		@Override
		public String toString() {
			return "READ";
		}
	},
	
	@JsonProperty("Write")
	WRITE {
		@Override
		public String toString() {
			return "WRITE";
		}
	},
	
	@JsonProperty("Speak")
	SPEAK {
		@Override
		public String toString() {
			return "SPEAK";
		}
	}
}
