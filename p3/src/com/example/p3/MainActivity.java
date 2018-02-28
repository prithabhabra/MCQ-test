package com.example.p3;

import android.os.Bundle;
import android.app.Activity;
import android.net.Uri;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener{

	String[] ans={"64","nondeterministic PDA to deterministic PDA","Complementation","Ambiguous","regular language","[(00+11) (0+1)*] + [( 0 + 1)* (00+11)]","b*a*","S1 is correct and S2 is not correct","(1 + 01)* (0 + lambda)","strings contain equal number of a's and equal number of b's"};
	private Button bt1; int counter = 0;
	private RadioGroup rg1, rg2, rg3, rg4, rg5, rg6, rg7, rg8, rg9, rg10;
	char[] total=new char[20]; 
	int n;
	private int progressStatus = 0;
	int cnt = 10;
	int[] marked=new int[50];
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		// TODO Auto-generated method stub
    	rg1=(RadioGroup)findViewById(R.id.Rg1);
        rg1.setOnCheckedChangeListener(this);
        rg2=(RadioGroup)findViewById(R.id.Rg2);
        rg2.setOnCheckedChangeListener(this);
        rg3=(RadioGroup)findViewById(R.id.Rg3);
        rg3.setOnCheckedChangeListener(this);
        rg4=(RadioGroup)findViewById(R.id.Rg4);
        rg4.setOnCheckedChangeListener(this);
        rg5=(RadioGroup)findViewById(R.id.Rg5);
        rg5.setOnCheckedChangeListener(this);
        rg6=(RadioGroup)findViewById(R.id.Rg6);
        rg6.setOnCheckedChangeListener(this);
        rg7=(RadioGroup)findViewById(R.id.Rg7);
        rg7.setOnCheckedChangeListener(this);
        rg8=(RadioGroup)findViewById(R.id.Rg8);
        rg8.setOnCheckedChangeListener(this);
        rg9=(RadioGroup)findViewById(R.id.Rg9);
        rg9.setOnCheckedChangeListener(this);
        rg10=(RadioGroup)findViewById(R.id.Rg10);
        rg10.setOnCheckedChangeListener(this);
        
        bt1=(Button)findViewById(R.id.btn1);
        bt1.setOnClickListener(new OnClickListener(){
	
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					int correctAns=0;
					for(int j=1;j<=n;j++){
						if(total[j]=='y')
							correctAns++;
					}
					if(counter==0)
					{
						counter++;
						String res=Integer.toString(correctAns);
						Intent i=new Intent(getApplicationContext(),Activity2.class);
						i.putExtra("correctAns",res);
						String noQue=Integer.toString(--cnt/10);
						i.putExtra("numofque",noQue);
						startActivity(i);
					}
					else
			        	Toast.makeText(getApplicationContext(),"Cannot submit again",Toast.LENGTH_LONG).show();
				}
	        	
	        });
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		RadioButton O=(RadioButton)findViewById(checkedId);
		n=Integer.parseInt( (String) group.getTag());
		for (String an : ans) {
			if(O.getText().equals(an))
			{
				total[n]='y';
				break;
			}
			else
				total[n]='n';
		}
		if(marked[n]!=n)
		{
			marked[n]=n;
			ProgressBar pb = (ProgressBar)findViewById(R.id.pb);
			pb.setMax(10);
			pb.incrementProgressBy(1);
			final TextView tv = (TextView)findViewById(R.id.tv);
			if(cnt<=100){
				tv.setText(String.valueOf(cnt));
				cnt+=10;
			}
		O.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressStatus=0;
				new Thread(new Runnable()
				{
					public void run(){
						while(progressStatus<10){
							progressStatus+=1;
							
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}).start();	
			}
		});
		}
	}

	
}

