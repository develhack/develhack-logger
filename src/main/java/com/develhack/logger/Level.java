package com.develhack.logger;

/**
 * Log level.
 */
public enum Level {

	/** Indicates that the message is highly detailed information for the developers. */
	TRACE,
	/** Indicates that the message is detailed information for the developers. */
	DEBUG,
	/** Indicates that the message is information on the processing status of the application. */
	INFO,
	/** Indicates that a potentially harmful event has occurred. */
	WARN,
	/** Indicates that an unexpected error has occurred. */
	ERROR
}
