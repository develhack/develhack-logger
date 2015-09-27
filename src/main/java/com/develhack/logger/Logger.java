package com.develhack.logger;

import org.slf4j.LoggerFactory;

import com.develhack.annotation.assertion.Nonnull;

// @formatter:off
/**
 * The logging API.
 * [source,java]
 * .Example of use:
 * --
 * import com.develhack.logger.Logger;
 * import com.develhack.logger.LogMessage;
 * import com.develhack.logger.Level;
 *
 * public class Foo {
 *
 *     private static final Logger logger = Logger.get(Foo.class);
 *
 *     public void foo() {
 *         logger.log(ExampleLogMessage.EXAMPLE1, "Example");
 *     }
 *
 *     private static enum ExampleLogMessage implements LogMessage {
 *
 *         EXAMPLE1(Level.INFO, "Log message of {}.");
 *
 *         private final Level level;
 *         private final String message;
 *
 *         private ExampleLogMessage(Level level, String message) {
 *             this.level = level;
 *             this.message = message;
 *         }
 *
 *         @Override
 *         public Level getLevel() { return this.level; }
 *         @Override
 *         public String getMessage() { return this.message; }
 *     }
 * }
 * --
 */
// @formatter:on
public class Logger {

	/**
	 * Returns a logger named corresponding to the specified class.
	 *
	 * @param clazz a class to be used as the name of the logger
	 * @return a logger named corresponding to the specified class
	 */
	public static Logger get(@Nonnull Class<?> clazz) {
		return new Logger(LoggerFactory.getLogger(clazz));
	}

	private final org.slf4j.Logger delegate;

	private Logger(org.slf4j.Logger delegate) {
		this.delegate = delegate;
	}

	/**
	 * Determines whether the specified log message will be written.
	 *
	 * @param logMessage a log message to be checked
	 * @return `true` if the log message will be written
	 */
	public boolean isEnabled(@Nonnull LogMessage logMessage) {
		return isEnabled(logMessage.getLevel());
	}

	/**
	 * Determines whether a log message with specified log level will be written.
	 *
	 * @param level a log level to be checked
	 * @return `true` if a log message with specified log level will be written
	 */
	public boolean isEnabled(@Nonnull Level level) {
		switch (level) {
			case ERROR:
				return delegate.isErrorEnabled();
			case WARN:
				return delegate.isWarnEnabled();
			case INFO:
				return delegate.isInfoEnabled();
			case DEBUG:
				return delegate.isDebugEnabled();
			case TRACE:
				return delegate.isTraceEnabled();
			default:
				throw new AssertionError();
		}
	}

	/**
	 * Logs the message if necessary.
	 *
	 * @param logMessage a log message to be written
	 */
	public void log(@Nonnull LogMessage logMessage) {
		if (!isEnabled(logMessage)) return;
		log0(logMessage, (Object[]) null);
	}

	/**
	 * Logs the message if necessary.
	 *
	 * @param logMessage a log message to be written
	 * @param arg1 an argument will set to the 1st placeholder in the message.
	 */
	public void log(@Nonnull LogMessage logMessage, Object arg1) {
		if (!isEnabled(logMessage)) return;
		log0(logMessage, arg1);
	}

	/**
	 * Logs the message if necessary.
	 *
	 * @param logMessage a log message to be written
	 * @param arg1 an argument will set to the 1st placeholder in the message.
	 * @param arg2 an argument will set to the 2nd placeholder in the message.
	 */
	public void log(@Nonnull LogMessage logMessage, Object arg1, Object arg2) {
		if (!isEnabled(logMessage)) return;
		log0(logMessage, arg1, arg2);
	}

	/**
	 * Logs the message if necessary.
	 *
	 * @param logMessage a log message to be written
	 * @param arg1 an argument will set to the 1st placeholder in the message.
	 * @param arg2 an argument will set to the 2nd placeholder in the message.
	 * @param arg3 an argument will set to the 3rd placeholder in the message.
	 */
	public void log(@Nonnull LogMessage logMessage, Object arg1, Object arg2, Object arg3) {
		if (!isEnabled(logMessage)) return;
		log0(logMessage, arg1, arg2, arg3);
	}

	/**
	 * Logs the message if necessary.
	 *
	 * @param logMessage a log message to be written
	 * @param arg1 an argument will set to the 1st placeholder in the message.
	 * @param arg2 an argument will set to the 2nd placeholder in the message.
	 * @param arg3 an argument will set to the 3rd placeholder in the message.
	 * @param arg4 an argument will set to the 4th placeholder in the message.
	 */
	public void log(@Nonnull LogMessage logMessage, Object arg1, Object arg2, Object arg3, Object arg4) {
		if (!isEnabled(logMessage)) return;
		log0(logMessage, arg1, arg2, arg3, arg4);
	}

	/**
	 * Logs the message if necessary.
	 *
	 * @param logMessage a log message to be written
	 * @param arg1 an argument will set to the 1st placeholder in the message.
	 * @param arg2 an argument will set to the 2nd placeholder in the message.
	 * @param arg3 an argument will set to the 3rd placeholder in the message.
	 * @param arg4 an argument will set to the 4th placeholder in the message.
	 * @param arg5 an argument will set to the 5th placeholder in the message.
	 */
	public void log(@Nonnull LogMessage logMessage, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
		if (!isEnabled(logMessage)) return;
		log0(logMessage, arg1, arg2, arg3, arg4, arg5);
	}

	/**
	 * Logs the message if necessary.
	 *
	 * @param logMessage a log message to be written
	 * @param args arguments will set to the placeholders in the message.
	 */
	public void log(@Nonnull LogMessage logMessage, Object... args) {
		if (!isEnabled(logMessage)) return;
		log0(logMessage, args);
	}

	private void log0(LogMessage logMessage, Object... args) {
		switch (logMessage.getLevel()) {
			case ERROR:
				delegate.error(logMessage.getMessage(), args);
			case WARN:
				delegate.warn(logMessage.getMessage(), args);
			case INFO:
				delegate.info(logMessage.getMessage(), args);
			case DEBUG:
				delegate.debug(logMessage.getMessage(), args);
			case TRACE:
				delegate.trace(logMessage.getMessage(), args);
			default:
				throw new AssertionError();
		}
	}
}
