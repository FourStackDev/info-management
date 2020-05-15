package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum {@code CourseType} defines the types of Courses. It mainly defines 3
 * types.
 * <ul>
 * <li>FULL_TIME</li>
 * <li>PART_TIME</li>
 * <li>CORRESPONDENCE</li>
 * </ul>
 * 
 * @author Manjunath HM
 *
 */
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
