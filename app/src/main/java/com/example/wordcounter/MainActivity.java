package com.example.wordcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Spinner spCounterOption;
    private EditText etEnteredText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spCounterOption = findViewById(R.id.spCounterOption);
        this.etEnteredText = findViewById(R.id.etEnteredText);
        this.tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCounterOption.setAdapter(adapter);
    }

    public void onBtnCount(View view) {
        Toast.makeText(this, this.spCounterOption.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        String spSelectedOption = this.spCounterOption.getSelectedItem().toString();
        String charString = getString(R.string.selection_chars);
        String wordString = getString(R.string.selection_words);

        if(spSelectedOption.equalsIgnoreCase(charString)) {
            String enteredUserText = this.etEnteredText.getText().toString();
            int charsCount = TextCounter.getCharsCount(enteredUserText);

            this.tvResult.setText(String.valueOf(charsCount));
        }
        else if(spSelectedOption.equalsIgnoreCase(wordString)) {
            String enteredUserText = this.etEnteredText.getText().toString();
            int wordsCount = TextCounter.getWordsCount(enteredUserText);


            this.tvResult.setText(String.valueOf(wordsCount));
        }
        else{
            Toast.makeText(this,"Not implemented", Toast.LENGTH_SHORT);
        }
    }
}