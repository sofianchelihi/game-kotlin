package com.example.tp2_exo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp2_exo2.databinding.ActivityMain2Binding
import com.example.tp2_exo2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var phrases  :MutableList<Phrase2> = Phrases2("phrases2.txt",this).phrases
        var user : User = User(0,0)
        var i = 0
        binding.phraseNc.setText(phrases[i].phrase)


        binding.button5.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val input= binding.inputMot.text.toString().replace("\\s".toRegex(), "")
            if(input.isEmpty()){
                Toast.makeText(this,"Ecrire la reponse avant l'envoyer ! ...", Toast.LENGTH_SHORT).show()
            }else{
                if(i>=phrases.size){
                    Toast.makeText(this,"Le jeux est terminé .", Toast.LENGTH_SHORT).show()
                }else{
                    user.Nb_reponses+=1
                    binding.nbr2.setText(user.Nb_reponses.toString())
                    if(input.equals(phrases[i].mot.replace("\\s".toRegex(), ""))){
                        user.score+=5
                        binding.score2.setText(user.score.toString())
                        binding.text10.setText("Bravo Vous avez obtenu +5 points, le score total est :${user.score} pour ${user.Nb_reponses} reponses .")
                    }else{
                        binding.text10.setText("Reponse incorrect : ${phrases[i].mot}")
                    }
                    i++
                    binding.inputMot.setText("")
                    if(i<phrases.size) binding.phraseNc.setText(phrases[i].phrase)
                    else binding.phraseNc.setText("")
                }

            }
        }

    }
}