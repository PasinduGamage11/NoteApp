package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.note.databinding.ActivityAddnoteBinding

class Addnote : AppCompatActivity() {

    private lateinit var binding:ActivityAddnoteBinding
    private lateinit var db:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddnoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= DatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title=binding.titleEdit.text.toString()
            val content=binding.contentEdit.text.toString()
            val note=Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show()
        }
    }
}