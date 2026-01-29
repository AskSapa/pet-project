package kg.mycloud.pocker.models;

import kg.mycloud.pocker.enums.TournamentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Tournament {

    private Long id;
    private String name;
    private LocalDateTime createdOn;
    private TournamentStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal buyIn;
    private BigDecimal rebuy;
    private BigDecimal addon;
    private BigDecimal precentFirstPlace;
    private BigDecimal precentSecondPlace;
    private BigDecimal precentThirdPlace;
    private
}
