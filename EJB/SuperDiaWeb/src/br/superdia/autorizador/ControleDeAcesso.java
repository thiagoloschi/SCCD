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

import br.superdia.modelo.Usuario;

@WebFilter(value = "*.xhtml")
public class ControleDeAcesso implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Usuario user = (Usuario) session.getAttribute("USUARIOLogado");
		
		if ((user != null)) {
			
			// Se o jovem for cliente não deixa ir para controle de estoque.
			if(user.getPerfil().equalsIgnoreCase("cliente") && 
					req.getRequestURI().endsWith("controleEstoque.xhtml"))
				redireciona("/SuperDiaWeb/produtos.xhtml", response);
			
			else
				chain.doFilter(request, response);
			//redireciona("/SuperDiaWeb/produtos.xhtml", response);
			
		}

		else 
			if(req.getRequestURI().endsWith("login.xhtml"))
				chain.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}


	private void redireciona(String url, ServletResponse response)
			throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(url);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}