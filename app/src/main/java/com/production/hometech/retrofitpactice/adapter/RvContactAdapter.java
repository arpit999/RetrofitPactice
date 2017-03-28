package com.production.hometech.retrofitpactice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.production.hometech.retrofitpactice.R;
import com.production.hometech.retrofitpactice.model.Contact;

import java.util.List;

/**
 * Created by Arpit on 27-Mar-17.
 */

public class RvContactAdapter extends RecyclerView.Adapter<RvContactAdapter.ContactHolder> {

    public List<Contact.ContactsBean> contactsList;
    Context context;

    public RvContactAdapter(List<Contact.ContactsBean> contactsList, Context context) {
        this.contactsList = contactsList;
        this.context = context;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contact_row, parent, false);

        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {

        Contact.ContactsBean contact = contactsList.get(position);
        holder.name.setText(contact.getName());
        holder.contact.setText("M : "+contact.getPhone().getMobile());
        holder.gender.setText("Gender : "+contact.getGender());
        holder.email.setText(contact.getEmail());

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }


    public class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name, contact, email, gender;
        LinearLayout linearLayout;

        public ContactHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tv_name);
            contact = (TextView) itemView.findViewById(R.id.tv_contact);
            email = (TextView) itemView.findViewById(R.id.tv_email);
            gender = (TextView) itemView.findViewById(R.id.tv_gender);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayout);

            contact.setOnClickListener(this);
            name.setOnClickListener(this);
            linearLayout.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (v.getId() == name.getId()) {

                Toast.makeText(v.getContext(), "  "+contactsList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

            } else if (v.getId() == contact.getId()) {

                Toast.makeText(v.getContext(), ""+contactsList.get(getAdapterPosition()).getPhone().getMobile() , Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }

        }
    }

}
