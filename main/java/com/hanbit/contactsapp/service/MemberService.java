package com.hanbit.contactsapp.service;

import com.hanbit.contactsapp.domain.Member;

import java.util.List;

/**
 * Created by hb2000 on 2017-06-03.
 */

public interface MemberService {
    public void addMember(Member member);
    public String existsMember(String seq);
    public String countMembers();
    public Member searchMember(String seq);
    public List<Member> getMembers();
    public void  changeMember(Member member);
    public void removeMember(String seq);
}
