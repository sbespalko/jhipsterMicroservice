package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.HistoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link History} and its DTO {@link HistoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface HistoryMapper extends EntityMapper<HistoryDTO, History> {

    @Mapping(source = "client.id", target = "clientId")
    HistoryDTO toDto(History history);

    @Mapping(source = "clientId", target = "client")
    History toEntity(HistoryDTO historyDTO);

    default History fromId(Long id) {
        if (id == null) {
            return null;
        }
        History history = new History();
        history.setId(id);
        return history;
    }
}
