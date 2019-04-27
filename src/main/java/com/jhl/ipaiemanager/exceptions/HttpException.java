/**
 * Base Exception class for extension.
 *
 * @author HALLI JAOUAD
 */

package com.jhl.ipaiemanager.exceptions;

abstract class HttpException extends RuntimeException {

	static final long serialVersionUID = 20170227L;

	private final String resource;

	HttpException(String message) {
		this(null, message);
	}

	HttpException(String resource, String message) {
		super(message);
		this.resource = resource;
	}

	HttpException(String resource, String message, Throwable cause) {
		super(message, cause);
		this.resource = resource;
	}

	public String getResource() {
		return this.resource;
	}
}