package com.xyang.shop.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		/*Properties properties = SpringContextUtil.getBean("propertiesFactory");
		ServletContext application = sce.getServletContext();
		application.setAttribute("basePath", properties.get("server.base.url"));
		application.setAttribute("staticPath", properties.get("server.static.url"));
		application.setAttribute("staticVersion", properties.get("static.version"));
		application.setAttribute("staticSuffix", "?v="+properties.get("static.version"));
		application.setAttribute("imgUrl", properties.get("server.base.url")+"/rc/getimg");*/
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("basePath", getContextPath(sc));
    }

	public void contextDestroyed(ServletContextEvent sce) {
		/*ServletContext application = sce.getServletContext();
		application.removeAttribute("basePath");
		application.removeAttribute("staticPath");
		application.removeAttribute("staticVersion");
		application.removeAttribute("staticSuffix");
		application.removeAttribute("imgUrl");*/
        ServletContext sc = sce.getServletContext();
        sc.removeAttribute("basePath");

    }

    private String getContextPath(ServletContext sc) {
        return sc.getContextPath();
    }
}
