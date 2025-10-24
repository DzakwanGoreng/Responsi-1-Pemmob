package com.example.responsi1mobileh1d023094

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023094.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clubName = intent.getStringExtra("CLUB_NAME") ?: "Queens Park Rangers FC"
        val founded = intent.getIntExtra("CLUB_FOUNDED", 1882)
        val venue = intent.getStringExtra("CLUB_VENUE") ?: "Loftus Road Stadium"

        binding.tvHistoryTitle.text = "$clubName's History"

        val historyContent = """
Queens Park Rangers Football Club, commonly known as QPR, was founded in 1882 when Christchurch Rangers and St Jude's Institute FC merged to form Queens Park Rangers.

The club is based in White City, London, and has a rich history spanning over 140 years. QPR's traditional home colors are blue and white hoops, which have become iconic in English football.

Early Years and Formation

The club was formed following a meeting under a street lamp in Queens Park, an area in northwest London. The founding members decided to merge their two clubs to create a stronger team that could compete at a higher level.

Rise Through the Leagues

QPR spent many years working their way through the lower divisions of English football. The club's determination and community support helped them gradually climb the football league system.

Golden Era - 1970s

The 1970s marked QPR's most successful period. Under manager Dave Sexton, the club achieved promotion to the First Division in 1973. In the 1975-76 season, QPR finished as runners-up in the top flight, their highest-ever league finish, missing out on the title on goal difference.

During this era, QPR became known for playing attractive, attacking football and produced several England internationals. The team played at Loftus Road, their historic home since 1917, which became famous for its intimate atmosphere and passionate supporters.

Modern Era

QPR has experienced the highs and lows typical of English football, with periods in both the Premier League and Championship. The club won the Championship playoff in 2014 but has faced relegation battles and financial challenges in recent years.

Stadium and Identity

Loftus Road, with its capacity of around 18,000, remains one of the smallest and most atmospheric stadiums in English professional football. The ground is located in the Shepherd's Bush area of West London and has been QPR's home for over a century.

Community and Support

QPR has always maintained strong ties with its local community. The club's fanbase, while not the largest in London, is known for its loyalty and passion. The famous "R's" have a fierce rivalry with several London clubs, particularly Fulham in the West London derby.

Recent History

In recent years, QPR has focused on sustainable growth and developing young talent. The club competes in the Championship and continues to work towards returning to the Premier League while maintaining financial stability.

Legacy

Queens Park Rangers' contribution to English football extends beyond trophies. The club has been a breeding ground for talent, a pioneer in coaching methods, and a vital part of West London's sporting heritage. From its humble beginnings under a street lamp to competing at the highest levels of English football, QPR's story is one of resilience, community, and passion for the beautiful game.
        """.trimIndent()

        binding.tvHistoryContent.text = historyContent

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}