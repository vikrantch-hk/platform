/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hk.platform.controller;

import com.hk.platform.stream.Event;
import com.hk.platform.stream.OrderSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderSource orderSource;

	@Value("${originator}")
	private String originator;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Event> add(@RequestBody Event input) {

		//input.setOriginator(originator);
		/*for(int i=0;i<250;i++) {*/
			orderSource.sendOrder(input);
		/*}*/

		return new ResponseEntity<Event>(input, HttpStatus.OK);
	}

}
