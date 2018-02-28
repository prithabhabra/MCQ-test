package com.example.p3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2  extends Activity{
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity2);
	        TextView T1=(TextView)findViewById(R.id.t1);
	        TextView T2=(TextView)findViewById(R.id.t2);
	        TextView T3=(TextView)findViewById(R.id.t3);
	        
	        String numque=getIntent().getStringExtra("numofque");
	        int nq=Integer.parseInt(numque);
	        T1.setText("No of ques attempted "+Integer.toString(nq));
	        
	        String correctans=getIntent().getStringExtra("correctAns");
	        int ca=Integer.parseInt(correctans);
	        T2.setText("Correct Answer "+Integer.toString(ca));
	        
	        double percent=((ca*100)/nq);
	        T3.setText("Percentage "+Double.toString(percent));
	    }
}
