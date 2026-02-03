package kg.mycloud.pocker.mappers;

import kg.mycloud.pocker.dtos.PlayerResponse;
import kg.mycloud.pocker.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {

    PlayerResponse toResponse(Player player);
    List<PlayerResponse> toResponseList(List<Player> players);
}
