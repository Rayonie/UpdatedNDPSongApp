package sg.edu.rp.c346.id21045028.myndpsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    Button BtnUpdate,BtnDelete;
    EditText etContentSinger, etContentSongtitle, etContentYear;
    ArrayList<Note> al;
    RadioButton Rbtn1,Rbtn2,Rbtn3,Rbtn4,Rbtn5;
    ArrayAdapter<Note> aa;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        BtnUpdate = findViewById(R.id.btnUpdate);
        BtnDelete = findViewById(R.id.btnDelete);
        Rbtn1 = findViewById(R.id.radioButton);
        Rbtn2 = findViewById(R.id.radioButton2);
        Rbtn3 = findViewById(R.id.radioButton3);
        Rbtn4 = findViewById(R.id.radioButton4);
        Rbtn5 = findViewById(R.id.radioButton5);
        etContentYear = findViewById(R.id.etContentYear);
        etContentSongtitle = findViewById(R.id.etContentSongtitle);
        etContentSinger = findViewById(R.id.etContentSinger);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");
        String title = data.getTitle();
        String singer = data.getSinger();
        String year = data.getYear();
        String rating = data.getRating();
        etContentSongtitle.setText(title);
        etContentSinger.setText(singer);
        etContentYear.setText(year);

        if(rating.length() == 1){
            Rbtn1.setChecked(true);
        }else if(rating.length() == 2){
            Rbtn2.setChecked(true);
        }else if(rating.length() == 3){
            Rbtn3.setChecked(true);
        }else if(rating.length() == 4){
            Rbtn4.setChecked(true);
        }else if(rating.length() == 5){
            Rbtn5.setChecked(true);
        }

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Song = etContentSongtitle.getText().toString();
                String Singer = etContentSinger.getText().toString();
                String Year = etContentYear.getText().toString();
                String star = "";
                if(Rbtn1.isChecked()){
                    star = "*";
                }else if(Rbtn2.isChecked()){
                    star = "**";
                }else if(Rbtn3.isChecked()){
                    star = "***";
                }else if(Rbtn4.isChecked()){
                    star = "****";
                }else if(Rbtn5.isChecked()){
                    star = "*****";
                }
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setTitle(Song);
                data.setSinger(Singer);
                data.setYear(Year);
                data.setRating(star);
                dbh.updateNote(data);
                dbh.close();
                finish();
            }
        });

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());
                finish();
            }
        });

    }
}
