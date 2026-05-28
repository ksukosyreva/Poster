package ru.netology.javaQA.Poster;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class PosterManagerTest {

    @Test
    public void shouldFindAllIfNothingWasAdded() {
        PosterManager manager = new PosterManager();
        String[] actual = manager.findAll();
        String[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllIfOneFilmWasAdded() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Film 1");
        String[] actual = manager.findAll();
        String[] expected = {"Film 1"};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllIfWereAddedTwoFilms() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");

        String[] actual = manager.findAll();
        String[] expected = {"Film 1", "Film 2"};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllIfWereAddedSeveralFilms() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");

        String[] actual = manager.findAll();
        String[] expected = {"Film 1", "Film 2", "Film 3", "Film 4"};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindLastIFUnderLimit() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Avatar");
        manager.addMovie("Matrix");
        manager.addMovie("HarryPotter");
        manager.addMovie("Game of Thrones");

        String[] actual = manager.findLast();
        String[] expected = {"Game of Thrones", "HarryPotter", "Matrix", "Avatar"};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindLastIFLimit() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Avatar");
        manager.addMovie("Matrix");
        manager.addMovie("HarryPotter");
        manager.addMovie("Game of Thrones");
        manager.addMovie("Duna");

        String[] actual = manager.findLast();
        String[] expected = {"Duna", "Game of Thrones", "HarryPotter", "Matrix", "Avatar"};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindLastIFOverLimit() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Avatar");
        manager.addMovie("Matrix");
        manager.addMovie("HarryPotter");
        manager.addMovie("Game of Thrones");
        manager.addMovie("Duna");
        manager.addMovie("Up!");

        String[] actual = manager.findLast();
        String[] expected = {"Up!", "Duna", "Game of Thrones", "HarryPotter", "Matrix"};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSetUpUserLimit() {
        PosterManager manager = new PosterManager(7);
        manager.addMovie("1");
        manager.addMovie("2");
        manager.addMovie("3");
        manager.addMovie("4");
        manager.addMovie("5");
        manager.addMovie("6");
        manager.addMovie("7");

        String[] actual = manager.findAll();
        String[] expected = {"1", "2", "3", "4", "5", "6", "7"};

        Assertions.assertArrayEquals(actual, expected);
    }

}