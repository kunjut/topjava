package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealRepository {

    List<MealTo> findAll();
}
