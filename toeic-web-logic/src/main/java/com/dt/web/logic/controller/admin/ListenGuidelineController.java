package com.dt.web.logic.controller.admin;

import com.dt.core.dto.ListenGuidelineDTO;
import com.dt.core.service.ListenGuidelineService;
import com.dt.core.service.impl.ListenGuidelineServiceImpl;
import com.dt.core.web.utils.RequestUtil;
import com.dt.web.logic.command.ListenGuidelineCommand;
import com.dt.web.logic.common.WebConstant;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin-guidline-listen-list.html")
public class ListenGuidelineController extends HttpServlet {
    //Để sử dụng logger
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListenGuidelineService service = new ListenGuidelineServiceImpl();
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        command.setMaxPageItems(4);
        RequestUtil.initSearchBean(req,command);

        Map<String, Object>property = new HashMap<>();
        property.put("title", "Bai hd 1");
        property.put("content", "Noi dung bai hd 1");

        Object[]objects = service.findListenGuidelineByProperties(property,command.getSortExpression(),command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());

        command.setListResult((List<ListenGuidelineDTO>)objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));

        req.setAttribute(WebConstant.LIST_ITEMS,command);

        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
