package com.elk.log;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "frame.log.kafka.enabled", matchIfMissing = false)
@EnableConfigurationProperties(LogKafkaProperties.class)
public class LogAutoConfiguration {

	/**
	 * 在使能frame.log.kafka.enabled开关时才允许输出到Kafka
	 */
	@Bean
	public KafkaAppenderInitListener kafkaAppenderInitListener(LogKafkaProperties properties) {
		return new KafkaAppenderInitListener(properties);
	}
}
