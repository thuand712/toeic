<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url var="formUrl" value="/login.html"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<div id="login-box" class="login-box visible widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header blue lighter bigger">
                <i class="ace-icon fa fa-coffee green"></i>
                <fmt:message key="label.test" bundle="${lang}"/>
            </h4>
            <div class="space-6"></div>
            <form action="/login.html" method="post">
                <fieldset>
                    <c:if test="${not empty messageResponse}" >
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <label class="block clearfix">
               <span class="block input-icon input-icon-right">
               <input type="text" class="form-control" name="pojo.name" placeholder="Username"/>
               <i class="ace-icon fa fa-user"></i>
               </span>
                    </label>
                    <label class="block clearfix">
               <span class="block input-icon input-icon-right">
               <input type="password" class="form-control" name="pojo.password" placeholder="Password"/>
               <i class="ace-icon fa fa-lock"></i>
               </span>
                    </label>
                    <div class="space"></div>
                    <div class="clearfix">

                        <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-110">Login</span>
                        </button>
                    </div>
                    <div class="space-4"></div>
                </fieldset>
            </form>

        </div>

    </div>
    <!-- /.widget-body -->
</div>

</body>
</html>
