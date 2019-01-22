package com.cuizhiwen.jdk.common.utils;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author songbin
 * @version 2016年6月4日 下午2:43:27  
 */
public class YTOLogger
{
	private final String FQCN = getClass().getName();

	private              Logger    logger      = (Logger) LoggerFactory.getLogger(this.getClass());
	private final        int       LEVEL_TRACE = 0;
	private final        int       LEVEL_DEBUG = 10;
	private final        int       LEVEL_INFO  = 20;
	private final        int       LEVEL_WARN  = 30;
	private final        int       LEVEL_ERROR = 40;
	private static YTOLogger instance    = null;
	/**日志索引 + flag*/
	private static final String    MSG_PREFIX  = "";

	private YTOLogger(){}

	public static synchronized YTOLogger getInstance()
	{
		if (null == instance)
		{
			instance = new YTOLogger();
		}
		return instance;
	}

	/**基础
	 * @param level int 日志等级
	 * @param msg String 日志内容
	 * @param t Throwable 异常内容
	 * @param args Object 变长参数，与msg中的{}一一对应
	 * */
	private void log(int level, String msg, Throwable t, Object... args)
	{
		try
		{
			int len = args.length;
			Object argArray[] = new Object[len];

			argArray = new Object[len];
			for(int index = 0; index < len ; index++)
			{
				argArray[index] = args[index];
			}

			msg = (null==msg ? MSG_PREFIX : MSG_PREFIX + msg);
			this.logger.log(null, FQCN, level, msg, argArray, t);
		}
		catch (Exception e)
		{
			this.logger.log(null, FQCN, LEVEL_WARN, msg, args, e);
		}
	}
	
	public void info(String msg, Throwable t, Object... args)
	{
		this.log(this.LEVEL_INFO, msg, t, args);
	}

	public void debug( String msg, Throwable t, Object... args)
	{
		this.log(this.LEVEL_DEBUG, msg, t, args);
	}

	public void warn( String msg, Throwable t, Object... args)
	{
		this.log( this.LEVEL_WARN, msg, t, args);
	}

	public void error( String msg, Throwable t, Object... args)
	{
		this.log( this.LEVEL_ERROR, msg, t, args);
	}

	public void trace( String msg, Throwable t, Object... args)
	{
		this.log( this.LEVEL_TRACE, msg, t, args);
	}

}
