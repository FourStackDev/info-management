package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CourseType {
	
	@JsonProperty(value = "Full Time")
	FULL_TIME {
		@Override
		public String toString() {
			return "Full Time";
		}
	},
	
	@JsonProperty(value = "Part Time")
	PART_TIME {
		@Override
		public String toString() {
			return "Part Time";
		}
	},
	
	@JsonProperty(value = "Correspondence")
	CORRESPONDENCE {
		@Override
		public String toString() {
			return "Correspondence";
		}
	}
}
