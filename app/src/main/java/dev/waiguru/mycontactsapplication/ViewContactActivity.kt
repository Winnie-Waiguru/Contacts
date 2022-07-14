package dev.waiguru.mycontactsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.waiguru.mycontactsapplication.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){
        val extras =intent.extras
        var name=extras?.getString("NAME","")
        var phone=extras?.getString("PHONE_NUMBER","")
        var email=extras?.getString("EMAIL","")
        var address=extras?.getString("ADDRESS","")
        var image=binding.imgImage

        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        Toast.makeText(this,phone, Toast.LENGTH_LONG).show()
        Toast.makeText(this,email,Toast.LENGTH_LONG).show()
        Toast.makeText(this,address,Toast.LENGTH_LONG).show()


        binding.tvContactName.text=name
        binding.tvPhoneNo.text=phone
        binding.tvEmail2.text=email
        binding.tvHomeAddress.text=address
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)

    }
}