package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BarTest {

    @Test
    public void getName() {
        Bar bar = setupBar();
        assertEquals("Kelly's Olympian", bar.getName());
    }

    //helper model
    public Bar setupBar() {
        return new Bar("Kelly's Olympian", "426 SW Washington St, Portland, OR 97204", "503-228-3669", "$1 off draft beer, well drinks and wine", "4pm-7pm");
    }
}