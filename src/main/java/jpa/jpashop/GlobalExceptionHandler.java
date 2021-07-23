package jpa.jpashop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handlerClient401Exception(Exception e) {
		logger.debug(HttpStatus.INTERNAL_SERVER_ERROR.value() + " : " + e.getMessage());
		String result = e.getMessage();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		e.printStackTrace();
		return responseEntity;
	}
}
