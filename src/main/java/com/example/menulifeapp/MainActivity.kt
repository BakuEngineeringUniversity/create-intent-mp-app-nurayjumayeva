import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer
import com.example.menulifeapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Profil resmi
        val profileImage = findViewById<ImageView>(R.id.profileImage)

        // E-posta linki
        val emailText = findViewById<TextView>(R.id.emailText)
        emailText.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:example@mail.com")
            }
            startActivity(emailIntent)
        }

        // Telefon linki
        val phoneText = findViewById<TextView>(R.id.phoneText)
        phoneText.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+901234567890")
            }
            startActivity(phoneIntent)
        }

        // Müzik çalar
        val playMusicButton = findViewById<Button>(R.id.playMusicButton)
        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music)
        playMusicButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            } else {
                mediaPlayer.pause()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
