package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Proficiency {
	
	@JsonProperty("beginner")
	BEGINNER{
		@Override
		public String toString() {
			return "beginner";
		}
	},
	
	@JsonProperty("proficient")
	PROFICIENT {
		@Override
		public String toString() {
			return "proficient";
		}
	},
	
	@JsonProperty("expert")
	EXPERT {
		@Override
		public String toString() {
			return "expert";
		}
	}

}
