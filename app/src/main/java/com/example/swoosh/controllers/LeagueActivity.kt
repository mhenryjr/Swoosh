package com.example.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        leagueNextClicked.setOnClickListener{
            if (selectedLeague != ""){
            val skillActivity = Intent(this, SkillActivity::class.java)
                skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)}
            else {
                Toast.makeText(this, "Please Select A League", Toast.LENGTH_SHORT).show()
            }
    }}

        fun onMensClicked(view: View) {
            if(!mens_leagueBTN.isChecked){   //if you are toggling the button OFF
                selectedLeague = ""             //remove the previously-selected league
            }else {                             //otherwise, if you are toggling the button ON
                womens_leagueBTN.isChecked = false
                coed_leagueBTN.isChecked = false
                selectedLeague = "mens"
            }
        }

        fun onWomensClicked(view: View) {
            if(!womens_leagueBTN.isChecked){
                selectedLeague = ""
            }else {
                mens_leagueBTN.isChecked = false
                coed_leagueBTN.isChecked = false
                selectedLeague = "womens"
            }
        }

        fun onCoedClicked(view: View) {
            if(!coed_leagueBTN.isChecked){
                selectedLeague = ""
            }else {
                mens_leagueBTN.isChecked = false
                womens_leagueBTN.isChecked = false
                selectedLeague = "coed"
            }
        }
}

