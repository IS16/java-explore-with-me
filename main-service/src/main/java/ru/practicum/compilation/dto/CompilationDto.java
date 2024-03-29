package ru.practicum.compilation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.practicum.event.dto.EventShortDto;

import java.util.List;

@Data
@AllArgsConstructor
public class CompilationDto {
    private final Long id;
    private final String title;
    private final Boolean pinned;
    private final List<EventShortDto> events;
}
