package com.elk.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogKafkaTestApplication.class)
public class LogTest {
	private static final AppLogger LOGGER = AppLogger.getLogger(LogTest.class);
	
	private static final int SEND_COUNT = 10;
	
	/**
	 * Log4j2支持异步发送，而Kafka Appender支持异步的producer，这边配置使用同步Log4j2，异步/同步producer
	 * 同步发送10000条在本地测试将396秒
	 * 异步发送10000条在本地测试为28秒
	 */
	@Test
	public void testSpeedWith100ByteContent(){
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		Map<String, Appender> maps = ctx.getRootLogger().getAppenders();
		Appender kafkaAppender = maps.get("KAFKA");
		
		StringBuffer buffer = new StringBuffer();
		String log;
		for(int j = 0; j < 100; j ++){
			buffer.append("T");
		}
		log = buffer.toString();
		for(int i = 0; i < SEND_COUNT; i++){
			LOGGER.error(log);
		}

		kafkaAppender.stop();
		kafkaAppender.start();
		LOGGER.error("done");
	}
}
