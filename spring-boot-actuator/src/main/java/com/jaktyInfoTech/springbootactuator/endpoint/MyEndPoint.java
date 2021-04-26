package com.jaktyInfoTech.springbootactuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Endpoint(id="jaktyInfoTech", enableByDefault=true)
public class MyEndPoint {
	
	@ReadOperation
	public MyEndPointResponse features() {
		return new MyEndPointResponse(1001, "JaktyInfoTech", "Active");
	}

}
