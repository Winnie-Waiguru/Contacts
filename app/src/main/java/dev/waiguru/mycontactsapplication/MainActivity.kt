package dev.waiguru.mycontactsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.waiguru.mycontactsapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }

    fun displayContacts(){
        var contact = Contact("Wangari", "0780980928",
            "wangari@gmail.com", "616 Korongo", "https://images.pexels.com/photos/938013/pexels-photo-938013.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2 = Contact("Risper", "0756789789",
            "risper@gmail.com", "616 Korongo", "https://images.pexels.com/photos/936119/pexels-photo-936119.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact3 = Contact("Brenda", "0790876578",
            "brenda@gmail.com", "616 Korongo", "https://images.pexels.com/photos/904332/pexels-photo-904332.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4 = Contact("Charity", "0767890098",
            "wcharity@gmail.com", "616 Korongo", "https://images.pexels.com/photos/1820919/pexels-photo-1820919.jpeg?auto=compress&cs=tinysrgb&w=400")

        var contactList= listOf(contact,contact2,contact3,contact4)
        var contactAdapter=ContactsRVAdapter(contactList)
        binding.rvContacts.layoutManager =LinearLayoutManager(this)
        binding.rvContacts.adapter =contactAdapter
    }
}