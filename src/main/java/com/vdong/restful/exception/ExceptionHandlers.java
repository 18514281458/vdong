package com.vdong.restful.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.vdong.restful.response.ExceptionMessage;
import com.vdong.restful.response.Response;
import com.vdong.restful.staticVariable.GlobalStaticVariable;

/**
 * 统一异常处理
 * 
 * @author liangwei
 *
 */
@ControllerAdvice
@RestController
public class ExceptionHandlers {

	Logger logger = Logger.getLogger(ExceptionHandlers.class);

	/**
	 * 系统异常处理，比如：404,500
	 * 
	 * @param req
	 * @param resp
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public Response defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
			logger.error("404" + e.getMessage());
			return Response.failMessage(GlobalStaticVariable.EXCEPTION, e.getMessage());
		} else if (e instanceof MethodArgumentNotValidException) {
			List<ExceptionMessage> invalidArguments = new ArrayList<ExceptionMessage>();

			for (FieldError error : ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors()) {
				logger.error(error.getField() + ":" + error.getDefaultMessage());
				invalidArguments
						.add(ExceptionMessage.putMessage(GlobalStaticVariable.VALIDATION, error.getDefaultMessage()));
			}
			return Response.fail(invalidArguments);
		} else if (e instanceof BindException) {
			List<ExceptionMessage> invalidArguments = new ArrayList<ExceptionMessage>();

			for (FieldError error : ((BindException) e).getBindingResult().getFieldErrors()) {
				logger.error(error.getField() + ":" + error.getDefaultMessage());
				invalidArguments
						.add(ExceptionMessage.putMessage(GlobalStaticVariable.VALIDATION, error.getDefaultMessage()));
			}
			return Response.fail(invalidArguments);

		} else {
			logger.error("500" + e.getMessage());
			return Response.failMessage(GlobalStaticVariable.EXCEPTION, e.getMessage());
		}

	}
}
