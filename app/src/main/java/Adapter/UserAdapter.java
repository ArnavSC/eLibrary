package Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.elibrary.ChatActivity;
import com.example.elibrary.R;

import java.util.List;

import Models.Books;
import Models.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context mContext;
    List<Books> mUsers;
    public UserAdapter(Context mContext, List<Books> mUsers)
    {
        this.mUsers=mUsers;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.user,parent,false);

        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //ViewHolder holder1 = (ViewHolder) holder;
        final Books user= mUsers.get(position);
        holder.username.setText(user.getName());
        holder.author.setText("Author: "+user.getAuthor());
        holder.subject.setText("Subject: "+user.getSubject());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, ChatActivity.class);
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
        public TextView author;
        public TextView subject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            author=itemView.findViewById(R.id.author);
            subject=itemView.findViewById(R.id.subject);
        }
    }

}
