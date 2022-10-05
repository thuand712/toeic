package com.dt.core.web.utils;


import com.dt.core.web.command.AbstractCommand;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static final Logger log = Logger.getLogger(RequestUtil.class);
    public static void initSearchBean(HttpServletRequest request, AbstractCommand bean){
        if(bean != null){
            String sortExpresstion = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT));
            String sortDirection = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
            String pageStr = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));
            Integer page = 1;
            if(StringUtils.isNotBlank(pageStr)){
                try {
                    page = Integer.valueOf(pageStr);
                }catch (Exception e){
                    log.error(e.getMessage(), e);
                }
            }
            bean.setPage(page);
            bean.setSortExpression(sortExpresstion);
            bean.setSortDirection(sortDirection);
            bean.setFirstItem((bean.getPage()-1)*bean.getMaxPageItems());
        }
    }
}
