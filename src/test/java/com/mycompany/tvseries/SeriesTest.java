
package com.mycompany.tvseries;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SeriesTest {
    
    private Series series;
    
    @BeforeEach
    public void setUp(){
        series = new Series();
        series.getSeriesList().add(new SeriesModel("101", "IT", 18, 24));
        series.getSeriesList().add(new SeriesModel("102", "Stranger Things", 16, 34));

    }
    
    public SeriesTest() {
    }

    @Test
    public void testSearchSeries() {
        SeriesModel result = series.findSeriesById("101");
        assertNotNull(result, "Series should be found");
        assertEquals("IT", result.getSeriesName());
    }
    
    @Test
    public void testSearchSeries_SeriesnotFound() {
        SeriesModel result = series.findSeriesById("XYZ");
        assertNull(result, "Series should not be found");
    }

    @Test
    public void testUpdateSeries() {
        SeriesModel s = series.findSeriesById("101");
        assertNotNull(s, "Series should exist before update");
        
        s.setSeriesName("IT Updated");
        s.setSeriesAge(17);
        s.setSeriesNumberOfEpisodes(25);
        
        SeriesModel updated = series.findSeriesById("101");
        assertEquals("IT Updated", updated.getSeriesName());
        assertEquals(17, updated.getSeriesAge());
        assertEquals(25, updated.getSeriesNumberOfEpisodes());
    }

    @Test
    public void testDeleteSeries() {
        SeriesModel s = series.findSeriesById("102");
        assertNotNull(s, "Series should exist before deletion");
        series.getSeriesList().remove(s);
        
        SeriesModel deleted = series.findSeriesById("102");
        assertNull(deleted, "Series should have been deleted");
    }
    
    @Test
    public void TestDeleteSeries_SeriesNotFound(){
        SeriesModel s = series.findSeriesById("XYZ");
        assertNull(s, "Series should not exist");
        boolean removed = series.getSeriesList().remove(s);
        assertFalse(removed, "Removing non-existent series should return false");
    }
    
    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        SeriesModel result = new SeriesModel("S3", "The Simpsons", 10, 700);
        assertTrue(result.getSeriesAge() >= 2 && result.getSeriesAge() <= 18);
    }
    
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        SeriesModel result = new SeriesModel("S4", "Game of Thrones", 21, 73);
        assertFalse(result.getSeriesAge() >= 2 && result.getSeriesAge() <= 18);
    }
    
    
    
}
