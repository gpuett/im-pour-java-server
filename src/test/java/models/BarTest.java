package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BarTest {

    @Test
    public void getName() {
        Bar bar = setupBar();
        assertEquals("Kelly's Olympian", bar.getName());
    }

    @Test
    public void setName() {
        Bar bar = setupBar();
        bar.setName("C Bar");
        assertEquals("C Bar", bar.getName());
    }

    @Test
    public void getAddress() {
        Bar bar = setupBar();
        assertEquals("426 SW Washington St, Portland, OR 97204", bar.getAddress());
    }

    @Test
    public void setAddress() {
        Bar bar = setupBar();
        bar.setAddress("666 SE Grand Ave, Portland, OR 97202");
        assertEquals("666 SE Grand Ave, Portland, OR 97202", bar.getAddress());
    }

    @Test
    public void getPhone() {
        Bar bar = setupBar();
        assertEquals("503-228-3669", bar.getPhone());
    }

    @Test
    public void setPhone() {
        Bar bar = setupBar();
        bar.setPhone("503-666-6666");
        assertEquals("503-666-6666", bar.getPhone());
    }

    @Test
    public void getDeal() {
        Bar bar = setupBar();
        assertEquals("$1 off draft beer, well drinks and wine", bar.getDeal());
    }

    @Test
    public void setDeal() {
        Bar bar = setupBar();
        bar.setDeal("free drinks");
        assertEquals("free drinks", bar.getDeal());
    }

    //helper model
    public Bar setupBar() {
        return new Bar("Kelly's Olympian", "426 SW Washington St, Portland, OR 97204", "503-228-3669", "$1 off draft beer, well drinks and wine", "4pm-7pm");
    }
}