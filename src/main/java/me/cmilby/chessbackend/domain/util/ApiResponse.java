/*
 * @Author: Craig Milby 
 * @Date: 2019-05-18 09:18:54 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 11:18:02
 */
package me.cmilby.chessbackend.domain.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ApiResponse
 */
public class ApiResponse {

	@JsonProperty ( "Success" )
	private Boolean success;

	@JsonProperty ( "Message" )
	private String message;

	@JsonProperty ( "Payload" )
	private String payload;

	public ApiResponse ( ) {

	}

	public ApiResponse ( Boolean p_success, String p_message ) {
		this.success = p_success;
		this.message = p_message;
	}

	public ApiResponse ( Boolean p_success, String p_message, Object p_payload ) {
		this.success = p_success;
		this.message = p_message;

		try {
			ObjectMapper mapper = new ObjectMapper ( );
			this.payload = mapper.writeValueAsString ( p_payload );
		} catch ( Exception ex ) {
			// ex.printStackTrace ( );
		}
	}

	public Boolean getSuccess ( ) {
		return success;
	}

	public void setSuccess ( Boolean success ) {
		this.success = success;
	}

	public String getMessage ( ) {
		return message;
	}

	public void setMessage ( String message ) {
		this.message = message;
	}
}