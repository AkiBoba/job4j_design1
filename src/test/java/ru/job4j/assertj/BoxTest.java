package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
        assertThat(box.whatsThis()).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
        assertThat(box.whatsThis()).asString().isEqualTo("Cube");
    }

    @Test
    void getNumberOfVerticesIsZero() {
        Box box = new Box(0, 10);
        assertThat(box.getNumberOfVertices()).isLessThan(1);
    }

    @Test
    void getNumberOfVerticesIsFour() {
        Box box = new Box(4, 1);
        assertThat(box.getNumberOfVertices())
                .isEqualTo(4)
                .isBetween(3, 5);
    }

    @Test
    void isExist() {
        Box box = new Box(4, 1);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(-1, 1);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void getAreaOfSphere() {
        Box box = new Box(0, 1);
        assertThat(box.getArea()).isEqualTo(12.566d, withPrecision(0.006d));
    }

    @Test
    void getAreaOfCube() {
        Box box = new Box(8, 1);
        assertThat(box.getArea()).isFinite().isEqualTo(6d);
    }
}