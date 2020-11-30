package cl.desafiolatam.transformerapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TransformerPresenterImpl implements TransformerPresenter {
    private String dateString;
    private TransformerView view;
    private Calendar calendar;

    public TransformerPresenterImpl() {
        //empty
    }


    @Override
    public void setView(TransformerView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        view = null;
    }

    @Override
    public void setDate(Long date) {
        calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTime(new Date(date));
        SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy",Locale.getDefault());
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateString = format.format(calendar.getTime());
        view.showDateResult();
    }

    @Override
    public String getStringDate() {
        return dateString;
    }

    @Override
    public String getDaysOnly() {
        return "Día del mes: " + calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String getWeeksOnly() {
        return "Semana del año: " + calendar.get(Calendar.WEEK_OF_YEAR);
    }

    @Override
    public Long getTimeStamp() {
    Date date  = calendar.getTime();
    date.getTime();
        return  calendar.getTime().getTime();
    }

    @Override
    public String getDateFormatOne() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return  simpleDateFormat.format(calendar.getTime());
    }

    @Override
    public String getDateFormatTwo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd - MM - yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return  simpleDateFormat.format(calendar.getTime());
    }

    @Override
    public String getDateFormatThree() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return  simpleDateFormat.format(calendar.getTime());
    }

    @Override
    public String getDateFormatFour() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE d", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return  simpleDateFormat.format(calendar.getTime());
    }
}
