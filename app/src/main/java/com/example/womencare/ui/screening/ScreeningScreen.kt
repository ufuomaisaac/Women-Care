import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.womencare.R
import com.example.womencare.ui.auth.signin.viewmodel.LanguageViewModel
import java.time.LocalDate

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreeningTrackerScreen(
    languageViewModel: LanguageViewModel
) {
    var isPlanning by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    val isYoruba by languageViewModel.isYoruba.collectAsState()

    val context = LocalContext.current
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie))

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                selectedDate = "$dayOfMonth/${month + 1}/$year"
            },
            LocalDate.now().year,
            LocalDate.now().monthValue - 1,
            LocalDate.now().dayOfMonth
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Spacer(Modifier.height(12.dp))

        // Title
        Text(
            text = if (isYoruba) "🎯 Akọ̀ọ́lẹ̀ Àyẹ̀wò Ìgbẹ́yà" else "🎯 Screening Tracker",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        // Planning Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = isPlanning, onCheckedChange = { isPlanning = it })
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isYoruba) "Mo ń gbero láti lọ sí àyẹ̀wò" else "I'm planning to go for a screening",
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // Date Picker Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isPlanning = true },
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = if (isYoruba) "Yan ọjọ́" else "Select a date",
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.CalendarToday, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isYoruba)
                            "Ọjọ́: ${if (selectedDate.isNotEmpty()) selectedDate else "Kò tíì yàn"}"
                        else
                            "Date: ${if (selectedDate.isNotEmpty()) selectedDate else "Not selected"}"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { datePickerDialog.show() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                    ) {
                        Text(if (isYoruba) "Yan Ọjọ́" else "Pick Date")
                    }
                }
            }
        }

        // Submit Button
        Button(
            onClick = {
                // Save or show confirmation
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0288D1))
        ) {
            Text(if (isYoruba) "Fipamọ́ Ìpinnu Ìdánwò" else "Save Screening Status")
        }

        // Feedback messages
        if (selectedDate.isNotEmpty()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    text = if (isYoruba)
                        "✅ Ọjọ́ tí o yan fún àyẹ̀wò rẹ̀ ni: $selectedDate. Ìgbésẹ̀ ńlá ni!"
                    else
                        "✅ Great job! The date for your screening is on $selectedDate.",
                    color = Color(0xFF2E7D32)
                )
            }
        } else if (isPlanning) {
            Text(
                text = if (isYoruba)
                    "📅 Dáa rárá! Má gbàgbé láti yàn ọjọ́ ayẹwo rẹ."
                else
                    "📅 Awesome! Don't forget to schedule your screening soon.",
                color = Color(0xFF00796B)
            )
        }
    }
}
