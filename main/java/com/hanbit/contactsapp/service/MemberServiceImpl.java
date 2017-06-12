package com.hanbit.contactsapp.service;

import android.content.Context;
import android.util.Log;

import com.hanbit.contactsapp.dao.MemberDAO;
import com.hanbit.contactsapp.domain.Member;

import java.util.List;

/**
 * Created by hb2000 on 2017-06-03.
 */

public class MemberServiceImpl implements MemberService{
    MemberDAO dao;
    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }
    @Override
    public void addMember(com.hanbit.contactsapp.domain.Member member) {

    }
    @Override
    public String existsMember(String seq) {
        return dao.existsMember(seq);
    }

    @Override
    public String countMembers() {
        return "";
    }

    @Override
    public Member searchMember(String seq) {

        return dao.selectMember(seq);
    }

    @Override
    public List<Member> getMembers() {
        Log.d("서비스 : ","getMembers");
        return dao.selectMembers();
    }

    @Override
    public void changeMember(com.hanbit.contactsapp.domain.Member member) {

    }

    @Override
    public void removeMember(String seq) {

    }
}
