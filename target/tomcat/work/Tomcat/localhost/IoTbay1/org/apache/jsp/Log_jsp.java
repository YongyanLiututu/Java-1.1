/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-05-06 03:42:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.mycompany.iotbay1.models.User;
import com.mycompany.iotbay1.models.Log;

public final class Log_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>Log</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        @import url(https://fonts.googleapis.com/css?family=Open+Sans);\r\n");
      out.write("        table {\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            table-layout: fixed;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table caption {\r\n");
      out.write("            font-size: 1.5em;\r\n");
      out.write("            margin: .5em 0 .75em;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table tr {\r\n");
      out.write("            background-color: #f8f8f8;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("            padding: .35em;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table th,\r\n");
      out.write("        table td {\r\n");
      out.write("            padding: .625em;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table th {\r\n");
      out.write("            font-size: .85em;\r\n");
      out.write("            letter-spacing: .1em;\r\n");
      out.write("            text-transform: uppercase;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @media screen and (max-width: 600px) {\r\n");
      out.write("            table {\r\n");
      out.write("                border: 0;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            table caption {\r\n");
      out.write("                font-size: 1.3em;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            table thead {\r\n");
      out.write("                border: none;\r\n");
      out.write("                clip: rect(0 0 0 0);\r\n");
      out.write("                height: 1px;\r\n");
      out.write("                margin: -1px;\r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("                padding: 0;\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                width: 1px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            table tr {\r\n");
      out.write("                border-bottom: 3px solid #ddd;\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin-bottom: .625em;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            table td {\r\n");
      out.write("                border-bottom: 1px solid #ddd;\r\n");
      out.write("                display: block;\r\n");
      out.write("                font-size: .8em;\r\n");
      out.write("                text-align: right;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            table td::before {\r\n");
      out.write("                /*\r\n");
      out.write("                * aria-label has no advantage, it won't be read inside a table\r\n");
      out.write("                content: attr(aria-label);\r\n");
      out.write("                */\r\n");
      out.write("                content: attr(data-label);\r\n");
      out.write("                float: left;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            table td:last-child {\r\n");
      out.write("                border-bottom: 0;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        /* general styling */\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: \"Open Sans\", sans-serif;\r\n");
      out.write("            line-height: 1.25;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

    User user = (User) session.getAttribute("loginUser");
    if (user != null) {

      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    <table>\r\n");
      out.write("        <caption>My Log</caption>\r\n");
      out.write("        <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>Email Address</th>\r\n");
      out.write("            <th>Login Time</th>\r\n");
      out.write("            <th>Logout Time</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        ");

            List<Log> logList = (List<Log>) session.getAttribute("logList");
            for(Log log : logList){
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print( user.getEmail());
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( log.getLoginTime() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( log.getLogoutTime() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("        <a style=\"color: black\" href=\"Main.jsp\">Back to main</a>\r\n");
      out.write("</div>\r\n");

    } else {
        response.sendRedirect("Interface.jsp");
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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