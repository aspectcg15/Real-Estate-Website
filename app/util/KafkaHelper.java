package util;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaHelper {
	public static void kafka(String topic, Object obj) {
		Properties props = new Properties();
		props.put("metadata.broker.list","10.153.7.113:9094,10.153.7.113:9096");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("request.required.acks", "1");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = null;
		
		try{
			producer = new Producer<String, String>(config);
			KeyedMessage<String, String> data = new KeyedMessage<String, String>(
				topic, obj.toString());
			producer.send(data);
		}finally{
			if(producer != null)
				producer.close();
		}
	}
}
