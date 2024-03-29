package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.category.CategoryRepository;
import ru.practicum.category.exceptions.CategoryNotFound;
import ru.practicum.category.model.Category;
import ru.practicum.compilation.CompilationRepository;
import ru.practicum.compilation.exceptions.CompilationNotFound;
import ru.practicum.compilation.model.Compilation;
import ru.practicum.event.EventRepository;
import ru.practicum.event.exceptions.EventNotFound;
import ru.practicum.event.model.Event;
import ru.practicum.request.RequestRepository;
import ru.practicum.request.model.Request;
import ru.practicum.user.UserRepository;
import ru.practicum.user.exceptions.UserNotFound;
import ru.practicum.user.model.User;

@Service
@RequiredArgsConstructor
public class ValidationService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final EventRepository eventRepository;
    private final RequestRepository requestRepository;
    private final CompilationRepository compilationRepository;

    public User validateUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new UserNotFound("Пользователь с id = " + userId + " не найден")
        );
    }

    public Category validateCategory(Long catId) {
        return categoryRepository.findById(catId).orElseThrow(
                () -> new CategoryNotFound("Категория с id = " + catId + " не найдена")
        );
    }

    public Event validateEvent(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(
                () -> new EventNotFound("Событие с id = " + eventId + " не найдено")
        );
    }

    public Request validateRequest(Long requestId) {
        return requestRepository.findById(requestId).orElseThrow(
                () -> new EventNotFound("Запрос с id = " + requestId + " не найден")
        );
    }

    public Compilation validateCompilation(Long compId) {
        return compilationRepository.findById(compId).orElseThrow(
                () -> new CompilationNotFound("Подборка с id = " + compId + " не найдена")
        );
    }
}
