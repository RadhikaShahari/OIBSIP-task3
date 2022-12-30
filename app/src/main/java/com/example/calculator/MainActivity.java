package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView resultTV,solutionTv;
MaterialButton button_c,button_openbracket,button_closebracket;
MaterialButton buttondivide,buttonmultipy,buttonadd, buttonminus,buttonequals;
MaterialButton button_0,button_1,button_2,button_3,button_4,button_5,button_6,button_7, button_8,button_9,button_AC,button_dot;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV=findViewById(R.id.result_tv);
        solutionTv=findViewById(R.id.solution_tv);
        assignId(button_c,R.id.button_c);
        assignId(button_openbracket,R.id.button_open_bracket);
        assignId(button_closebracket,R.id.button_close_bracket);
        assignId(button_0,R.id.button_0);
        assignId(button_1,R.id.button_1);
        assignId(button_2,R.id.button_2);
        assignId(button_3,R.id.button_3);
        assignId(button_4,R.id.button_4);
        assignId(button_5,R.id.button_5);
        assignId(button_6,R.id.button_6);
        assignId(button_7,R.id.button_7);
        assignId(button_8,R.id.button_8);
        assignId(button_9,R.id.button_9);
        assignId(button_AC,R.id.button_ac);
        assignId(button_dot,R.id.button_dot);
        assignId(buttondivide,R.id.button_divide);
        assignId(buttonmultipy,R.id.button_multiply);
        assignId(buttonadd,R.id.button_add);
        assignId(buttonminus,R.id.button_minus);
        assignId(buttonequals,R.id.button_equal);


    }
    void assignId(MaterialButton btn,int id)
    {
        btn=findViewById(id);
        btn.setOnClickListener((View.OnClickListener) this);

    }
    @Override
    public void onClick(View view)
    {
        MaterialButton button=(MaterialButton) view;
        String buttonText=button.getText().toString();
        String datetocalculate=solutionTv.getText().toString();
        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTV.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            solutionTv.setText(resultTV.getText());
//            resultTV.setText("0");
            return;
        }
        if(buttonText.equals("C")){
            datetocalculate=datetocalculate.substring(0,datetocalculate.length()-1);
        }else{
            datetocalculate=datetocalculate+buttonText;
        }
        solutionTv.setText(datetocalculate);
        String finalResult=getResult(datetocalculate);
        if(!finalResult.equals("Err"))
        {

            resultTV.setText(finalResult);
        }


    }
    String getResult(String data)

    {
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String finalResult=context.evaluateString(scriptable,data,"Javasript",1,null).toString();
            return finalResult;
        }
        catch (Exception e)
        {
            return "Err";
        }
    }

}