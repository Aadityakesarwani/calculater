package com.modernapps.tabs.fragments;

import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.modernapps.tabs.MainActivity;
import com.modernapps.tabs.R;
import com.modernapps.tabs.databinding.CalcLayoutBinding;

//import org.mariuszgromada.math.mxparser.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Objects;


@RequiresApi(api = Build.VERSION_CODES.M)
public class Calc extends Fragment  {
    String pattern = "###,###.##";
    DecimalFormat df = new DecimalFormat(pattern);
    NumberFormat nf = NumberFormat.getNumberInstance();
StringBuffer sb = new StringBuffer();


  ImageButton imageButton;


    boolean checkBracket = false;
   TextView input;
   TextView output;

    String userInput = " ";
    Button b9, b8, b7, b6, b5, b4, b3, b2, b1, b0,  allClean, ans, back, percent, minus, sum, multiply, divide, dot,bracket;

    CalcLayoutBinding binding;

    String result = " ";
    private View view;



    public Calc() {
    }

//    Vibrator v = (Vibrator)((MainActivity)getActivity()).getSystemService(android.content.Context.VIBRATOR_SERVICE);
     //Vibrator v = (Vibrator)getActivity().getSystemService(android.content.Context.VIBRATOR_SERVICE);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = CalcLayoutBinding.inflate(inflater, container, false);

            Double s  = Double.valueOf(input.getText().toString());
            Double a  = Double.valueOf(input.getText().toString());


        b1 = binding.b1;
        b2 = binding.b2;
        b3 = binding.b3;
        b4 = binding.b4;
        b5 = binding.b5;
        b6 = binding.b6;
        b7 = binding.b7;
        b8 = binding.b8;
        b9 = binding.b9;
        b0 = binding.b0;
        bracket = binding.bracket;
        dot = binding.dot;
        ans = binding.ans;
        sum = binding.sum;
        minus = binding.minus;
        multiply = binding.multiply;
        divide = binding.divide;
        back = binding.back;
        percent = binding.percent;
        allClean = binding.AllClean;
        input = binding.inputTv;
        output = binding.outputTv;
        imageButton= binding.imageButoon;

        b0.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                setUpText("0");

            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("1");
                //updateText("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("2");
                // updateText("5");

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("3");
                // updateText("5");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("4");
                // updateText("5");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("5");
                // updateText("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("6");
                // updateText("5");
            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("7");
                // updateText("5");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //updateText("8");
                setUpText("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpText("9");
                //  updateText("5");
            }
        });


        bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBracket) {
                    result = input.getText().toString();
                    setUpExp( ")");
                   checkBracket = false;
                }
                else{
                result = input.getText().toString();
                setUpExp("(");
                    checkBracket = true;
                }
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          setUpExpForDecimal(".");
                //updateText(".");
              //  setUpText(".");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // input.setText("÷");
//                setUpExpForDecimal("÷");
                // updateText("÷");
            }
        });

        allClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clean();
            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               updateText("×");
                setUpExp("×");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpExp("+");
                //   updateText("+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // updateText("-");
                setUpExp("-");
               // setUpOp("-");
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // updateText("-");
             // setUpExp("%");
                setUpExpForDecimal("%");
                //setUpOp("%");
            }
        });

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // updateText("-");
//
            }
        });
       imageButton.setOnClickListener(new View.OnClickListener() {
           Fragment fragment;
           @Override
           public void onClick(View view) {
                fragment = new historyFragment();
                replaceFragment(fragment);
            }
        });
        return binding.getRoot();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager= getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
       transaction.setReorderingAllowed(true);
        transaction.replace(R.id.content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    void showHistory(){
        input.getText();
        output.getText();
    }

    void clean() {
       input.setText(" ");
        userInput = " ";
       output.setText(" ");
    }

    private void answer(){
        String myExp = input.getText().toString();
        myExp = myExp.replaceAll("÷", "/");
        myExp = myExp.replaceAll("×", "*");
        myExp = myExp.replaceAll("%", "/100");

        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);

        try{
            Scriptable scriptable = rhino.initStandardObjects();
            result = rhino.evaluateString(scriptable, myExp ,"javascript",1,null).toString();
        }catch(Exception e){
                result = input.getText().toString();
        }
        result = result.substring(0,result.length()-2);
        output.setText(("="+result));
    }

    private void answerForDecimal(){
        String myExp = input.getText().toString();
        myExp = myExp.replaceAll("÷", "/");
        myExp = myExp.replaceAll("×", "*");
        myExp = myExp.replaceAll("%", "/100");
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try{
            Scriptable scriptable = rhino.initStandardObjects();
            result = rhino.evaluateString(scriptable, myExp ,"javascript",1,null).toString();
        }catch(Exception e){
            result = input.getText().toString();
        }
        output.setText("="+result);
    }

   private void setUpText(String val){
        userInput = userInput +val;
        input.setText(userInput);
       answerForDecimal();
       answer();
   }
    private void setUpExp(String val){
        userInput = userInput + " " +val;
        input.setText(userInput);
        answer();
    }


    private void setUpExpForDecimal(String val){
        userInput = userInput+val;
        input.setText(userInput);
       answerForDecimal();
    }


//    for input delete
    private void back(){

       String newText = input.getText().toString();
      String s = newText.substring(0,input.length()-1);
      input.setText(s);
     answer();
        ret();
    }
private static final String z = "O";
    public void ret(){

        if(input.length()==1){
        output.setText(z);
    }
    }
    }

/*









 private void updateText(String strToAdd)
    {
        input = binding.inputTv;
        String oldStr = input.getText().toString();
        int cursPos;
        cursPos = input.getSelectionStart();
        String leftStr = oldStr.substring(0,cursPos);
        String rightStr = oldStr.substring(cursPos);
        input.setText(String.format(leftStr,strToAdd,rightStr));



     ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userExp = input.getText().toString();
                userExp = userExp.replaceAll("÷","/");
                userExp = userExp.replaceAll("×","*");

                Expression  exp = new Expression(userExp);
                String result = String.valueOf(exp.calculate());

                input.setText(result);

            }
        });



  private void instantAns() {
        String userExp = input.getText().toString();
        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        output.setText("=" +result);
    }


        public void answer() {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval("=" + input);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        if (result != null)
           output.setText(String.valueOf(result.doubleValue()));
    }
 */
