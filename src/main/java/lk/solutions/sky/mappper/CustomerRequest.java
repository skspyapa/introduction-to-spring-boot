package lk.solutions.sky.mappper;

import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        Long id,
        @NotNull(message = "customer first name is required")
        String firstName,
        @NotNull(message = "customer last name is required")
        String lastName
) {
}
