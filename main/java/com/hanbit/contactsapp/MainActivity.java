package com.hanbit.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.contactsapp.domain.Member;
import com.hanbit.contactsapp.presentation.MemberList;
import com.hanbit.contactsapp.service.MemberService;
import com.hanbit.contactsapp.service.MemberServiceImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context=MainActivity.this;
        final MemberService service=new MemberServiceImpl(context);
        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputID= (EditText) findViewById(R.id.inputID);
                EditText inputPW= (EditText) findViewById(R.id.inputPW);
                String sID=inputID.getText().toString();
                String sPW=inputPW.getText().toString();
                String res=service.existsMember(sID);
                if(res.equals("1")){
                    Member member=service.searchMember(sID);
                    if(sPW.equals(member.getPassword())){
                        startActivity(new Intent(context, MemberList.class));
                    }else{
                        Toast.makeText(context,"비번이 일치하지 않음",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(context,sID+" 는 존재하지 않는 ID",Toast.LENGTH_LONG).show();
                }


            }
        });
        findViewById(R.id.joinBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
