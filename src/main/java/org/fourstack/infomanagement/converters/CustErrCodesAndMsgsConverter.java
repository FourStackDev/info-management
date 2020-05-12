package org.fourstack.infomanagement.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.fourstack.infomanagement.codetype.CustErrCodesAndMsgs;

/**
 * Class <b><i>CustErrCodesAndMsgsConverter</i></b> is used to convert the Enum
 * values. It is used to convert an entity attribute to a database value and
 * vice versa
 * 
 * @author Manjunath_HM
 *
 */
@Converter(autoApply = true)
public class CustErrCodesAndMsgsConverter implements AttributeConverter<CustErrCodesAndMsgs, String> {

	@Override
	public String convertToDatabaseColumn(CustErrCodesAndMsgs attribute) {
		if (attribute == null)
			return null;
		return attribute.getMessage();
	}

	@Override
	public CustErrCodesAndMsgs convertToEntityAttribute(String message) {
		if (message == null)
			return null;

		return Stream.of(CustErrCodesAndMsgs.values()).filter(c -> c.getMessage().equals(message)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
