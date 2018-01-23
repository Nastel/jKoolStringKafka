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

import org.apache.kafka.clients.consumer.KafkaConsumer;


public class jKoolConsumer  extends KafkaConsumer<String, String> {

	public jKoolConsumer(Properties properties) {
		super(properties);
	}

	public void jkSubscribe(String topic) {
		List<String> topics = new ArrayList<String>();
		topics.add(topic);
		super.subscribe(topics);
	}
	
	public String jkPoll(String timeout) {
		return (super.poll(Long.parseLong(timeout)).iterator().next().value());
	}

}



	
	


