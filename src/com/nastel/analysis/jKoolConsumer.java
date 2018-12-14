/*
 * Copyright 2018 JKOOL, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nastel.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;


public class jKoolConsumer  extends KafkaConsumer<String, String> {
	private String topic;
	private final Logger logger;
	
	public jKoolConsumer(Properties properties) {
		super(properties);
		logger = Logger.getLogger(jKoolConsumer.class);
		logger.info("Consumer created");
	}

	public void jkSubscribe(String topic) {
		List<String> topics = new ArrayList<String>();
		this.topic = topic;
		topics.add(topic);
		super.subscribe(topics);
		logger.info("Successful subscribe");
	}
	
	public String jkPoll(String timeout) {
			try 
			{
				ConsumerRecords<String, String> records = super.poll(Long.parseLong(timeout));
				if (records != null && records.count() > 0)
				{
					logger.info("Successful poll");
					return (records.iterator().next().value());  
				}
				else
				{
					logger.info("No records read.");
					return null;
				}
			}
			catch (Exception e) {
					logger.error("Error in jkPoll: {}", e);
					return null;
			}
	}
}