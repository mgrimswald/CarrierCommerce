package com.carrierinfo.carriercommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carrierinfo.carriercommerce.dao.DaoFactory;
import com.carrierinfo.carriercommerce.dao.ProductDao;
import com.carrierinfo.carriercommerce.dao.UserDao;
import com.carrierinfo.carriercommerce.model.Customer;
import com.carrierinfo.carriercommerce.model.Product;
import com.carrierinfo.carriercommerce.model.ShoppingCart;
import com.carrierinfo.carriercommerce.security.LoginModule;

@WebServlet(urlPatterns={ "/addToCart", "/ajax/addToCart" })
@ServletSecurity(@HttpConstraint(rolesAllowed = { LoginModule.CUSTOMER_ROLE }))
public class AddProductToCartServlet extends HttpServlet {

	private UserDao userDao;
	private ProductDao productDao;
	
	
	@Override
	public void init() throws ServletException {
		userDao = DaoFactory.getDaoFactory().getUserDao();
		productDao = DaoFactory.getDaoFactory().getProductDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String productIdParam = req.getParameter("productId");
		Long productId = Long.valueOf(productIdParam);
		
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new ShoppingCart((Customer) userDao.findUserByUsername(req.getUserPrincipal().getName()));
			req.getSession().setAttribute("cart", cart);
		}
		
		Product product = productDao.findProductById(productId);
		
		cart.addProduct(product);
		
		String redirectUrl = "/product?id=" + productIdParam + "&add=" + 1;
		if(!isAjaxCall(req)) {
			resp.sendRedirect(redirectUrl);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	private boolean isAjaxCall(HttpServletRequest request) {
		return request.getRequestURI().startsWith("/ajax");
	}
	
}
