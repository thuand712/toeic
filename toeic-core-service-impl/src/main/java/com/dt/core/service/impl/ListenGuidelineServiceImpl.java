package com.dt.core.service.impl;

import com.dt.core.dao.ListenGuidelineDao;
import com.dt.core.daoimpl.ListenGuidelineDaoImpl;
import com.dt.core.dto.ListenGuidelineDTO;
import com.dt.core.persistence.entity.ListenGuidelineEntity;
import com.dt.core.service.ListenGuidelineService;
import com.dt.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    @Override
    public Object[] findListenGuidelineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        ListenGuidelineDao dao = new ListenGuidelineDaoImpl();
        List<ListenGuidelineDTO>list = new ArrayList<>();
        Object[]objects = dao.findByProperty(property,sortExpression,sortDirection,offset,limit);
        for (ListenGuidelineEntity entity: (List<ListenGuidelineEntity>)objects[1]) {
            list.add(ListenGuidelineBeanUtil.entityToDto(entity));
        }
        objects[1] = list;
        return objects;
    }
}
