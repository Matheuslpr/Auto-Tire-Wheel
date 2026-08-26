package dev.matheus.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErroResponse(

        Integer status,
        String erro,
        List<String> message,
        LocalDateTime timestamp
) {
}
