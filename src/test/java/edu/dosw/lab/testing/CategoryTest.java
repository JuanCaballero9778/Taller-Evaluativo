package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.dosw.lab.solid.Category;


class CategoryTest {

    @Test
    void testQuantifyCategory() {
        Category[] category = Category.values();
        assertEquals(6, category.length, "Debe haber exactamente 6 categorías");
    }

    @Test
    void testShouldReturnCategory() {
        Category category = Category.valueOf("TECNOLOGIA");
        assertEquals(Category.TECNOLOGIA, category, "Debe devolver la categoría TECNOLOGIA");
    }

    @Test
    void testEnumOrder() {
        Category[] category = Category.values();
        assertEquals(Category.ALIMENTO, category[0], "La primera categoría debe ser ALIMENTO");
        assertEquals(Category.BEBIDA, category[category.length - 1], "La última categoría debe ser BEBIDA");
    }

}
