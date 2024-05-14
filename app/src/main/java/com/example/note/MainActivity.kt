package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var db:DatabaseHelper
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= DatabaseHelper(this)
        notesAdapter= NotesAdapter(db.getAllnotes(),this)

        binding.noteRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.noteRecyclerView.adapter=notesAdapter

        binding.addButton.setOnClickListener{
            val intent=Intent(this,Addnote::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        notesAdapter.refreshData(db.getAllnotes())
    }
}