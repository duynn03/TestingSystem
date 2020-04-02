package com.vti.testing.config.exception.customobject.OauthException;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * This class is MyOAuthExceptionJacksonSerializer.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 23, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 23, 2020
 */
public class MyOAuthExceptionJacksonSerializer extends StdSerializer<MyOAuth2Exception> {

	private static final long serialVersionUID = 1L;

	protected MyOAuthExceptionJacksonSerializer() {
		super(MyOAuth2Exception.class);
	}

	@Override
	public void serialize(MyOAuth2Exception value, JsonGenerator jgen, SerializerProvider serializerProvider)
			throws IOException {
		LocalDateTime localDateTime = LocalDateTime.now();
		jgen.writeStartObject();
		jgen.writeObjectField("status ", HttpStatus.BAD_REQUEST.getReasonPhrase());
		jgen.writeStringField("message ", value.getLocalizedMessage());
		jgen.writeStringField("detail message ", value.getSummary());
		jgen.writeStringField("timestamp ", localDateTime.toString());
		jgen.writeEndObject();
	}

}
