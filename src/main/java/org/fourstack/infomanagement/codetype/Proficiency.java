package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum {@code Proficiency} defines the ability on a Technical Language. It
 * defines mainly 3 types.
 * <ul>
 * <li>BEGINNER</li>
 * <li>PROFICIENT</li>
 * <li>EXPERT</li>
 * </ul>
 * 
 * @author Manjunath_Hm
 *
 */
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
