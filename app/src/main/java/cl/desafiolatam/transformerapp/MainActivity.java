package cl.desafiolatam.transformerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;

public class MainActivity extends AppCompatActivity implements TransformerView {

    private TransformerPresenter presenter;
    private MaterialButton selectDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new TransformerPresenterImpl();
        presenter.setView(this);
        selectDate = findViewById(R.id.selectDateButton);
        selectDate.setOnClickListener(view -> displayCalendar());
        Button dayOfTheMonth = findViewById(R.id.dayOfTheMonth);
        dayOfTheMonth.setOnClickListener(view -> selectDate.setText(presenter.getDaysOnly()));
        Button weekOfTheYear = findViewById(R.id.weekOfYear);
        weekOfTheYear.setOnClickListener(view -> selectDate.setText(presenter.getWeeksOnly()));
        Button timeStamp = findViewById(R.id.timeStamp);
        timeStamp.setOnClickListener(view -> selectDate.setText("TimeStamp: " + presenter.getTimeStamp()));
        Button firstFormat = findViewById(R.id.firstFormat);
        firstFormat.setOnClickListener(view -> selectDate.setText(presenter.getDateFormatOne()));
        Button secondFormat = findViewById(R.id.secondFormat);
        secondFormat.setOnClickListener(view -> selectDate.setText(presenter.getDateFormatTwo()));
        Button thirdFormat = findViewById(R.id.thirdFormat);
        thirdFormat.setOnClickListener(view -> selectDate.setText(presenter.getDateFormatThree()));
        Button fourthFormat = findViewById(R.id.fourthFormat);
        fourthFormat.setOnClickListener(view -> selectDate.setText(presenter.getDateFormatFour()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }

    private void displayCalendar() {
        MaterialDatePicker.Builder<Long> dialog = MaterialDatePicker.Builder.datePicker();
        dialog.setTitleText(R.string.select_date);
        MaterialDatePicker<Long> picker = dialog.build();
        picker.show(getSupportFragmentManager(), getString(R.string.select_date));
        picker.addOnNegativeButtonClickListener(view -> picker.dismiss());
        picker.addOnPositiveButtonClickListener(selection -> {

            presenter.setDate(selection);
            picker.dismiss();
        });
    }


    @Override
    public void showDateResult() {
        selectDate.setText(presenter.getStringDate());
    }

    @Override
    public void showMathResult() {
        //empty for now
    }
}