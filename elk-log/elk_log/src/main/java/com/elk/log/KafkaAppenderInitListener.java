package com.elk.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.mom.kafka.KafkaAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.nio.charset.Charset;

public class KafkaAppenderInitListener implements ApplicationListener<ContextRefreshedEvent>,ApplicationContextAware {
	
	private static final Logger LOGGER = LogManager.getLogger(KafkaAppenderInitListener.class);
	
	private LogKafkaProperties logProperties;
	
	public KafkaAppenderInitListener(LogKafkaProperties logProperties){
		this.logProperties = logProperties;
	}
	
	public void addKafkaAppenderToRootLogger() {
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		Configuration config = ctx.getConfiguration();
		Property[] properties = { Property.createProperty("bootstrap.servers", logProperties.getBootstrapServers()) };
		String pattern = String.format("%s:%s %s", logProperties.getServiceId(), logProperties.getInstanceId(), logProperties.getKafkaPattern());
		/**
		 * 2.7版本
		 *  Layout<?> layout = PatternLayout.createLayout(pattern, null,config, null, null, false, false, null, null); 
		 * Appender kafkaAppender= KafkaAppender.createAppender(layout, null, "KAFKA", true, logTopic, properties,config);
		 */

		// 2.8版本
		Layout<?> layout = PatternLayout.newBuilder().withPattern(pattern).withConfiguration(config).withCharset(Charset.forName(logProperties.getCharset())).build();
		Appender kafkaAppender = KafkaAppender.newBuilder().withLayout(layout).withName("KAFKA").setTopic(logProperties.getLogTopic())
				.setConfiguration(config).setProperties(properties).setSyncSend(logProperties.isSync()).build();

		kafkaAppender.start();
		config.getRootLogger().addAppender(kafkaAppender, Level.ALL, null);
		ctx.updateLoggers();
		LOGGER.info("Kafka Appender 初始化完成");
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (null == event || !event.getApplicationContext().equals(applicationContext)) {
			return;
		}
		addKafkaAppenderToRootLogger();
	}

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
