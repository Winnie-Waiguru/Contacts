package dev.waiguru.mycontactsapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.waiguru.mycontactsapplication.databinding.ContactListItemBinding

class ContactsRVAdapter(var contactList: List<Contact>):
RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding=ContactListItemBinding

         .inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val context = holder.itemView.context
      var currentContact = contactList.get(position)
        with(holder.binding) {
            tvName.text = currentContact.name
            tvPhoneNum.text = currentContact.phone
            tvEmail.text = currentContact.email
            tvAddress.text = currentContact.address
            cvContact.setOnClickListener{
                val intent= Intent(context,ViewContactActivity::class.java)
                intent.putExtra("NAME",currentContact.name)
                intent.putExtra("PHONE_NUMBER",currentContact.phone)
                intent.putExtra("EMAIL",currentContact.email)
                intent.putExtra("ADDRESS",currentContact.address)
                intent.putExtra("IMAGE",currentContact.image)
                context.startActivity(intent)
            }
            holder.binding.imgContact.setOnClickListener{
                Toast.makeText(context,"You have clicked my face",Toast.LENGTH_LONG)
                    .show()
            }
        }
        Picasso.get()
            .load(currentContact.image)
            .error(R.drawable.ic_baseline_cancel_24)
            .resize(200,300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(holder.binding.imgContact)



    }

    override fun getItemCount(): Int {
     return contactList.size
    }

}

class ContactsViewHolder(var binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root){

}