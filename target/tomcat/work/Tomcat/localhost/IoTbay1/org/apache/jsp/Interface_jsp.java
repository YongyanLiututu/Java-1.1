/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-05-18 02:56:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Interface_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Interface</title>\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            #first, #second, #third, #fourth {\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("            #first {\n");
      out.write("                background: linear-gradient(270deg, rgba(255, 0, 0, 0.5), rgba(200, 150, 0, 0.2));\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("            }\n");
      out.write("            #second {\n");
      out.write("                background: linear-gradient(90deg, rgba(66, 134, 244, 0.5), rgba(96, 115, 255, 0.8));\n");
      out.write("                display: grid;\n");
      out.write("                grid-template-columns: repeat(3, 1fr);\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("            #third {\n");
      out.write("                background: linear-gradient(270deg, rgba(255, 0, 0, 0.5), rgba(200, 150, 0, 0.2));\n");
      out.write("            }\n");
      out.write("            #fourth {\n");
      out.write("                background: linear-gradient(90deg, rgba(66, 134, 244, 0.5), rgba(96, 115, 255, 0.8));\n");
      out.write("            }\n");
      out.write("            .nav-ul {\n");
      out.write("                position: fixed;\n");
      out.write("                height: 10vh;\n");
      out.write("                bottom: 0;\n");
      out.write("                left: 0px;\n");
      out.write("                right: 0px;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: row;\n");
      out.write("                list-style: none;\n");
      out.write("                background: transparent;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            .nav-li {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: center;\n");
      out.write("                margin: 5px;\n");
      out.write("                width: 40px;\n");
      out.write("                height: 40px;\n");
      out.write("                font: bold 12px/30px Georgia, serif;\n");
      out.write("                color: #fff;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                background: #4b0082;\n");
      out.write("            }\n");
      out.write("            .top {\n");
      out.write("                border-radius: 0;\n");
      out.write("                width: 75px;\n");
      out.write("                border-radius: 8%;\n");
      out.write("                box-shadow: 4px 4px 0 0 #230f3f;\n");
      out.write("            }\n");
      out.write("            @media (max-width: 360px) {\n");
      out.write("                .bottom {\n");
      out.write("                    margin: 5px;\n");
      out.write("                    width: 40px;\n");
      out.write("                    height: 40px;\n");
      out.write("                    font-size: 12px;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            a:hover {\n");
      out.write("                text-decoration: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .nav_top {\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: row-reverse;\n");
      out.write("            }\n");
      out.write("            .header_top {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            #brand {\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("                font: italic bold 30px/30px Georgia, serif;\n");
      out.write("                color: #fff;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 3px solid #fff;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            #tagline {\n");
      out.write("                font: italic bold 12px/30px Georgia, serif;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("            #screen {\n");
      out.write("                flex: 1;\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: center;\n");
      out.write("                position: relative;\n");
      out.write("                top: -50px;\n");
      out.write("            }\n");
      out.write("            .textbox {\n");
      out.write("                color: white;\n");
      out.write("                background: transparent;\n");
      out.write("                border: 1px solid white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"first\">\n");
      out.write("            <div id=\"screen\">\n");
      out.write("                <div id=\"brand\">\n");
      out.write("                    <div>IoTBay</div>\n");
      out.write("                    <div id=\"tagline\">You need it, you want it, you got it.</div>\n");
      out.write("                    <a href=\"Login.jsp\"><li class=\"nav-li top\">Login</li></a>\n");
      out.write("                    <a href=\"Register.jsp\"><li class=\"nav-li top\">Sign Up</li></a>\n");
      out.write("                </div>\n");
      out.write("                ");

                    String mess = (String)request.getAttribute("mess");         // 获取错误属性
                    if(mess != null) {
                
      out.write("\n");
      out.write("                <script type=\"text/javascript\" language=\"javascript\">\n");
      out.write("                    alert(\"");
      out.print(mess);
      out.write("\");                                            // 弹出错误信息\n");
      out.write("\n");
      out.write("                </script>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
