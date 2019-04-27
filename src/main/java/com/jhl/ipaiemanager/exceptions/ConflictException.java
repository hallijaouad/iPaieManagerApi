/**
 * 
 *
 * @author HALLI JAOUAD
 */

package com.jhl.ipaiemanager.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(code = HttpStatus.CONFLICT)
public class ConflictException extends HttpException {
	static final long serialVersionUID = 20170307L;
	public ConflictException() {
		super(HttpStatus.CONFLICT.getReasonPhrase());
	}
	public ConflictException(String resource, String message) {
		super(resource, message);
	}
	public ConflictException(String resource, String message, Throwable cause) {
		super(resource, message, cause);
	}
}