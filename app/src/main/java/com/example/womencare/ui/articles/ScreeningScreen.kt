package com.example.womencare.ui.articles

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.womencare.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CounselingFlowScreen() {
    var age by remember { mutableStateOf("") }
    var screenedRecently by remember { mutableStateOf<Boolean?>(null) }
    var knowsHPV by remember { mutableStateOf<Boolean?>(null) }
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {

        Text("Cervical Health Check", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("What is your age?") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        Text("Have you had a cervical screening before?")
        Row {
            RadioButtonWithLabel("Yes", screenedRecently == true) { screenedRecently = true }
            RadioButtonWithLabel("No", screenedRecently == false) { screenedRecently = false }
        }

        Spacer(Modifier.height(8.dp))

        Text("Do you know what HPV is?")
        Row {
            RadioButtonWithLabel("Yes", knowsHPV == true) { knowsHPV = true }
            RadioButtonWithLabel("No", knowsHPV == false) { knowsHPV = false }
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            val ageNum = age.toIntOrNull() ?: return@Button
            result = generateRecommendation(ageNum, screenedRecently, knowsHPV)
        }) {
            Text("Get Recommendation")
        }

        Spacer(Modifier.height(16.dp))

        if (result.isNotBlank()) {
            Text(result, style = MaterialTheme.typography.bodyLarge)
        }

        if (knowsHPV == false) {
            Spacer(modifier = Modifier.height(16.dp))
            HPVKnowledgeSection()
        }

        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun HPVKnowledgeSection() {
    Column {
        SectionTitle("🧬 What is HPV?")
        BulletPoints(
            listOf(
                "HPV (Human Papillomavirus) is very common.",
                "Spreads through skin-to-skin contact, often during sex.",
                "Most people get it at some point—usually clears on its own."
            )
        )

        SectionTitle("❗ Why is HPV important?")
        BulletPoints(
            listOf(
                "Some types can cause cervical cancer.",
                "High-risk types (16 and 18) cause most cases.",
                "Also linked to other cancers and genital warts."
            )
        )

        SectionTitle("🎯 Risk Factors for Cervical Cancer")
        BulletPoints(
            listOf(
                "Multiple sexual partners.",
                "Early sexual activity.",
                "Weakened immune system (e.g., HIV).",
                "Smoking.",
                "Skipping regular screenings.",
                "Not getting the HPV vaccine."
            )
        )

        SectionTitle("💉 HPV Vaccine")
        BulletPoints(
            listOf(
                "Protects against the most dangerous HPV types.",
                "Best before sexual activity, but adults can benefit too.",
                "Safe and effective."
            )
        )
    }
}
fun generateRecommendation(
    age: Int,
    screenedRecently: Boolean?,
    knowsHPV: Boolean?
): String {
    val mainMessage = when {
        age < 25 -> "You’re currently below the recommended screening age, but your awareness is powerful. Stay informed!"

        age in 25..49 && screenedRecently == false -> "You're due for a cervical screening. Let's help you schedule one."

        age in 25..49 && screenedRecently == true -> "You've had a screening recently—great job! Keep it up and stay informed."

        age in 50..64 && screenedRecently == false -> "It's time to start cervical screening. We'll guide you through the next steps."

        age in 50..64 && screenedRecently == true -> "You're doing a wonderful job taking care of your health!"

        age >= 65 && screenedRecently == true -> "Fantastic! You're staying proactive about your health."

        age >= 65 && screenedRecently == false -> "Please speak with a healthcare provider about whether you still need screening."

        else -> "Thank you for being here. You're taking a great step for your health."
    }

    val hpvMessage = if (knowsHPV == false) {
        "\n\n🔍 By the way, HPV (Human Papillomavirus) is the main cause of cervical cancer. Most people get it without knowing. Learning more can help protect your health!"
    } else {
        ""
    }

    return mainMessage + hpvMessage
}


@Composable
fun RadioButtonWithLabel(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(end = 16.dp)
            .clickable { onClick() }
    ) {
        RadioButton(
            selected = selected,
            onClick = null // handled by Row's clickable
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
}




@Preview(showBackground = true)
@Composable
fun PreviewCounselingFlowScreen() {
    MaterialTheme {
        CounselingFlowScreen()
        //CervicalCancerInfoScreen()
    }
}



@Composable
fun CervicalCancerInfoScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        androidx.compose.material3.Text(
            text = "Cervical Cancer",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        androidx.compose.material3.Text(
            text = "Cervical cancer is a type of cancer that starts in the cells of the cervix—the lower, narrow end of the uterus that connects to the vagina. It is one of the most preventable and treatable types of cancer when detected early.",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Section(title = "🧬 Cause") {
            androidx.compose.material3.Text(
                text = "The primary cause is persistent infection with high-risk types of human papillomavirus (HPV), especially types 16 and 18. HPV is a common sexually transmitted infection.",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Section(title = "🔍 Development") {
            androidx.compose.material3.Text(
                text = "Cervical cancer usually develops slowly over time:\n\n" +
                        "Normal cervical cells →\n" +
                        "Precancerous changes (cervical intraepithelial neoplasia, CIN) →\n" +
                        "Invasive cancer, if left untreated.",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Section(title = "⚠️ Symptoms") {
            BulletPoints(
                listOf(
                    "Abnormal vaginal bleeding (e.g., after sex, between periods, post-menopause)",
                    "Unusual vaginal discharge",
                    "Pelvic pain or pain during intercourse"
                )
            )
        }

        Section(title = "🛡️ Prevention") {
            BulletPoints(
                listOf(
                    "HPV vaccination (recommended before sexual activity begins)",
                    "Regular Pap smears and HPV testing (screening can detect precancerous changes)",
                    "Safe sex practices (e.g., condom use)"
                )
            )
        }

        Section(title = "🩺 Treatment") {
            BulletPoints(
                listOf(
                    "Surgery (e.g., hysterectomy)",
                    "Radiation therapy",
                    "Chemotherapy",
                    "Targeted therapy or immunotherapy in advanced stages"
                )
            )
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    androidx.compose.material3.Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
    content()
}

@Composable
fun BulletPoints(items: List<String>) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        items.forEach { item ->
            androidx.compose.material3.Text(
                text = "• $item",
                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
            )
        }
    }
}




