package com.prabhat.firstsignin.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> mContact;

    public ContactsAdapter(List<Contact> Contact) {
        mContact = Contact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context =parent.getContext();
        LayoutInflater inflater =LayoutInflater.from(context);
        View contactView= inflater.inflate(R.layout.item_contact,parent,false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Contact contact = mContact.get(position);

        TextView textView =viewHolder.nameTextView;

        textView.setText(contact.getmName());

        Button mButton= viewHolder.messageButton;

        mButton.setText(contact.ismOnline()?"Message":"Offline");
        mButton.setEnabled(contact.ismOnline());

    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            nameTextView =itemView.findViewById(R.id.contact_name);

            messageButton = itemView.findViewById(R.id.message_button);
        }
    }
}
