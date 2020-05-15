package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum {@code FluencyType} defines the ability of fluency on a Language. It
 * defines mainly 3 types.
 * <ul>
 * <li>READ</li>
 * <li>WRITE</li>
 * <li>SPEAK</li>
 * </ul>
 * 
 * @author Manjunath_Hm
 *
 */
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
