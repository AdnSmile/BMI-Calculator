package kt.tutorials.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnResult = findViewById<Button>(R.id.button)
        val viewResult = findViewById<TextView>(R.id.tvResult)
        val height: EditText = findViewById(R.id.etHeight)
        val weight: EditText = findViewById(R.id.etWeight)
        var result: Double


        btnResult.setOnClickListener {
            var numHeight = height.text.toString().toDouble()
            val numWeight = weight.text.toString().toDouble()

            if (numHeight > 0.0 && numWeight > 0.0){
                val say: String
                numHeight /= 100
                result = numWeight / (numHeight * numHeight)

                if (result < 18.5)
                    say = "are underweight."
                else if (result < 25)
                    say = "have a normal weight."
                else if (result < 30)
                    say = "are slightly overweight."
                else if (result < 35)
                    say = "are obese."
                else
                    say = "are clinically obese."

                val resultString = String.format("%.2f", result)

                viewResult.setText("Your BMI is $resultString, you $say")
            } else {
                Toast.makeText(this,
                    "Heignt or Number must greater than 0", Toast.LENGTH_LONG).show()

                viewResult.text = "Input your Height and Weight"
                height.setText("")
                weight.setText("")
            }
        }

    }
}