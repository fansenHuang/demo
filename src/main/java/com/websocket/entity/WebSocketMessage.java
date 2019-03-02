package com.websocket.entity;

import java.time.LocalDateTime;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class WebSocketMessage {

    private String message;
    private LocalDateTime time;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public WebSocketMessage(String message, LocalDateTime time) {
		super();
		this.message = message;
		this.time = time;
	}
	@Override
	public String toString() {
		return "WebSocketMessage [message=" + message + ", time=" + time + "]";
	}

    
}