package com.example.realm_assignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private RealmResults<Student> mStudentRealmResults;
    private Context mContext;

    public MyAdapter(RealmResults<Student> student, Context context){
        mStudentRealmResults = student;
        mContext = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new MyViewHolder(view);
    }
    final public String TAG="abc";
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student = mStudentRealmResults.get(position);
        holder.name.setText(student.getName());
        holder.gender.setText(student.getDept());
        holder.phone.setText(student.getPhone());
        holder.roll.setText("ROLL NO: "+student.getRoll()+"");
        holder.gender.setText(student.getGender());
        holder.dept.setText(student.getDept());
    }

    @Override
    public int getItemCount() {
        return mStudentRealmResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name,dept;
        private TextView phone;
        private TextView roll;
        private TextView  gender;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            dept = itemView.findViewById(R.id.dept_tv);
            phone= itemView.findViewById(R.id.phone_tv);
            roll = itemView.findViewById(R.id.roll_tv);
            gender=itemView.findViewById(R.id.gender_tv);
        }
    }
}