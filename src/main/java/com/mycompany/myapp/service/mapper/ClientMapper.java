package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ClientDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Client} and its DTO {@link ClientDTO}.
 */
@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {

    @Mapping(source = "address.id", target = "addressId")
    ClientDTO toDto(Client client);

    @Mapping(target = "products", ignore = true)
    @Mapping(target = "removeProduct", ignore = true)
    @Mapping(target = "histories", ignore = true)
    @Mapping(target = "removeHistory", ignore = true)
    @Mapping(source = "addressId", target = "address")
    Client toEntity(ClientDTO clientDTO);

    default Client fromId(Long id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
