package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    static TextView num1;
    static TextView num2;
    static TextView op;
    static TextView res;
    static int a=1,b=0;
    static MaterialButton btnc;
    static MaterialButton btnc1;
    static MaterialButton btnc2;
    static MaterialButton btnac;
    static MaterialButton btnadd;
    static MaterialButton btnsub;
    static MaterialButton btndiv;
    static MaterialButton btnmul;
    static MaterialButton btn1;
    static MaterialButton btn2;
    static MaterialButton btn3;
    static MaterialButton btn4;
    static MaterialButton btn5;
    static MaterialButton btn6;
    static MaterialButton btn7;
    static MaterialButton btn8;
    static MaterialButton btn9;
    static MaterialButton btn0;
    static MaterialButton btneq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.res);
        op = findViewById(R.id.op);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnac = findViewById(R.id.btnac);
        btnc = findViewById(R.id.btnc);
        btneq = findViewById(R.id.btneq);
        btnc1 = findViewById(R.id.btnc1);
        btnc2 = findViewById(R.id.btnc2);
        btnadd = findViewById(R.id.btnadd);
        btnmul = findViewById(R.id.btnmul);
        btnsub = findViewById(R.id.btnsub);
        btndiv = findViewById(R.id.btndiv);
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

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("+");
                a=2;
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("-");
                a=2;
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("*");
                a=2;
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("/");
                a=2;
            }
        });
        btnc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1.setText("");
                a=1;
            }
        });
        btnc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2.setText("");
                a=2;
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a == 1) {
                    String n1 = (String) num1.getText();
                    if(n1.length()==0)
                        return;
                    n1 = n1.substring(0, n1.length() - 1);
                    num1.setText(n1);
                } else if (a == 2&&b==1) {
                    String n2 = (String) num2.getText();
                    if(n2.length()==0)
                        return;
                    n2 = n2.substring(0, n2.length() - 1);
                    num2.setText(n2);
                } else if (a == 2) {
                    op.setText("");
                }

            }
        });
        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2.setText("");
                num1.setText("");
                op.setText("");
                res.setText("");
                a=1;
                b=0;
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in('0');
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('1');
                    }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('2');
                    }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('3');
                    }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('4');
                    }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('5');
                    }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('6');
                    }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('7');
                    }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('8');
                    }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        in('9');
                    }
        });
        btneq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r1 = (String) num1.getText();
                String r2 = (String) num2.getText();
                String rop = (String) op.getText();
                if (r1.length() == 0) {
                    res.setText("Eneter Num1");
                    a = 1;
                    return;
                }
                if (r2.length() == 0) {
                    res.setText("Eneter Num2");
                    a = 2;
                    return;
                }
                if (rop.length() == 0) {
                    res.setText("Eneter OP");
                    return;
                }
                String m= (String) num1.getText();
                String n= (String) op.getText();
                String o= (String) num2.getText();
                String data=m+n+o;
                String r=getResult(data);
                a=4;
                    res.setText(r);
            }
        });
    }
    public static void in(char x){
        if(a==1){
            String n1= (String) num1.getText();
            n1=n1+x;
            num1.setText(n1);
        }
        if(a==2){
        String n2= (String) num2.getText();
        n2=n2+x;
        num2.setText(n2);
        b=1;
        }
    }
    String getResult(String data){
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String fin=context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(fin.endsWith(".0"))
                fin=fin.replace(".0","");
            return fin;
        }
        catch(Exception e){
            return "err";}
    }
}