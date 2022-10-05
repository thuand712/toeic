package com.dt.core.utils;

import com.dt.core.dto.ListenGuidelineDTO;
import com.dt.core.persistence.entity.ListenGuidelineEntity;

public class ListenGuidelineBeanUtil {
    public static ListenGuidelineDTO entityToDto(ListenGuidelineEntity listenGuidelineEntity){
        ListenGuidelineDTO listenGuidelineDTO = new ListenGuidelineDTO();
        listenGuidelineDTO.setListenGuidelineId(listenGuidelineEntity.getListenGuidelineId());
        listenGuidelineDTO.setContent(listenGuidelineEntity.getContent());
        listenGuidelineDTO.setTitle(listenGuidelineEntity.getTitle());
        listenGuidelineDTO.setImage(listenGuidelineEntity.getImage());
        listenGuidelineDTO.setCreatedDate(listenGuidelineEntity.getCreatedDate());
        listenGuidelineDTO.setUpdatedDate(listenGuidelineEntity.getUpdatedDate());
        return listenGuidelineDTO;
    }
    public static ListenGuidelineEntity dtoToEntity(ListenGuidelineDTO listenGuidelineDTO){
        ListenGuidelineEntity listenGuidelineEntity = new ListenGuidelineEntity();
        listenGuidelineEntity.setListenGuidelineId(listenGuidelineDTO.getListenGuidelineId());
        listenGuidelineEntity.setContent(listenGuidelineDTO.getContent());
        listenGuidelineEntity.setTitle(listenGuidelineDTO.getTitle());
        listenGuidelineEntity.setImage(listenGuidelineDTO.getImage());
        listenGuidelineEntity.setCreatedDate(listenGuidelineDTO.getCreatedDate());
        listenGuidelineEntity.setUpdatedDate(listenGuidelineDTO.getUpdatedDate());
        return listenGuidelineEntity;
    }
}
