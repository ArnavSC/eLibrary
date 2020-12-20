package Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elibrary.ChatActivity;
import com.example.elibrary.R;
import com.example.elibrary.SheetsActivity;

import java.util.List;

import Models.Books;
import Models.Lecture;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.ViewHolder> {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.adapter_lecture);
//    }
    Context mContext;
    List<Lecture> mUsers;
    public LectureAdapter(Context mContext, List<Lecture> mUsers)
    {
        this.mUsers=mUsers;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public LectureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_lecture,parent,false);

        return new LectureAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureAdapter.ViewHolder holder, int position) {

        //ViewHolder holder1 = (ViewHolder) holder;
        final Lecture user= mUsers.get(position);
        holder.username.setText(user.getName());
        holder.subject.setText("Subject: "+user.getSubject());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, SheetsActivity.class);
                intent.putExtra("link",user.getLink());
                intent.putExtra("name",user.getName());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView username;
        public TextView subject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            subject=itemView.findViewById(R.id.subject);
        }
    }
}