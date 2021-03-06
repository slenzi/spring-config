package org.lenzi.spring.sample.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Map service exception to HTTP error code.
 * 
 * @author slenzi
 */
public class WebServiceExceptionMapper implements ExceptionMapper<WebServiceException> {

	@Override
	public Response toResponse(WebServiceException exception) {
		
		Response.Status status = null;
		
		if(exception.getErrorCode() == WebServiceException.CODE_NOT_FOUND){
			status = Response.Status.NOT_FOUND;
		}else if(exception.getErrorCode() == WebServiceException.CODE_MISSING_REQUIRED_INPUT){
			status = Response.Status.BAD_REQUEST;
		}else if(exception.getErrorCode() == WebServiceException.CODE_INVALID_INPUT){
			status = Response.Status.BAD_REQUEST;
		}else if(exception.getErrorCode() == WebServiceException.CODE_DATABSE_ERROR){
			status = Response.Status.INTERNAL_SERVER_ERROR;
		}else if(exception.getErrorCode() == WebServiceException.CODE_UNKNOWN){
			status = Response.Status.BAD_REQUEST;
		}else{
			status = Response.Status.BAD_REQUEST;
		}
		
		/*
		status = Response.Status.FORBIDDEN;
		status = Response.Status.INTERNAL_SERVER_ERROR;
		status = Response.Status.NOT_IMPLEMENTED;
		status = Response.Status.UNAUTHORIZED;
		status = Response.Status.NOT_ACCEPTABLE;
		*/
		
		String jsonString = "{\"errorMessage\":\"" + exception.getMessage() + "\"}";
		
        Response response = Response.status(status).entity(jsonString).build();
        
        return response;
	}

}
