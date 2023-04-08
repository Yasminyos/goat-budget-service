package by.yanodincov.goat.budget.db.filter;

import jakarta.annotation.Nonnull;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetOperationFilter {
    @Nonnull
    private UUID userUUID;

    private UUID lastUUID;

    private UUID categoryUUID;

    private Instant afterInstant;

    private Instant beforeInstant;



}
