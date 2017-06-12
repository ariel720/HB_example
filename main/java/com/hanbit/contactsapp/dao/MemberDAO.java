package com.hanbit.contactsapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hanbit.contactsapp.domain.Member;

import java.util.ArrayList;
import java.util.List;

import static com.hanbit.contactsapp.domain.Constants.DB_NAME;
import static com.hanbit.contactsapp.domain.Constants.MEM_ADDR;
import static com.hanbit.contactsapp.domain.Constants.MEM_EMAIL;
import static com.hanbit.contactsapp.domain.Constants.MEM_NAME;
import static com.hanbit.contactsapp.domain.Constants.MEM_PHONE;
import static com.hanbit.contactsapp.domain.Constants.MEM_PHOTO;
import static com.hanbit.contactsapp.domain.Constants.MEM_PWD;
import static com.hanbit.contactsapp.domain.Constants.MEM_SEQ;
import static com.hanbit.contactsapp.domain.Constants.TABLE_MEMBER;

/**
 * Created by hb2000 on 2017-06-03.
 */

public class MemberDAO extends SQLiteOpenHelper{

    public MemberDAO(Context context) {
        super(context, DB_NAME, null, 1);
        this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s" +
                "(%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT,%s TEXT," +
                "%s TEXT,%s TEXT,%s TEXT,%s TEXT);",
                TABLE_MEMBER,MEM_SEQ,MEM_NAME,MEM_PWD,MEM_EMAIL,MEM_PHONE,MEM_ADDR,MEM_PHOTO));

        for(int i=1;i<10;i++){
            db.execSQL(
                    String.format(
                    "INSERT INTO %s(%s,%s,%s,%s,%s,%s)" +
                    "VALUES('%s','%s','%s','%s','%s','%s');",
                     TABLE_MEMBER,MEM_NAME,MEM_PWD,MEM_EMAIL,MEM_PHONE,MEM_ADDR,MEM_PHOTO,
                     "홍길동"+i,"1","hong"+i+"@test.com","010-1234-567"+i,"서울"+i,"profileimg"));
        }
        Log.d("########## 실행한 지점","onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertMember(Member member){

    }
    public String countMember(){
        return "";
    }
    public Member selectMember(String seq){
        Cursor cursor=this.getReadableDatabase()
        .rawQuery(String.format("SELECT password FROM %s WHERE %s = '%s'",TABLE_MEMBER,MEM_SEQ,seq),null);
        String result="";
        if (cursor.moveToNext()){
            result=cursor.getString(0);
        }
        Log.d("########비번 결과",result);
        Member m = new Member();
        m.setPassword(result);
        return m;
    }
    public List<Member> selectMembers(){
        Log.d("DAO : ","selectMembers");
        Cursor cursor=this.getReadableDatabase()
                .rawQuery(String.format("SELECT * FROM %s ;",TABLE_MEMBER),null);
        List<Member> list=new ArrayList<>();
        Member m=null;
        if(cursor!=null){
            if (cursor.moveToFirst()){
                do{
                    m=new Member();
                    m.setSeq(Integer.parseInt(cursor.getString(cursor.getColumnIndex(MEM_SEQ))));
                    m.setPassword(cursor.getString(cursor.getColumnIndex(MEM_PWD)));
                    m.setAddr(cursor.getString(cursor.getColumnIndex(MEM_ADDR)));
                    m.setEmail(cursor.getString(cursor.getColumnIndex(MEM_EMAIL)));
                    m.setName(cursor.getString(cursor.getColumnIndex(MEM_NAME)));
                    m.setPhone(cursor.getString(cursor.getColumnIndex(MEM_PHONE)));
                    m.setPhoto(cursor.getString(cursor.getColumnIndex(MEM_PHOTO)));
                    list.add(m);
                }while(cursor.moveToNext());

            }
        }else{
            Log.d("등록된 회원이 ","없습니다.");
        }

        Log.d("###### 전체목록 :",list.get(0).toString());
        return list;
    }
    public void  updateMember(Member member){

    }
    public void deleteMember(int seq){

    }
    public String existsMember(String seq){
       Cursor cursor=this.getReadableDatabase()
               .rawQuery(String.format("SELECT COUNT(*) FROM %s WHERE %s = '%s'",TABLE_MEMBER,MEM_SEQ,seq),null);
        String result="";
        if (cursor.moveToNext()){
            result=cursor.getString(0);
        }
        Log.d("존재여부 :",result);
        return result;
    }
}
