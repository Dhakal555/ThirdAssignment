package com.example.esoftwarica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.model.ProfileList;
import com.example.esoftwarica.R;

import java.util.List;

public class Adapter_ProfileList extends  RecyclerView.Adapter<Adapter_ProfileList.ProfileListViewHolder>{

    Context mContext;
    List<ProfileList> proList;

    public Adapter_ProfileList(Context mContext, List<ProfileList> proList){
        this.mContext = mContext;
        this.proList = proList;
    }

    @NonNull
    @Override
    public ProfileListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card, parent, false);
        return new ProfileListViewHolder(view, mContext, proList);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileListViewHolder holder, int position) {
        ProfileList profileList =proList.get(position);
        holder.tvFullName.setText(profileList.getFullName());
        holder.tvAddress.setText(profileList.getAddress());
        holder.tvAge.setText(profileList.getAge() + "");
        holder.rdoGender.setText(profileList.getGender());
        holder.imagePerson.setImageResource(profileList.getImageID());
    }

    @Override
    public int getItemCount() {
        return proList.size();
    }

    public class ProfileListViewHolder extends RecyclerView.ViewHolder{
        TextView tvFullName,tvAddress, tvAge, rdoGender, imageDel;
        ImageView imagePerson;

        Context cont;
        List<ProfileList> profile;

        public ProfileListViewHolder(@NonNull View itemView, Context mContext, List<ProfileList> proList) {
            super(itemView);

            tvFullName = itemView.findViewById(R.id.txtName);
            tvAddress = itemView.findViewById(R.id.txtAddress);
            tvAge = itemView.findViewById(R.id.txtAge);
            rdoGender = itemView.findViewById(R.id.txtGender);
            imagePerson = itemView.findViewById(R.id.imgPerson);
            imageDel = itemView.findViewById(R.id.txtDel);

            this.cont = mContext;
            this.profile = proList;

            imageDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    profile.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }

    }
}
