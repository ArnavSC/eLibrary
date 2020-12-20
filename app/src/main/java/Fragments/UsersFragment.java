package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.elibrary.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.LectureAdapter;
import Adapter.UserAdapter;
import Models.Books;
import Models.Lecture;
import Models.User;

public class UsersFragment extends Fragment {

    private RecyclerView recyclerView;

    private UserAdapter userAdapter;
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    SearchView searchView;
    private List<Books> mUsers=new ArrayList<>();
    private List<Books> mNew=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_users, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        searchView=(SearchView) view.findViewById(R.id.search);

        readUsers();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String b) {
//                mNew.clear();
//
//                if (b!="all") {
//                    for (int i = 0; i < mUsers.size(); i++) {
//                        if (mUsers.get(i).getSubject().contains(b)) {
//                            mNew.add(mUsers.get(i));
//                        }
//                        userAdapter = new LectureAdapter(getContext(), mNew);
//                        recyclerView.setAdapter(userAdapter);
//                    }
//                }
//                else
//                {
//                    userAdapter= new LectureAdapter(getContext(), mUsers);
//                    recyclerView.setAdapter(userAdapter);
//                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String supersub) {
                mNew.clear();
                supersub=supersub.toLowerCase();
                for (int i = 0; i < mUsers.size(); i++) {
                    if (mUsers.get(i).getName().toLowerCase().contains(supersub)||
                            mUsers.get(i).getAuthor().toLowerCase().contains(supersub)||
                            mUsers.get(i).getSubject().toLowerCase().contains(supersub)) {
                        mNew.add(mUsers.get(i));
                    }
                    userAdapter = new UserAdapter(getContext(), mNew);
                    recyclerView.setAdapter(userAdapter);
                }

                return false;
            }
        });
        return view;
    }

    private void readUsers() {
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference=mDatabase.getReference("books");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String u=""+snapshot.getValue();
                    Books user = snapshot.getValue(Books.class);
                    Log.d("That's",u);
                    assert user!=null;
                    assert firebaseUser!=null;
                    mUsers.add(user);

                }
                userAdapter= new UserAdapter(getContext(), mUsers);
                recyclerView.setAdapter(userAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}