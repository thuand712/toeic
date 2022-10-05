package com.dt.web.logic.command;

import com.dt.core.dto.ListenGuidelineDTO;
import com.dt.core.web.command.AbstractCommand;

public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuidelineCommand(){
        this.pojo = new ListenGuidelineDTO();
    }
}
