package org.fourstack.infomanagement.codetype;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum {@code MaritalStatus} represents the Marital Status. It defines mainly 6
 * status.
 * <ul>
 * <li>SINGLE</li>
 * <li>MARRIED</li>
 * <li>WIDOWED</li>
 * <li>DIVORCED</li>
 * <li>SEPATARED</li>
 * <li>OTHERS</li>
 * </ul>
 * 
 * @author Manjunath HM
 *
 */
public enum MaritalStatus {
	
	@JsonProperty(value = "Single")
	SINGLE {
		@Override
		public String toString() {
			return "Single";
		}
	},
	
	@JsonProperty(value = "Married")
	MARRIED {
		@Override
		public String toString() {
			return "Married";
		}
	},
	
	@JsonProperty(value = "Widowed")
	WIDOWED {
		@Override
		public String toString() {
			return "Widowed";
		}
	},
	
	@JsonProperty(value = "Divorced")
	DIVORCED {
		@Override
		public String toString() {
			return "Divorced";
		}
	},
	
	@JsonProperty(value = "Sepatared")
	SEPATARED {
		@Override
		public String toString() {
			return "Sepatared";
		}
	},
	
	@JsonProperty(value = "Others")
	OTHERS {
		@Override
		public String toString() {
			return "Others";
		}
	}
}
