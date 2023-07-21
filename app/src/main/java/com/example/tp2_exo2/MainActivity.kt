package com.example.tp2_exo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.tp2_exo2.databinding.ActivityMainBinding
import com.example.tp2_exo2.databinding.ItemBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var phrases  :MutableList<Phrase> = Phrases("phrases.txt",this).phrases
        var user : User = User(0,0)
        var i = 0
        binding.phraseNo.setText(phrases[i].phrase_non_ord)


        binding.button3.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }


        binding.button2.setOnClickListener {
            val input= binding.editTextTextPersonName.text.toString().replace("\\s".toRegex(), "")
            if(input.isEmpty()){
                Toast.makeText(this,"Ecrire la reponse avant l'envoyer ! ...", Toast.LENGTH_SHORT).show()
            }else{
                if(i>=phrases.size){
                    Toast.makeText(this,"Le jeux est terminé .", Toast.LENGTH_SHORT).show()
                }else{
                    user.Nb_reponses+=1
                    binding.nbr.setText(user.Nb_reponses.toString())
                    if(input.equals(phrases[i].phrase_ord.replace("\\s".toRegex(), ""))){
                        user.score+=5
                        binding.score.setText(user.score.toString())
                        binding.textView10.setText("Bravo Vous avez obtenu +5 points, le score total est :${user.score} pour ${user.Nb_reponses} reponses .")
                    }else{
                        binding.textView10.setText("Reponse incorrect : ${phrases[i].phrase_ord}")
                    }
                    i++
                    binding.editTextTextPersonName.setText("")
                    if(i<phrases.size) binding.phraseNo.setText(phrases[i].phrase_non_ord)
                    else binding.phraseNo.setText("")
                }

            }
        }

        // Test pour l'insertion dynamique des element layout (Pour les autre projets )
      /*  val container = binding.main

        val dynamicLayout = layoutInflater.inflate(R.layout.item, container, false)
        dynamicLayout.findViewById<Button>(R.id.button).setText("sofian")
        container.addView(dynamicLayout)*/

    }
}