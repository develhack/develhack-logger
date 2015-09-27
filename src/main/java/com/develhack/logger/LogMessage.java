package com.develhack.logger;

/**
 * Log message with level.
 */
public interface LogMessage {

	/**
	 * Returns the log level of message.
	 *
	 * @return log level of message
	 */
	Level getLevel();

	/**
	 * Returns the log message.
	 *
	 * @return log message
	 */
	String getMessage();
}
