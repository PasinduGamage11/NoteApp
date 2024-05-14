package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.note.databinding.ActivityUpdateBinding

class Update : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var db:DatabaseHelper
    private var noteId:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_update)


        db= DatabaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)
        if(noteId==-10){
            finish()
            return
        }

        val note=db.getNoteById(noteId)
        binding.Updatetitle.setText(note.title)
        binding.updateContent.setText(note.content)

        binding.UpdatesaveButton.setOnClickListener{
                val newTitle=binding.Updatetitle.text.toString()
                val newContent=binding.updateContent.text.toString()
                val updateNote=Note(noteId,newTitle,newContent)
                db.updateNote(updateNote)
                finish()
                Toast.makeText(this,"changes saved",Toast.LENGTH_SHORT).show()
        }




    }
}