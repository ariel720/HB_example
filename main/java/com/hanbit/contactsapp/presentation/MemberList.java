package com.hanbit.contactsapp.presentation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hanbit.contactsapp.R;
import com.hanbit.contactsapp.domain.Member;
import com.hanbit.contactsapp.service.MemberService;
import com.hanbit.contactsapp.service.MemberServiceImpl;

import java.util.ArrayList;

public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list);
        final Context context=MemberList.this;
        MemberService service=new MemberServiceImpl(context);
        final ArrayList<Member> list=(ArrayList<Member>) service.getMembers();
        Log.d("Activity 전체목록 :",list.get(8).toString());
        ListView listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MemberAdapter(context,list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }

    private class MemberAdapter extends BaseAdapter{
        ArrayList<Member>list;
        LayoutInflater inflater;
        public MemberAdapter(Context context, ArrayList<Member> list) {
            this.list=list;
            this.inflater=LayoutInflater.from(context);
        }
        private int[] photos={
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
        };

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View v, ViewGroup g) {
            ViewHolder holder;
            if(v==null){
                v=inflater.inflate(R.layout.member_item,null);
                holder=new ViewHolder();
                holder.profileimg= (ImageView) v.findViewById(R.id.profileimg);
                holder.name= (TextView) v.findViewById(R.id.name);
                holder.phone= (TextView) v.findViewById(R.id.phone);
                v.setTag(holder);
            }else{
                holder= (ViewHolder) v.getTag();
            }
            holder.profileimg.setImageResource(photos[i]);
            holder.name.setText(list.get(i).getName());
            holder.phone.setText(list.get(i).getPhone());
            return v;
        }
    }
    static class ViewHolder{
        ImageView profileimg;
        TextView name;
        TextView phone;
    }
}
