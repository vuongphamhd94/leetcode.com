/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.83
 * Generated at: 2022-11-18 19:39:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _005faddProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/00.JAVA/01.Hoc/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Shop/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1667293546869L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<div class=\"modal-dialog modal-xl\">\r\n");
      out.write("	<div class=\"modal-content\">\r\n");
      out.write("		<div class=\"modal-header bg-primary text-white\">\r\n");
      out.write("			<h5 class=\"modal-title\" id=\"exampleModalLabel\">Th??m m???i s???n ph???m</h5>\r\n");
      out.write("			<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("				aria-label=\"Close\">\r\n");
      out.write("				<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("			</button>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"modal-body px-3\">\r\n");
      out.write("			");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"modal-footer\">\r\n");
      out.write("			");
      if (_jspx_meth_c_005fchoose_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">????ng</button>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f0_reused = false;
    try {
      _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f0.setParent(null);
      int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
      if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("				");
          if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("				");
          if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      _jspx_th_c_005fchoose_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f0_reused = false;
    try {
      _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      // /_addProduct.jsp(15,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product == null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
      if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<form data-url=\"qlsp\" id=\"formAddPr\" data-url=\"qlsp\"\r\n");
          out.write("						data-type=\"post\" data-action=\"add\">\r\n");
          out.write("						<div class=\"form-row\">\r\n");
          out.write("							<div class=\"form-group col-md-6\">\r\n");
          out.write("								<label for=\"img\">???nh c???a s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									class=\"form-control\" name=\"img\"\r\n");
          out.write("									placeholder=\"Link ???nh c???a s???n ph???m\" required>\r\n");
          out.write("							</div>\r\n");
          out.write("							<div class=\"form-group col-md-6\">\r\n");
          out.write("								<label for=\"name\">T??n s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									class=\"form-control\" name=\"name\" placeholder=\"T??n S???n ph???m\"\r\n");
          out.write("									required>\r\n");
          out.write("							</div>\r\n");
          out.write("						</div>\r\n");
          out.write("						<div class=\"form-group\">\r\n");
          out.write("							<label for=\"detail\">Th??ng tin s???n ph???m</label>\r\n");
          out.write("							<textarea class=\"form-control\" name=\"detail\" rows=\"8\"\r\n");
          out.write("								placeholder=\"Th??ng tin s???n ph???m\" required style=\"resize: none;\"></textarea>\r\n");
          out.write("						</div>\r\n");
          out.write("						<div class=\"form-row\">\r\n");
          out.write("							<div class=\"col-md-4 mb-3\">\r\n");
          out.write("								<label for=\"price\">Gi?? s???n ph???m</label><small\r\n");
          out.write("									id=\"passwordHelpInline\" class=\"text-muted\"> (????n v???\r\n");
          out.write("									tri???u VND.) </small> <input type=\"number\" class=\"form-control\"\r\n");
          out.write("									name=\"price\" placeholder=\"Gi?? s???n ph???m\" value=\"0\" min=\"0\"\r\n");
          out.write("									max=\"100\" required>\r\n");
          out.write("								<div class=\"valid-feedback\"></div>\r\n");
          out.write("							</div>\r\n");
          out.write("\r\n");
          out.write("							<div class=\"col-md-4 mb-3\">\r\n");
          out.write("								<label for=\"type\">Lo???i s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									class=\"form-control\" name=\"type\" placeholder=\"Lo???i s???n ph???m\"\r\n");
          out.write("									required>\r\n");
          out.write("								<div class=\"valid-feedback\"></div>\r\n");
          out.write("							</div>\r\n");
          out.write("\r\n");
          out.write("							<div class=\"col-md-4 mb-3\">\r\n");
          out.write("								<label for=\"brand\">Nh??n hi???u s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									class=\"form-control\" name=\"brand\"\r\n");
          out.write("									placeholder=\"Nh??n hi???u s???n ph???m\" required>\r\n");
          out.write("								<div class=\"valid-feedback\"></div>\r\n");
          out.write("							</div>\r\n");
          out.write("						</div>\r\n");
          out.write("					</form>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      _jspx_th_c_005fwhen_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    boolean _jspx_th_c_005fotherwise_005f0_reused = false;
    try {
      _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
      if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<form data-url=\"qlsp\" id=\"formAddPr\" data-url=\"qlsp\"\r\n");
          out.write("						data-type=\"post\" data-action=\"change\">\r\n");
          out.write("						<div class=\"form-row\">\r\n");
          out.write("							<div class=\"form-group col-md-6\">\r\n");
          out.write("								<label for=\"img\">???nh c???a s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.sourceImg }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" name=\"img\"\r\n");
          out.write("									placeholder=\"Link ???nh c???a s???n ph???m\" required>\r\n");
          out.write("							</div>\r\n");
          out.write("							<div class=\"form-group col-md-6\">\r\n");
          out.write("								<label for=\"name\">T??n s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" name=\"name\"\r\n");
          out.write("									placeholder=\"T??n S???n ph???m\" required>\r\n");
          out.write("							</div>\r\n");
          out.write("						</div>\r\n");
          out.write("						<div class=\"form-group\">\r\n");
          out.write("							<label for=\"detail\">Th??ng tin s???n ph???m</label>\r\n");
          out.write("							<textarea class=\"form-control\" name=\"detail\"\r\n");
          out.write("								rows=\"8\" placeholder=\"Th??ng tin s???n ph???m\" required\r\n");
          out.write("								style=\"resize: none;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.details }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</textarea>\r\n");
          out.write("						</div>\r\n");
          out.write("						<div class=\"form-row\">\r\n");
          out.write("							<div class=\"col-md-4 mb-3\">\r\n");
          out.write("								<label for=\"price\">Gi?? s???n ph???m</label><small\r\n");
          out.write("									id=\"passwordHelpInline\" class=\"text-muted\"> (????n v???\r\n");
          out.write("									tri???u VND.) </small> <input type=\"number\" class=\"form-control\"\r\n");
          out.write("									name=\"price\" placeholder=\"Gi?? s???n ph???m\"\r\n");
          out.write("									value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.price }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" min=\"0\" max=\"1000\" required>\r\n");
          out.write("								<div class=\"valid-feedback\"></div>\r\n");
          out.write("							</div>\r\n");
          out.write("\r\n");
          out.write("							<div class=\"col-md-4 mb-3\">\r\n");
          out.write("								<label for=\"type\">Lo???i s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.type }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" name=\"type\"\r\n");
          out.write("									placeholder=\"Lo???i s???n ph???m\" required>\r\n");
          out.write("								<div class=\"valid-feedback\"></div>\r\n");
          out.write("							</div>\r\n");
          out.write("\r\n");
          out.write("							<div class=\"col-md-4 mb-3\">\r\n");
          out.write("								<label for=\"brand\">Nh??n hi???u s???n ph???m</label> <input type=\"text\"\r\n");
          out.write("									class=\"form-control\" name=\"brand\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.brand }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("									placeholder=\"Nh??n hi???u s???n ph???m\" required>\r\n");
          out.write("								<div class=\"valid-feedback\"></div>\r\n");
          out.write("							</div>\r\n");
          out.write("						</div>\r\n");
          out.write("						<input type=\"hidden\" name=\"id\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("					</form>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      _jspx_th_c_005fotherwise_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f1_reused = false;
    try {
      _jspx_th_c_005fchoose_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f1.setParent(null);
      int _jspx_eval_c_005fchoose_005f1 = _jspx_th_c_005fchoose_005f1.doStartTag();
      if (_jspx_eval_c_005fchoose_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("				");
          if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("				");
          if (_jspx_meth_c_005fotherwise_005f1(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
      _jspx_th_c_005fchoose_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f1_reused = false;
    try {
      _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
      // /_addProduct.jsp(114,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isChange }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
      if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<button class=\"btn btn-primary p-2\" id=\"addPr\" type=\"submit\">C???p\r\n");
          out.write("						nh???p</button>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      _jspx_th_c_005fwhen_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    boolean _jspx_th_c_005fotherwise_005f1_reused = false;
    try {
      _jspx_th_c_005fotherwise_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fotherwise_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
      int _jspx_eval_c_005fotherwise_005f1 = _jspx_th_c_005fotherwise_005f1.doStartTag();
      if (_jspx_eval_c_005fotherwise_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<button class=\"btn btn-primary p-2\" id=\"addPr\" type=\"submit\">Th??m\r\n");
          out.write("						m???i</button>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fotherwise_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fotherwise_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f1);
      _jspx_th_c_005fotherwise_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f1_reused);
    }
    return false;
  }
}
