package kg.mycloud.pocker.mappers;

import kg.mycloud.pocker.dtos.TournamentResponse;
import kg.mycloud.pocker.models.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TournamentMapper {

    @Mapping(target = "settings.prizeDistribution", ignore = true)
    TournamentResponse toResponse(Tournament savedTournament);
}
