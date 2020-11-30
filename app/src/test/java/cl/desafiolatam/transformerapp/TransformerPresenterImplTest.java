package cl.desafiolatam.transformerapp;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.TimeZone;

@RunWith(MockitoJUnitRunner.class)
public class TransformerPresenterImplTest extends TestCase {

    @Mock
    private TransformerView transformerView;
    private TransformerPresenter transformerPresenter;
    private final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        transformerPresenter = new TransformerPresenterImpl();
        transformerPresenter.setView(transformerView);
    }

    @Test
    public void testSetDate() {
        //given
        calendar.set(2020,11,31,00,00,00);
        //when
        transformerPresenter.setDate(calendar.getTimeInMillis());
        //then
        Mockito.verify(transformerView, Mockito.times(1)).showDateResult();
    }

    @Test
    public void testGetStringDate() {
        //given
        calendar.set(2020,11,30);
        //when
        transformerPresenter.setDate(calendar.getTimeInMillis());
        //then
        assertEquals(transformerPresenter.getStringDate(),"jueves, diciembre 30, 2020");
    }

    @Test
    public void testGetDaysOnly() {
        calendar.set(2020,11,30);
        transformerPresenter.setDate(calendar.getTimeInMillis());
        assertEquals(transformerPresenter.getDaysOnly(),"Día del mes: 30");
    }

    @Test
    public void testGetWeeksOnly() {
        calendar.set(2020,0,1);
        transformerPresenter.setDate(calendar.getTimeInMillis());
        assertEquals(transformerPresenter.getWeeksOnly(),"Semana del año: 1");
    }

    @Test
    public void testGetTimeStamp() {
        calendar.set(2020,0,1,00,00,00);
        transformerPresenter.setDate(calendar.getTimeInMillis());
        assertEquals(transformerPresenter.getTimeStamp().longValue(),1577836800045L);
        assertNotNull(transformerPresenter.getTimeStamp());


    }

    @Test
    public void testGetDateFormatOne() {
        calendar.set(2020,11,30);
        transformerPresenter.setDate(calendar.getTimeInMillis());
        assertEquals(transformerPresenter.getDateFormatOne(), "30/12/2020");
    }

    @Test
    public void testGetDateFormatTwo() {
        calendar.set(2020,11,30);
        transformerPresenter.setDate(calendar.getTimeInMillis());
        assertEquals(transformerPresenter.getDateFormatTwo(), "30 - 12 - 2020");
    }

    @Test
    public void testGetDateFormatThree() {

        calendar.set(2020,0,1);
        transformerPresenter.setDate(calendar.getTimeInMillis());
        assertEquals(transformerPresenter.getDateFormatThree(),"mié, ene 1, 2020");

    }

    @Test
    public void testGetDateFormatFour() {
        calendar.set(2020,0,1);
        transformerPresenter.setDate(calendar.getTimeInMillis());
        assertEquals(transformerPresenter.getDateFormatFour(),"miércoles 1");
    }
}