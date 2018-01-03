package com.vdong.restful.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vdong.admin.model.Users;
import com.vdong.admin.model.enums.State;
import com.vdong.admin.service.UsersService;
import com.vdong.restful.exception.JurisdictionException;
import com.vdong.restful.util.MD5Tools;

@Component
public class TokenInterceptor implements HandlerInterceptor {

	@Autowired
	private UsersService usersService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String key = request.getHeader("User-Agent");

		String token = request.getParameter("token");

		String random = request.getParameter("random");

		Users users = usersService.findByKey(key);

		if (users.getState() == State.ON && random != null & random.length() > 6) {
			if (MD5Tools.MD5(users.getSecret() + random).equals(token)) {

				return true;
			} else {
				throw new JurisdictionException("key或秘钥错误");

			}
		} else {

			throw new JurisdictionException("随机数大于6位，或key无法使用");
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
