package kg.mycloud.pocker.dtos;

import java.util.List;

public record TimerSettings(List<BlindLevelDto> levels, Integer breakAfterLevels, Integer breakDuration) {
}
