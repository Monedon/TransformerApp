package cl.desafiolatam.transformerapp;

public interface TransformerPresenter {
    void setView(TransformerView view);
    void removeView();
    void setDate(Long date);
    String getStringDate();
    String getDaysOnly();
    String getWeeksOnly();
    Long getTimeStamp();
    String getDateFormatOne();
    String getDateFormatTwo();
    String getDateFormatThree();
    String getDateFormatFour();
}
