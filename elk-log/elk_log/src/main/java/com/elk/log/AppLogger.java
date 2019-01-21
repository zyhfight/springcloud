package com.elk.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AppLogger {

	private Logger logger = null;
	
	public static final String SESSION_ID_KEY = "traceId";
	public static final String SESSION_ID_VAL = "none";
	/**
	 * 私有构造方法。防止外部实例化
	 */
	private AppLogger()
	{}
	
	public static AppLogger getLogger(Class<?> clazz)
	{
		AppLogger appLogger = new AppLogger();
		appLogger.logger = LogManager.getLogger(clazz);
		return appLogger;
	}

	public static AppLogger getLogger(String name)
	{
		AppLogger appLogger = new AppLogger();
		appLogger.logger = LogManager.getLogger(name);
		return appLogger;
	}

	public static AppLogger getRootLogger()
	{
		AppLogger appLogger = new AppLogger();
		appLogger.logger = LogManager.getRootLogger();
		return appLogger;
	}

	public boolean isTraceEnabled()
	{
		return this.logger.isTraceEnabled();
	}

	public boolean isDebugEnabled(){
		return this.logger.isDebugEnabled();
	}
	
	public boolean isInfoEnabled(){
		return this.logger.isInfoEnabled();
	}
	
	public boolean isErrorEnabled(){
		return this.logger.isErrorEnabled();
	}
	
	public boolean isWarnEnabled(){
		return this.logger.isWarnEnabled();
	}
	
	public boolean isFatalEnabled(){
		return this.logger.isFatalEnabled();
	}
	
	public void trace(Object message)
	{
		this.logger.trace(message);
	}

	public void trace(Object message, Throwable t)
	{
		this.logger.trace(message, t);
	}
	
	public void trace(String message, Object... params) {
		this.logger.trace(message, params);
	}

	public void debug(Object message)
	{
		this.logger.debug(message);
	}

	public void debug(Object message, Throwable t)
	{
		this.logger.debug(message, t);
	}

	public void debug(String message, Object... params) {
		this.logger.debug(message, params);
	}
	
	public void info(Object message)
	{
		this.logger.info(message);
	}

	public void info(Throwable t)
	{
		this.logger.info("", t);
	}

	public void info(Object message, Throwable t)
	{
		this.logger.info(message, t);
	}

	public void info(String message, Object... params) {
		this.logger.info(message, params);
	}
	
	public void warn(Object message)
	{
		this.logger.warn(message);
	}

	public void warn(Throwable t)
	{
		this.logger.warn("", t);
	}
	
	public void warn(Object message, Throwable t)
	{
		this.logger.warn(message, t);
	}

	public void warn(String message, Object... params) {
		this.logger.warn(message, params);
	}
	
	public void error(Object message)
	{
		this.logger.error(message);
	}

	public void error(Object message, Throwable t)
	{
		this.logger.error(message, t);
	}

	public void error(String message, Object... params) {
		this.logger.error(message, params);
	}
	
	public void fatal(Object message)
	{
		this.logger.fatal(message);
	}
	
	public void fatal(Object message, Throwable t)
	{
		this.logger.fatal(message, t);
	}

	public void fatal(String message, Object... params) {
		this.logger.fatal(message, params);
	}
	
	public String getName()
	{
		return this.logger.getName();
	}
}
