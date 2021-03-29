package by.snb.casino.api

import javax.validation.constraints.Max
import javax.validation.constraints.PositiveOrZero

data class Bet(
    @PositiveOrZero val bet: Int,
    @PositiveOrZero @Max(10) val guess: Int
)