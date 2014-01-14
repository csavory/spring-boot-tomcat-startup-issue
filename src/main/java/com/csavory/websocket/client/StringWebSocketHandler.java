/*
 * Copyright 2012-2013 the original author or authors.
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

package com.csavory.websocket.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component("quizUpWebSocketHandler")
public class StringWebSocketHandler extends TextWebSocketHandler {
	
	protected static final Log logger = LogFactory.getLog(StringWebSocketHandler.class);
	
	public StringWebSocketHandler() {

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Established Connection");
		TextMessage message = new TextMessage("Welcome");
		session.sendMessage(message);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		logger.info("Received: " + message);
		session.sendMessage(new TextMessage("Response"));
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception)
			throws Exception {
		logger.error("Transport Error", exception);
		session.close(CloseStatus.SERVER_ERROR);
	}
}
