package com.elk.log;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@ConfigurationProperties(prefix = "frame.log.kafka")
public class LogKafkaProperties {
	
	private static final String DEFAULT_LOG_CHARSET = "UTF-8";

	private static final String DEFAULT_POSTFIX_PATTERN = "[%X{X-B3-TraceId},%X{X-B3-SpanId},%X{X-Span-Export}] %d{ISO8601} %p  %c : %m%n";

	/**
	 * 服务名
	 */
	@Value("${spring.application.name:NULL-SERVICE-ID}")
	private String serviceId;

	/**
	 * 实例名
	 */
	@Value("${eureka.instance.instanceId:${eureka.instance.instance-id:NULL-SERVICE-ID}}")
	private String instanceId;

	/**
	 * 输出至Kafka的编码格式
	 */
	private String charset = DEFAULT_LOG_CHARSET;

	/**
	 * 是否同步发送
	 */
	private boolean isSync = false;

	/**
	 * 发送至Kafka的日志格式，前面会添加服务名和实例名
	 */
	private String kafkaPattern = DEFAULT_POSTFIX_PATTERN;

	/**
	 * 接受日志的Kafka集群地址
	 */
	@NotNull
	private String bootstrapServers;

	/**
	 * 接受日志的Topic
	 */
	@NotNull
	private String logTopic;
}
