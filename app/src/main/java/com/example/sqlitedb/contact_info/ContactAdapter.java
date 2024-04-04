package com.example.sqlitedb.contact_info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitedb.R;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    List<MyContacts> contactsList;
    Context context;

    public ContactAdapter(Context context, List<MyContacts>contactsList){
        this.contactsList = contactsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(contactsList.get(position));
        holder.tvName.setText(contactsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = contactsList.indexOf((MyContacts) v.getTag());

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Contact Details");

                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Id : "+contactsList.get(index).getId()+"\n");
                    stringBuffer.append("Name : "+contactsList.get(index).getName()+"\n");
                    stringBuffer.append("Mobile : "+contactsList.get(index).getMobile()+"\n");
                    stringBuffer.append("Email : "+contactsList.get(index).getEmail()+"\n");
                    stringBuffer.append("Address : "+contactsList.get(index).getAddress()+"\n");
                    stringBuffer.append("Relation : "+contactsList.get(index).getRelation()+"\n");
                    builder.setMessage(stringBuffer);
                    builder.show();
                }
            });
        }
    }
}
