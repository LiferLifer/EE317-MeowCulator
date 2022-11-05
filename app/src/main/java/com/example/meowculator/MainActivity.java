package com.example.meowculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0; // 数字按钮
    Button jia, jian, cheng, chu, dian, clear, back, minus, ans;// 运算符
    ImageButton sum;
    EditText edit;


    private String data = "";
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        cheng = findViewById(R.id.cheng);
        chu = findViewById(R.id.chu);
        sum = findViewById(R.id.calculation);
        dian = findViewById(R.id.dian);
        clear = findViewById(R.id.clear);
        edit = findViewById(R.id.edit);
        back = findViewById(R.id.back);
        minus = findViewById(R.id.minus);
        ans = findViewById(R.id.ans);

        btn1.setOnClickListener(new Click());
        btn2.setOnClickListener(new Click());
        btn3.setOnClickListener(new Click());
        btn4.setOnClickListener(new Click());
        btn5.setOnClickListener(new Click());
        btn6.setOnClickListener(new Click());
        btn7.setOnClickListener(new Click());
        btn8.setOnClickListener(new Click());
        btn9.setOnClickListener(new Click());
        btn0.setOnClickListener(new Click());
        jia.setOnClickListener(new Click());
        jian.setOnClickListener(new Click());
        cheng.setOnClickListener(new Click());
        chu.setOnClickListener(new Click());
        sum.setOnClickListener(new Click());
        dian.setOnClickListener(new Click());
        clear.setOnClickListener(new Click());
        edit.setOnClickListener(new Click());
        back.setOnClickListener(new Click());
        minus.setOnClickListener(new Click());
        ans.setOnClickListener(new Click());
    }

    class Click implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.dian: {
                    if (data.length() == 0) {
                        edit.setText("0.");
                    } else {
                        data += ".";
                        edit.setText(data);
                    }
                }
                break;
                case R.id.jia: {
                    if (data.length() == 0) {
//                        edit.setText("0 + ");
//                        ss = "0 + ";
                        break;
                    }
                    if (data.contains(" ")) {
                        if (data.indexOf(" ") == data.length() - 3)
                            break;
                        getResult();
                    }

                    data += " + ";
                    edit.setText(data);
                }
                break;
                case R.id.jian: {
                    if (data.length() == 0) {
                        edit.setText("0 - ");
                        data = "0 - ";
                        break;
                    }
                    if (data.contains(" ")) {
                        if (data.indexOf(" ") == data.length() - 3 )
                            break;
                        getResult();
                    }

                    data += " - ";
                    edit.setText(data);
                }
                break;
                case R.id.cheng: {
                    if (data.length() == 0) {
                        edit.setText("0 × ");
                        data = "0 × ";
                        break;
                    }
                    if (data.contains(" ")) {
                        if (data.indexOf(" ") == data.length() - 3)
                            break;
                        getResult();
                    }

                    data += " × ";
                    edit.setText(data);
                }
                break;
                case R.id.chu: {
                    if (data.length() == 0) {
                        edit.setText("0 / ");
                        data = "0 / ";
                        break;
                    }
                    if (data.contains(" ")) {
                        if (data.indexOf(" ") == data.length() - 3)
                            break;
                        getResult();
                    }

                    data += " / ";
                    edit.setText(data);
                }
                break;
                case R.id.calculation:{
                    getResult();
                }
                break;
                case R.id.back:
                    if(data.length() != 0) {
                        String s = "";
                        if(data.length() >= 3){
                            s = data.substring(data.length()-3);
                        }
                        if(s.equals(" + ") || s.equals(" - ") || s.equals(" * ") || s.equals(" / ")) {
                            data = data.substring(0, data.length() - 3);
                            edit.setText(data);
                        }else{
                            data = data.substring(0, data.length() - 1);
                            edit.setText(data);
                        }
                    }
                    break;
                case R.id.minus:
                    String ata = data.substring(1);
                    if(ata.contains("+") || ata.contains("-") || ata.contains("×") || ata.contains("/")){
                        break;
                    }
                    if(data.charAt(0) == '-'){
                        data = data.substring(1);
                    }else{
                        data = "-" + data;
                    }
                    edit.setText(data);
                    break;
                case R.id.clear: {
                    data = "";
                    edit.setText(data);
                }
                break;
                case  R.id.ans: {
                    if(data.charAt(data.length() - 1) == ' '){
                        data += answer;
                        edit.setText(data);
                    }
                }
                break;

                case R.id.btn0: {
                    data += "0";
                    if(data.length() > 1){
                        if(data.charAt(0) == '0' && data.substring(1).charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                            data = data.substring(1);
                        }
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn1: {
                    data += "1";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn2: {
                    data += "2";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn3: {
                    data += "3";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn4: {
                    data += "4";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn5: {
                    data += "5";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn6: {
                    data += "6";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn7: {
                    data += "7";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn8: {
                    data += "8";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
                case R.id.btn9: {
                    data += "9";
                    if(data.charAt(0) == '0' && !data.contains(".") && !data.contains(" ")){
                        data = data.substring(1);
                    }
                    edit.setText(data);
                }
                break;
            }
        }


    }

    private void getResult() {
        double result = 0;
        if (data == null || data.equals("")) return;
        if (!data.contains(" ")) return;
        String s1 = data.substring(0, data.indexOf(" "));
        String op = data.substring(data.indexOf(" ") + 1, data.indexOf(" ") + 2);
        String s2 = data.substring(data.indexOf(" ") + 3);
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            switch (op) {
                case "+":
                    result = d1 + d2;
                    break;
                case "-":
                    result = d1 - d2;
                    break;
                case "×":
                    result = d1 * d2;
                    break;
                case "/": {
                    if (d2 == 0) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        break;

                    }
                    result = d1 / d2 * 1.0;
                }
                break;
            }
            int r = (int) result;
            if (r == result) {
                data = "" + r;
                edit.setText(data);
                answer = data;
            } else {
                data = "" + result;
                edit.setText(data);
                answer = data;
            }
        }
    }
}
