package com.highpeak.Ediscovery.uiresponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractController {

	protected <T> ResponseEntity<UIResponse<T>> buildResponse(final T t) {
		final UIResponse<T> uiResponse = new UIResponse<>(t);
		uiResponse.setStatus(HttpStatus.OK.value());
		uiResponse.setMessage("Success");
		return new ResponseEntity<>(uiResponse, HttpStatus.OK);
	}
}
