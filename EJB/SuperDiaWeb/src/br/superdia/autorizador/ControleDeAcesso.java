package br.superdia.autorizador;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = "*.xhtml")
public class ControleDeAcesso implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if ((session.getAttribute("USUARIOLogado") != null)
				|| (req.getRequestURI().endsWith("produtos.xhtml"))
				|| (req.getRequestURI().endsWith("carrinho.xhtml"))) {

			

				//redireciona("/SuperDiaWeb/produtos.xhtml", response);
			
			chain.doFilter(request, response);
		}

		else {
			System.out.println("\n\n*********** AQUIIIII **********************\n\n");
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	@SuppressWarnings("unused")
	private void redireciona(String url, ServletResponse response)
			throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(url);
	}
}