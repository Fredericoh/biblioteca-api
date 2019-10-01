package br.com.faculdadedelta.bibliotecaapi.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RefreshTokenPostPosProcessamento implements ResponseBodyAdvice<OAuth2AccessToken> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return returnType.getMethod().getName().equals("postAccessToken");
	}

	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {

		HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();

		HttpServletResponse res = ((ServletServerHttpResponse) response).getServletResponse();

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;
		String refreshToken = token.getRefreshToken().getValue();

		// inclui refresh token no cookie
		incluirRefreshTokenNoCookie(refreshToken, req, res);

		// exclui refresh token da resposta
		excluirRefreshTokenDaResposta(token);

		return body;
	}

	private void excluirRefreshTokenDaResposta(DefaultOAuth2AccessToken token) {
		token.setRefreshToken(null);
	}

	private void incluirRefreshTokenNoCookie(String refreshToken, HttpServletRequest req, HttpServletResponse res) {

		Cookie cookie = new Cookie("refreshToken", refreshToken);
		cookie.setHttpOnly(true);
		cookie.setSecure(false); // mudar para true quando for HTTPS
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(36000);
		res.addCookie(cookie);
	}

}
